package com.hcl.swedbank.homeinsurance.api;


public class ApiException extends Exception{
	public ApiException (int code, String msg) {
		super(msg);
	}
}
