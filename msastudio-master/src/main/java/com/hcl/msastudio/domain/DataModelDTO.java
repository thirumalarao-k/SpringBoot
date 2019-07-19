package com.hcl.msastudio.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataModelDTO {
	
	private String methodRef;
	private String methodSeq;
	private String microService;
	private String entityData;
	private String tableNm;
	private String queries;
	private String serviceNm;

}
