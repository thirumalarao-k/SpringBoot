package com.hcl.msa.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.hcl.msa.bean.ClassInfo;
import com.hcl.msa.bean.Project;
import com.hcl.msa.bean.ProjectSetting;
import com.hcl.msa.dao.MSARestService;
import com.hcl.msa.parser.ejb.EJBVisitor;
import com.hcl.msa.parser.spring.Spring4Visitor;
import com.hcl.msa.parser.struts.Struts1Visitor;
import com.hcl.msa.parser.xml.XMLConfigFileParser;
import com.hcl.msa.parser.xml.ejb.ejb2.jaxbmodel.EjbJar;
import com.hcl.msa.parser.xml.struts.struts13.jaxbmodel.StrutsConfig;
import com.hcl.msa.util.DateUtility;
import com.hcl.msa.util.DirectoryScanner;

@Component
@Scope("request")
public class ApplicationParser {
	private final static Logger LOGGER = LoggerFactory.getLogger(ApplicationParser.class.getName());
	
	MSARestService restSevice=new MSARestService();
	
	/*private String APP_TYPE_SPRING4="SPRING4";
	private String APP_TYPE_SPRING3="SPRING3";
	private String APP_TYPE_EJB1="EJB1";*/
	
	@Autowired
    private ConfigurableEnvironment env;
	
	@Autowired
	private ProjectSetting projSet;
	
