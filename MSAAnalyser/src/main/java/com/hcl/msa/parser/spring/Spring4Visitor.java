package com.hcl.msa.parser.spring;

import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.msa.dao.MSARestService;
import com.hcl.msa.parser.JavaVisitor;

public class Spring4Visitor extends JavaVisitor {
	private final static Logger LOGGER = LoggerFactory.getLogger(Spring4Visitor.class.getName());
	private String projectId;
	
	public Spring4Visitor(CompilationUnit cu, String projectId, List<String> classNameList) {
		super();
		LOGGER.debug("Calling Spring4Visitor");
		this.cu = cu;
		this.projectId = projectId;
		this.classNames = classNameList;
		cinfo.setProjectId(projectId);
	}

	public boolean visit(TypeDeclaration node) {
		LOGGER.debug("Spring4Visitor : Calling visit method for:"+node.getName().toString());
		try {
			setApplicationTechnology("Spring4");
			parseClassModifiers(node);
			parseClassSterioType(node);
			parseClassInfo(node);
			parseMethodInfo(node);
			String locStr=cu.getLineNumber(cu.toString().lastIndexOf("}"))+"";
			if(locStr!=null && !locStr.equals("-1"))
			cinfo.setLoc(locStr);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(cinfo);
			
			// Save all infos like class, method and methods' call hierarchy
			MSARestService restSevice = new MSARestService();
			restSevice.msaRestServiceCall(jsonInString, INSERT, PATH_CLASSINFO);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return true; // do continue
	}
}
