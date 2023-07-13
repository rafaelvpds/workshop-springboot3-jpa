package com.rvweb.course.services.exeptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resourse not found. Id " + id);
	}

}
