package com.hcl.msastudio.domain;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MasterData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String className;
	private String packageName;
	private String sterioType;
	private String noOfMethods;
	private String interfaces;
	private String superClass;
	private String loc;
	private String annotations;
	private String importStmnts;
	private Set<MethodInfo> methods;
	private String sourceCode;
	private String jobId;
}
