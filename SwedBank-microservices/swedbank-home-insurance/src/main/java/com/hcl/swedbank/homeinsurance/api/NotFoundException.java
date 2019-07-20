package com.hcl.swedbank.homeinsurance.api;


public class NotFoundException extends ApiException {
	public NotFoundException (int code, String msg) {
		super(code, msg);
	}
}
