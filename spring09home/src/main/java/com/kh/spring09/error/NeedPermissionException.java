package com.kh.spring09.error;

public class NeedPermissionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NeedPermissionException() {
		super();
	}
	public NeedPermissionException(String message) {
		super(message);
	}
}