	// use ASTParse to parse string
	public void parse(String str,String projName,String projectId, List<String> classNameList,Map<String,Object> xmlConfigInfo) {
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(str.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		
		try {
			final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
			ASTVisitor codeVisitor=null;
			String visitorType= projSet.getTechnologyInfo().getParser();
			LOGGER.debug("Visitor Type "+ visitorType);
			//TODO Need to create VisitorFactory class to give visitor instance.
			if ("Spring4Visitor".equalsIgnoreCase(visitorType)) {
				codeVisitor=new Spring4Visitor(cu,projectId,classNameList);
			} else if ("EJBVisitor".equalsIgnoreCase(visitorType)) {
				codeVisitor=new EJBVisitor(cu,projectId,classNameList,xmlConfigInfo);
			}else if ("Struts1Visitor".equalsIgnoreCase(visitorType)){
				codeVisitor=new Struts1Visitor(cu,projectId,classNameList,xmlConfigInfo);
			}
			cu.accept(codeVisitor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String findApplicationType(String projName) {
		String visitorType = null;
		projSet = restSevice.getProjectSetting(projName);
		visitorType = projSet.getTechnologyInfo().getParser();
		return visitorType;
	}

	public void parseApplication(String applicationSourcePath) throws IOException {
		String rootDir = applicationSourcePath;
		LOGGER.info("Parsing Application Started for: " +rootDir);
		String projectName=rootDir.substring(rootDir.lastIndexOf("\\")+1);
		
		//Set Project/Application Setting before parsing
		findApplicationType(projectName);
		LOGGER.debug("Project Setting..."+projSet);
		
		if (projSet != null && projSet.getTechnologyId() != 0) {
			String jobId;
			String projectId;
			Project proj = new Project();
			proj.setCreatedBy("System");
			proj.setCreatedDateTime(DateUtility.getCurrentDate());
			proj.setProjectName(projectName);
			proj.setSourceCodeLocation(rootDir);
			proj.setSourcePackageName(projectName);
			proj.setModifiedBy(projSet.getCreatedBy());
			proj.setTechnologyId(projSet.getTechnologyId());

			projectId = restSevice.saveProjectInfo(proj);
			jobId = restSevice.saveJobInfo(projectId, projectName, proj.getCreatedDateTime());

			Map<String, List<Path>> filesByType = new TreeMap<String, List<Path>>();
			List<Path> fileList = new ArrayList<Path>();

			DirectoryScanner dirScanner = new DirectoryScanner();
			fileList = dirScanner.findAllMatchingFilesInDir(rootDir, ".xml");


			Object ejbjarConfig=null;
			StrutsConfig strutsConfig = null;
			Map<String,Object> xmlConfigInfo = new HashMap<>();
			
			for (Iterator<Path> iterator = fileList.iterator(); iterator.hasNext();) {
				Path path = iterator.next();
				String fileName=String.valueOf(path.getFileName());
				if(fileName.endsWith("pom.xml")) {
					restSevice.saveDependentInfo(path.toFile().getAbsolutePath(), projectId,jobId);
				}else if (fileName.endsWith("ejb-jar.xml")){
					String ejbVersion = XMLConfigFileParser.findVersion(path);
					if (ejbVersion.contains("2_1")) {
						ejbjarConfig = XMLConfigFileParser.ejb21JarXmlParser(path);
					}else if (ejbVersion.contains("2_0")) {
						ejbjarConfig = XMLConfigFileParser.ejb2JarXmlParser(path);
					}else if (ejbVersion.contains("3_0")) {
						ejbjarConfig = XMLConfigFileParser.ejb3JarXmlParser(path);
					}
					xmlConfigInfo.put("ejbjarConfig", ejbjarConfig);
				}else if (fileName.endsWith("build.xml")) {// For Ant
					//restSevice.saveDependentInfoForANT(path.toFile().getAbsolutePath(), projectId, jobId);
				}else if(fileName.endsWith("struts-config.xml")){
					strutsConfig = XMLConfigFileParser.struts13XmlParser(path);
					xmlConfigInfo.put("strutsConfig", strutsConfig);
				}
				//parse(dirScanner.readFileToString(path.toFile().getAbsolutePath()), jobId);
			}
			
			LOGGER.debug(">>>>> Parsed XML files >>>>> " + fileList.size());
			filesByType.put("xml", fileList);
			
			fileList = dirScanner.findAllMatchingFilesInDir(rootDir, ".java");

			List<String> classNameList = new ArrayList<>();
			// Set the application's class List
			for (Path path : fileList) {
				classNameList.add(path.toFile().getName().replace(".java", ""));
			}

			for (Iterator<Path> iterator = fileList.iterator(); iterator.hasNext();) {
				Path path = iterator.next();
				parse(dirScanner.readFileToString(path.toFile().getAbsolutePath()), projectName, projectId,
						classNameList,xmlConfigInfo);
			}
			
			//Set multilevel method call hierarchy
			setMultilevelCallHierarchy();
			
			LOGGER.debug(">>>>> Parsed JAVA files >>>>> " + fileList.size());
			filesByType.put("java", fileList);

			fileList = dirScanner.findAllMatchingFilesInDir(rootDir, ".html");
			/*for (Iterator<Path> iterator = fileList.iterator(); iterator.hasNext();) {
				Path path = iterator.next();
				//parse(dirScanner.readFileToString(path.toFile().getAbsolutePath()));
			}*/
			LOGGER.debug(">>>>> Parsed HTML files >>>>> " + fileList.size());
			filesByType.put("html", fileList);

			fileList = dirScanner.findAllMatchingFilesInDir(rootDir, ".properties");
			/*for (Iterator<Path> iterator = fileList.iterator(); iterator.hasNext();) {
				Path path = iterator.next();
				//parse(dirScanner.readFileToString(path.toFile().getAbsolutePath()));
			}*/
			LOGGER.debug(">>>>> Parsed PROPERTIES files >>>>> " + fileList.size());
			filesByType.put("properties", fileList);

			restSevice.setProjectId(projectId);
			// Insert files list in DB
			restSevice.persistFilesList(filesByType);
			// Updating Job Status
			restSevice.updateJobStatus(jobId);
			LOGGER.debug("Job Status Updated");
		} else {
			LOGGER.debug("Project Info is not persisted in DB to analyse");
		}
	}
	
	private void setMultilevelCallHierarchy(){
		ResponseEntity<String> response=restSevice.updateSequences("PROJ100");
	}
	
}
