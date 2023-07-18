package com.avisys.empmgmt.exception;

public class DepartmentException extends Exception {

	private static final long serialVersionUID = 1L;

	public DepartmentException(String message) {
	        super(message);
	    }

//	    @Override
//	    public String toString() {
//	        return "Unable to find Data:" + getMessage();
//	    }
}
