package com.hcl.msa.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.hcl.msa.entity.ClassInfo;
import com.hcl.msa.entity.MethodCallHierarchy;
import com.hcl.msa.entity.MethodInfo;
import com.hcl.msa.service.ClassInfoService;

@Controller
@RequestMapping("msa")
public class ClassInfoController {
	private final static Logger LOGGER = Logger.getLogger(ClassInfoController.class.getName());
	@Autowired
	private ClassInfoService classInfoService;

	@GetMapping("classinfo/{id}")
	public ResponseEntity<ClassInfo> getClassInfoById(@PathVariable("id") Integer id) {
		ClassInfo classInfo = classInfoService.getClassInfoById(id);
		return new ResponseEntity<>(classInfo, HttpStatus.OK);
	}

	@GetMapping("classinfo/{name}/{packageName}")
	public ResponseEntity<ClassInfo> getClassInfoByNameAndPackage(@PathVariable("name") String name,
			@PathVariable("packageName") String packageName) {
		ClassInfo classInfo = classInfoService.getClassInfoByNameAndPackage(name, packageName);
		return new ResponseEntity<>(classInfo, HttpStatus.OK);
	}

	@GetMapping("classinfos")
	public ResponseEntity<List<ClassInfo>> getAllClassInfos() {

		List<ClassInfo> list = classInfoService.getAllClassInfos();
		return new ResponseEntity<List<ClassInfo>>(list, HttpStatus.OK);
	}

