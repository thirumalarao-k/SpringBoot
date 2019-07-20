package com.hcl.msastudio.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DependencyDTO {
	private String dependencyNm;

	private String dependencyLib;

	private String dependencyVersion;

}
