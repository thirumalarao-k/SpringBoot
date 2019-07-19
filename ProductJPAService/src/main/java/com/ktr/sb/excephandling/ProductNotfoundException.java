package com.ktr.sb.excephandling;

public class ProductNotfoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public String excpMessage;
	public ProductNotfoundException(String excpMessage) {
		this.excpMessage = excpMessage;
	}

	
	}