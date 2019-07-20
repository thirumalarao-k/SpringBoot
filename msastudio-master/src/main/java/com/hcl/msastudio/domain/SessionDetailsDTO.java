package com.hcl.msastudio.domain;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class SessionDetailsDTO {

	private String methodRef;

	private String seqFlow;

	private String sessionObfRef;

	private String paramfRef;

	private String regroupedParam;
	
	private String impactService;
}
