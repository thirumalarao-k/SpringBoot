package com.hcl.msa.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hcl.msa.entity.ClassInfo;

public interface ClassInfoRepository extends JpaRepository<ClassInfo, Integer> {
	
	ClassInfo findByClassNameAndPackageName(String className, String packageName);

	List<ClassInfo> findByProjectIdAndSterioType(String projectId, String sterioType);

	List<ClassInfo> findByProjectId(String projectId);

	List<ClassInfo> findByProjectIdAndSessionAttributesNot(String projectId,String sessionAttVal);

	List<ClassInfo> findByProjectIdAndClassName(String projectId, String className);
	
	List<ClassInfo> findByProjectIdAndSterioTypeIn(String projectId, List<String> sterioTypes);

}
 