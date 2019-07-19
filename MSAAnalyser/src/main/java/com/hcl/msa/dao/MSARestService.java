package com.hcl.msa.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Parent;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.tools.ant.ProjectHelper;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msa.bean.ClassInfo;
import com.hcl.msa.bean.DependencyInfo;
import com.hcl.msa.bean.JobInfo;
import com.hcl.msa.bean.Project;
import com.hcl.msa.bean.ProjectFileInfo;
import com.hcl.msa.bean.ProjectSetting;
import com.hcl.msa.parser.ApplicationParser;
import com.hcl.msa.util.DateUtility;
import com.hcl.msa.util.MSAConstants;



public class MSARestService {
	private final static Logger LOGGER = LoggerFactory.getLogger(MSARestService.class.getName());

	RestTemplate restTemplate = new RestTemplate();
	private static final String BASE_URL_MSA_REST_SERVICE = "http://localhost:9090/msa/";
	private static final String PATH_FILE_INFO = "projectFileInfo";
	private static final String PATH_PROJECT = "project";
	private static final String PATH_JOB = "job";
	private static final String PATH_DEPENDENT_INFO = "dependencyInfo";
	private static final String PATH_PROJECT_SETTING = "projectSetting";
	private String projectId;
	
	public ProjectSetting getProjectSetting(String projName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String uri = BASE_URL_MSA_REST_SERVICE+ PATH_PROJECT_SETTING +"/"+projName;
		ResponseEntity <ProjectSetting> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <ProjectSetting> () {});
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		
		ProjectSetting projSet= response.getBody();

