package com.hcl.msa.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.msa.entity.ClassInfo;
import com.hcl.msa.entity.MethodCallHierarchy;
import com.hcl.msa.entity.MethodInfo;
import com.hcl.msa.repository.ClassInfoRepository;
import com.hcl.msa.service.ClassInfoService;

@Service
public class ClassInfoServiceImpl implements ClassInfoService {
	
	@Autowired
	private ClassInfoRepository classInfoRepository;

	@Override
	public ClassInfo getClassInfoById(int classId) {
		ClassInfo obj = classInfoRepository.findOne(classId);
		return obj;
	}

	@Override
	public ClassInfo getClassInfoByNameAndPackage(String className, String packageName) {
		ClassInfo obj = classInfoRepository.findByClassNameAndPackageName(className, packageName);
		return obj;
	}

	@Override
	public List<ClassInfo> getAllClassInfos() {
		return classInfoRepository.findAll();
	}

	@Override
	public synchronized int addClassInfo(ClassInfo classInfo) {
		ClassInfo obj = classInfoRepository.findByClassNameAndPackageName(classInfo.getClassName(),
				classInfo.getPackageName());
		if (obj != null) {
			return -1;
		} else {
			ClassInfo classInfoResponse = classInfoRepository.save(classInfo);
			return classInfoResponse.getId();
		}
	}

	@Override
	public void updateClassInfo(ClassInfo classInfo) {
		classInfoRepository.save(classInfo);
	}

	@Override
	public void deleteClassInfo(int classId) {
		classInfoRepository.delete(classId);
	}

	@Override
	public List<ClassInfo> getClassInfoByProjectAndSterioType(String projectId, String sterioType) {
		return classInfoRepository.findByProjectIdAndSterioType(projectId,sterioType);
	}
	
	@Override
	public List<ClassInfo> getClassInfoByProjectAndSterioTypeList(String projectId, String[] sterioTypes) {
		return classInfoRepository.findByProjectIdAndSterioTypeIn(projectId,Arrays.asList(sterioTypes));
	}

	@Override
	public List<ClassInfo> getClassInfoByProjectId(String projectId) {
		return classInfoRepository.findByProjectId(projectId);
	}

	@Override
	public List<ClassInfo> getClassInfoBySessionAttributes(String projectId) {
		List<ClassInfo> cinfo = classInfoRepository.findByProjectIdAndSessionAttributesNot(projectId,"");
		//filter session attributes in method level as well
		List<ClassInfo> modCinfo = new ArrayList<>();
		
		for (ClassInfo classInfo : cinfo) {
			Set<MethodInfo> minfo = classInfo.getMethods();			
			Set<MethodInfo> modMinfo = new HashSet<>();
			
			for (MethodInfo methodInfo : minfo) {				
				if(null != methodInfo.getSessionAttributes() && !methodInfo.getSessionAttributes().isEmpty()) {
					String params = methodInfo.getMethodParams();
					if(null != params && !params.isEmpty()) {
						String args[] = params.replaceAll("[\\[\\]]", "").split(",");
						StringBuilder strb = new StringBuilder();
						for (String str : args) {
							if(!(str.contains("HttpSession") || str.contains("SessionStatus"))) {
								strb.append(str).append(",");								
							}
						}
						strb.append(methodInfo.getSessionAttributes().replaceAll("[\\[\\]]", " "));
						methodInfo.setMethodParams(strb.toString());
					}
					modMinfo.add(methodInfo);
				}
			}
			
			classInfo.setMethods(modMinfo);
			modCinfo.add(classInfo);
		}
		
		return modCinfo;
	}
	
	@Override
	public List<ClassInfo> getClassInfoForTransactions(String projectId) {
		List<ClassInfo> cinfo = classInfoRepository.findByProjectId(projectId);
		//Filter for transaction annotations if any
		List<ClassInfo> modCinfo = new ArrayList<>();
		for (ClassInfo classInfo : cinfo) {
			if(classInfo.getAnnotations().toLowerCase().contains("transaction")){
				modCinfo.add(classInfo);
				continue;
			}
			
			Set<MethodInfo> minfo = classInfo.getMethods();
			Set<MethodInfo> modMinfo = new HashSet<>();
			for (MethodInfo methodInfo : minfo) {
				if(null != methodInfo.getAnnotations() && methodInfo.getAnnotations().toLowerCase().contains("transaction")) {
					modMinfo.add(methodInfo);
				}
			}
			
			if(!modMinfo.isEmpty()) {
				classInfo.setMethods(modMinfo);
				modCinfo.add(classInfo);
			}
		}
		
		return modCinfo;
	}
	
	@Override
	public List<ClassInfo> getClassSourceByClassName(String projectId, String className) {
		return classInfoRepository.findByProjectIdAndClassName(projectId,className);
	}

	@Override
	public List<ClassInfo> getClassInfoForIntegrationComp(String projectId) {
		List<ClassInfo> cinfo = classInfoRepository.findByProjectId(projectId);
		//Filter for integration technology if any
		List<ClassInfo> modCinfo = new ArrayList<>();
		for (ClassInfo classInfo : cinfo) {			
			Set<MethodInfo> minfo = classInfo.getMethods();
			Set<MethodInfo> modMinfo = new HashSet<>();
			for (MethodInfo methodInfo : minfo) {
				Set<MethodCallHierarchy> mchInfo = methodInfo.getMethodCallHierarchy();
				Set<MethodCallHierarchy> modMchinfo =  new HashSet<>();
				for (MethodCallHierarchy methodCallHierarchy : mchInfo) {
					if(null != methodCallHierarchy.getTechnology() && !methodCallHierarchy.getTechnology().isEmpty() ) {
						if(null != methodCallHierarchy.getMethodRef() && methodCallHierarchy.getMethodRef().isEmpty()) {
							methodCallHierarchy.setMethodRef(methodInfo.getMethodName());
						}						
						modMchinfo.add(methodCallHierarchy);
					}
				}
				
				if(!modMchinfo.isEmpty()) {
					methodInfo.setMethodCallHierarchy(modMchinfo);
					modMinfo.add(methodInfo);
				}
				
			}
			
			if(!modMinfo.isEmpty()) {
				classInfo.setMethods(modMinfo);
				modCinfo.add(classInfo);
			}
		}
		
		return modCinfo;
	}

}
