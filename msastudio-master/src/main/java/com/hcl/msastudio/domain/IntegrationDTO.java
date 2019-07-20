package com.hcl.msastudio.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IntegrationDTO {
	private String methodRef;
	private String sequence;
	private String integComp;
	private String technology;
}
