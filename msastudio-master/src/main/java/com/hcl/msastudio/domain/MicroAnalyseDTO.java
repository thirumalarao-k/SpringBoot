package com.hcl.msastudio.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author syed-s
 * 
 */


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
"cntrlrNm",
"accessPoints",
"cntrlrMethod",
"methodRef",
"seqFlow"
})
public class MicroAnalyseDTO extends ClassInfo{

	private static final long serialVersionUID = 1L;
	@JsonProperty("cntrlrNm")
	private String cntrlrNm;
	@JsonProperty("accessPoints")
	private String accessPoints;
	@JsonProperty("cntrlrMethod")
	private String cntrlrMethod;
	@JsonProperty("methodRef")
	private String methodRef;
	@JsonProperty("seqFlow")
	private String seqFlow;
	

}



