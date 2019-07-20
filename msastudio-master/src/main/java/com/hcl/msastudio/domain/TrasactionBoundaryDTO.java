package com.hcl.msastudio.domain;

import com.fasterxml.jackson.annotation.JsonInclude;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TrasactionBoundaryDTO {

	private String methodRef;
	private String transSeq;
	private String microService;
	private String transMethods;
	private String transFacade;

}