	@PostMapping("classinfo")
	public ResponseEntity<Integer> addClassInfo(@RequestBody ClassInfo classInfo, UriComponentsBuilder builder) {
		LOGGER.log(Level.INFO, "Started addClassInfo");
		int classId = -1;
		try {
			classId = classInfoService.addClassInfo(classInfo);
			if (classId == -1) {
				return new ResponseEntity<Integer>(-1, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(builder.path("/classinfo/{id}").buildAndExpand(classInfo.getClassId()).toUri());
		return new ResponseEntity<Integer>(classId, HttpStatus.OK);
	}

	@PutMapping("classinfo")
	public ResponseEntity<ClassInfo> updateClassInfo(@RequestBody ClassInfo classInfo) {
		classInfoService.updateClassInfo(classInfo);
		return new ResponseEntity<ClassInfo>(classInfo, HttpStatus.OK);
	}

	@DeleteMapping("classinfo/{id}")
	public ResponseEntity<Void> deleteClassInfo(@PathVariable("id") Integer id) {
		classInfoService.deleteClassInfo(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("{projectId}/sterioType/{sterioTypeValue}")
	public ResponseEntity<List<ClassInfo>> getClassInfoByProjectAndSterioType(@PathVariable("projectId") String projectId,
								@PathVariable("sterioTypeValue") String sterioType) {
		List<ClassInfo> list = classInfoService.getClassInfoByProjectAndSterioType(projectId,sterioType);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("{projectId}/sterioTypes/{sterioTypeValues}")
	public ResponseEntity<List<ClassInfo>> getClassInfoByProjectAndSterioTypeList(@PathVariable("projectId") String projectId,
								@PathVariable("sterioTypeValues") String[] sterioTypes) {
		List<ClassInfo> list = classInfoService.getClassInfoByProjectAndSterioTypeList(projectId,sterioTypes);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("classinfos/{projectId}/sessionInfo")
	public ResponseEntity<List<ClassInfo>> getClassInfoByProjectAndSterioType(@PathVariable("projectId") String projectId) {
		List<ClassInfo> list = classInfoService.getClassInfoBySessionAttributes(projectId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("classinfos/{projectId}")
	public ResponseEntity<List<ClassInfo>> getClassInfoByProjectId(@PathVariable("projectId") String projectId) {
		LOGGER.log(Level.INFO, "Fetching class information by project id");
		List<ClassInfo> list = classInfoService.getClassInfoByProjectId(projectId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("classinfos/{projectId}/transactionInfo")
	public ResponseEntity<List<ClassInfo>> getClassInfoByProjectAndTransaction(@PathVariable("projectId") String projectId) {
		LOGGER.log(Level.INFO, "Fetching class information by project id for Transactions Info");
		List<ClassInfo> list = classInfoService.getClassInfoForTransactions(projectId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("classinfos/{projectId}/integrationInfo")
	public ResponseEntity<List<ClassInfo>> getClassInfoByProjectAndIntegrationComp(@PathVariable("projectId") String projectId) {
		LOGGER.log(Level.INFO, "Fetching class information by project id for Integration component Info");
		List<ClassInfo> list = classInfoService.getClassInfoForIntegrationComp(projectId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("classinfo/{projectId}/getSource/{className}")
	public ResponseEntity<List<ClassInfo>> getClassSourceByProjectIdAndClassName(@PathVariable("projectId") String projectId,@PathVariable("className") String className) {
		LOGGER.log(Level.INFO, "Fetching class source by project id");
		List<ClassInfo> list = classInfoService.getClassSourceByClassName(projectId,className);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("updateSequences/{projectId}")
	public ResponseEntity<List<ClassInfo>> updateCallSequences(@PathVariable("projectId") String projectId) {
		List<ClassInfo> list = classInfoService.getClassInfoByProjectId(projectId);
		for (ClassInfo classInfo : list) {			
			Set set=classInfo.getMethods();
			Set modifiedMethods=new HashSet();
				for (Object object : set) {
					MethodInfo mInfo=(MethodInfo)object;
					Set mchs=mInfo.getMethodCallHierarchy();
					Set addtnlMchs=new HashSet();
					for (Object object2 : mchs) {
						MethodCallHierarchy mch1=(MethodCallHierarchy)object2;
						LOGGER.log(Level.INFO, classInfo.getClassName()+": "+mch1.getMethodSequence());
						addtnlMchs=getMatchingSecondlevelSequence(list,mch1.getMethodRef(),mch1.getMethodSequence(),addtnlMchs);
					}
					addtnlMchs.addAll(mchs);
					mInfo.setMethodCallHierarchy(addtnlMchs);
					modifiedMethods.add(mInfo);
				}
				classInfo.setMethods(modifiedMethods);
				classInfoService.updateClassInfo(classInfo);
				System.out.println("Completed 2nd level: ");
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	private Set getMatchingSecondlevelSequence(List<ClassInfo> list,String methodRef,String methodSeqLevel1,Set addtnlMchs) {
		String temp="";
		for (ClassInfo classInfo : list) {			
			Set set=classInfo.getMethods();
				for (Object object : set) {
					MethodInfo mInfo=(MethodInfo)object;
					if(methodRef!=null && methodRef.equals(mInfo.getMethodName())) {
						Set mchs=mInfo.getMethodCallHierarchy();
						for (Object object2 : mchs) {
							MethodCallHierarchy mch1=(MethodCallHierarchy)object2;
							if(!methodSeqLevel1.equals(mch1.getMethodSequence()) || !methodSeqLevel1.contains("null")){
								LOGGER.log(Level.INFO, "########Updated Method Sequence#########: "+methodSeqLevel1+"->"+mch1.getMethodSequence());
							
								MethodCallHierarchy mchSecondLevel = new MethodCallHierarchy();
								mchSecondLevel.setIntegrationComp(mch1.getIntegrationComp());
								mchSecondLevel.setTechnology(mch1.getTechnology());
								mchSecondLevel.setTableNms(mch1.getTableNms());
								mchSecondLevel.setObjectRef(mch1.getObjectRef());
								mchSecondLevel.setProposedMicroService(mch1.getProposedMicroService());
								mchSecondLevel.setMethodRef(methodRef);
								mchSecondLevel.setMethodRefParams(mch1.getMethodRefParams());
								//Add second level sequences to the mch set
								temp=mch1.getMethodSequence();
								temp="null".equals(temp)?"":"->"+temp;
								mchSecondLevel.setMethodSequence(methodSeqLevel1+temp);
								//if(mch1.getMethodRef()!=null && !"".equals(mch1.getMethodRef().toString())) {
								addtnlMchs.add(mchSecondLevel);
								//}
							}
						}
						
					}
				}
				
		}
		return addtnlMchs;
	}
}
