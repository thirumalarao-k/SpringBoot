package com.hcl.swedbank.homeinsurance.api.exception;

@javax.annotation.Generated(value = "class com.hcl.swedbank.homeinsurance.codegen.languages.SpringCodegen", date = "2017-05-19T06:17:46.555Z")

public class ApiException extends Exception{
	public ApiException (int code, String msg) {
		super(msg);
	}
}