		return projSet;
	}
	
	public void persistFilesList(Map<String, List<Path>> filesList) {
		System.out.println(" >>>>> BEFORE PERSISTING FILE INFO "+filesList.size());
		saveFileInfo(filesList.get("java"));
		saveFileInfo(filesList.get("xml"));
		saveFileInfo(filesList.get("html"));
		saveFileInfo(filesList.get("properties"));
		System.out.println(">>>>> PERSISTED FILE LIST INFO >>>>> "+filesList.size());
	}

	public void saveFileInfo(List<?> x) {
		List<ProjectFileInfo> list=new ArrayList<ProjectFileInfo>();
		ProjectFileInfo pfInfo;
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString=null;
		for (Iterator<?> iterator = x.iterator(); iterator.hasNext();) {
			Path path = (Path) iterator.next();
			try {
				pfInfo=new ProjectFileInfo();
				int dotIndex=path.toFile().getName().lastIndexOf(".");
				pfInfo.setProjectId(getProjectId());
				pfInfo.setFileName(path.getFileName().toString());
				pfInfo.setFilePath(path.toAbsolutePath().toString());
				pfInfo.setFileExtn(path.toFile().getName().substring(dotIndex));
				list.add(pfInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonInString);
		if(jsonInString!=null)
		msaRestServiceCall(jsonInString, "INSERT",PATH_FILE_INFO);
	}
	public String saveProjectInfo(Project projectInfo) {
		
		System.out.println(projectInfo);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString=null;
		try {			
			jsonInString = mapper.writeValueAsString(projectInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" >>>>> BEFORE PERSISTING PROJECT INFO "+jsonInString);
		String projectId=null;
		
		if (jsonInString != null) {
			projectId = msaProjectServiceCall(jsonInString, "INSERT", PATH_PROJECT);
		}
		System.out.println(">>>>> PERSISTED PROJECT INFO >>>>> "+projectId);
		System.out.println(">>>>> PERSISTED PROJECT INFO >>>>> "+projectInfo.getProjectName());
		
		return projectId;
	}
	
	

	public String msaRestServiceCall(String jsonInString, String operationType, String path) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		String uri = BASE_URL_MSA_REST_SERVICE+path;
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonInString, headers);
		ResponseEntity<String> result=null;
		String resultStr="";
		try {
			result=restTemplate.postForEntity(uri, requestEntity,String.class);
			resultStr=result.getBody();
		} catch (Exception e) {
			//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+jsonInString);
			e.printStackTrace();
		}
		
		return resultStr;
	}

	public String msaProjectServiceCall(String jsonInString, String operationType, String path) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		String uri = BASE_URL_MSA_REST_SERVICE+path;
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonInString, headers);
		ResponseEntity<String> result=null;
		String resultStr="";
		try {
			result=restTemplate.postForEntity(uri, requestEntity,String.class);
			resultStr=result.getBody();
		} catch (Exception e) {
			//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+jsonInString);
			e.printStackTrace();
		}
		return resultStr;
	}
	
	
	
	public String msaJobServiceCall(String jsonInString, String operationType, String path) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		String uri = BASE_URL_MSA_REST_SERVICE+path;
		HttpEntity<String> requestEntity = new HttpEntity<>(jsonInString, headers);
		ResponseEntity<String> result=null;
		try {
			result=restTemplate.postForEntity(uri, requestEntity,String.class);
			
		} catch (Exception e) {
			//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+jsonInString);
			e.printStackTrace();
		}
		String result1 = result.getBody();
		return result1;
	}

	public void saveDependentInfo(String fileName, String projectId, String jobId) {
		
		List<DependencyInfo> dependencyInfoList = new ArrayList<DependencyInfo>();
		MavenXpp3Reader reader = new MavenXpp3Reader();
		Model model = null;
		try {
			model = reader.read(new FileReader(fileName));
		} catch (IOException | XmlPullParserException e1) {
			e1.printStackTrace();
		}
		//System.out.println("TESTING..."+model.getProperties());
		List<Dependency> dependencies = model.getDependencies();
		for (int i = 0; i < dependencies.size(); i++) {
			DependencyInfo info = new DependencyInfo();
			System.out.println(dependencies.get(i));
			info.setProjectId(projectId);
			info.setDependencyNm(dependencies.get(i).getArtifactId());
			info.setDependencyLib(dependencies.get(i).getArtifactId());
			String version = null;
			if(dependencies.get(i).getVersion() !=null)
				version = dependencies.get(i).getVersion();
			else {
				Parent parent=model.getParent();
				version=parent.getVersion();
			}
			//replace the property parameter in the version
			if(version != null && model.getProperties().containsKey(version.replaceAll("[${}]", ""))) {
				version= model.getProperties().getProperty(version.replaceAll("[${}]", ""));
			}
			info.setDependencyVersion(version);
			
			dependencyInfoList.add(info);
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(dependencyInfoList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonInString);
		System.out.println("Rest Service for DependencyReport");
		if (jsonInString != null) {
			msaRestServiceCall(jsonInString, "INSERT", PATH_DEPENDENT_INFO);
		}
		System.out.println("Rest Service for DependencyReport Done");
	}
	
	//TODO Need to check
	public void saveDependentInfoForANT(String fileName, String projectId, String jobId) {
		org.apache.tools.ant.Project project = new org.apache.tools.ant.Project();
		File buildFile = new File(fileName);
		project.init();
		ProjectHelper.configureProject(project, buildFile); 
		
		//Load Properties list if any included using <xmlproperty> or <property> tag 
		/* To do */
		Boolean rwar=project.getProperties().isEmpty();
		for (Entry<String, Object> e : project.getProperties().entrySet()) {
			System.out.println(e);
		}
		
		//Get the classpath
		Path path = (Path) project.getReference("classpath");
		
		/*if() {
			
		}else {
			List<Path> fileList = new ArrayList<Path>();
			fileList = dirScanner.findAllMatchingFilesInDir(rootDir, ".java");
		}
		 */
		
		
		//Fetch all jar files' name from classpath lib 
		List<DependencyInfo> dependencyInfoList = new ArrayList<DependencyInfo>();
		
		//save
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(dependencyInfoList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonInString);
		System.out.println("Rest Service for DependencyReport");
		if (jsonInString != null) {
			msaRestServiceCall(jsonInString, "INSERT", PATH_DEPENDENT_INFO);
		}
		System.out.println("Rest Service for DependencyReport Done");
		
	}
	
	public String saveJobInfo(String projectId, String projectName, String startTime) {
		JobInfo jobInfo = new JobInfo();
		jobInfo.setJobName(projectName);
		jobInfo.setProjectId(projectId);
		jobInfo.setCreatedTime(startTime);
		jobInfo.setStatus(MSAConstants.JOB_INPROGRESS);
		jobInfo.setJobType(projectName);
		jobInfo.setProjectName(projectName);

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(jobInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jobId=null;
		System.out.println("Rest Service Inserting Job Details  ");

		if (jsonInString != null) {
			jobId =  msaJobServiceCall(jsonInString, "INSERT", PATH_JOB);
			System.out.println(">>>>> PERSISTED PROJECT INFO >>>>> " + jobInfo.getJobId());
		}

		return jobId;
	}

	
	public void updateJobStatus(String jobId) {

		JobInfo jobInfo = new JobInfo();
		jobInfo.setJobId(jobId);
		jobInfo.setUpdatedTime(DateUtility.getCurrentDate());
		jobInfo.setStatus(MSAConstants.JOB_COMPLETED);

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(jobInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Updating Job Details");

		if (jsonInString != null) {
			jobId =  msaJobServiceCall(jsonInString, "UPDATE", PATH_JOB);
		}
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public ResponseEntity updateSequences(String projectId) {
		LOGGER.debug("Entering Method: getMicroServiceAnalysisReport");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String uri = BASE_URL_MSA_REST_SERVICE +"/updateSequences/"+ projectId;

		ResponseEntity < List < ClassInfo >> response=null;
		try {
			response = restTemplate.exchange(uri,
					HttpMethod.GET, null, new ParameterizedTypeReference <List<ClassInfo>> () {});
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		

		return response;
	}
	
}
