package com.hcl.msa.bean;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DependencyInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String projectId;
	private String dependencyNm;

	private String dependencyLib;

	private String dependencyVersion;

}
