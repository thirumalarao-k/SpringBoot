package com.hcl.msastudio.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ObjectRefDTO {
	private String classNm;

	private String objectRef;

	private String seqFlow;

}
