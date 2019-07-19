package com.hcl.msa.service;

import java.util.List;

import com.hcl.msa.entity.ClassInfo;

public interface ClassInfoService {
	List<ClassInfo> getAllClassInfos();
	ClassInfo getClassInfoById(int classId);
	int addClassInfo(ClassInfo classInfo);
	void updateClassInfo(ClassInfo classInfo);
	void deleteClassInfo(int classId);
	ClassInfo getClassInfoByNameAndPackage(String className, String packageName);
	List<ClassInfo> getClassInfoByProjectAndSterioType(String projectId, String sterioType);
	List<ClassInfo> getClassInfoBySessionAttributes(String projectId);
	List<ClassInfo> getClassInfoByProjectId(String projectId);
	List<ClassInfo> getClassSourceByClassName(String projectId, String className);
	List<ClassInfo> getClassInfoByProjectAndSterioTypeList(String projectId, String[] sterioType);
	List<ClassInfo> getClassInfoForTransactions(String projectId);
	List<ClassInfo> getClassInfoForIntegrationComp(String projectId);
}
