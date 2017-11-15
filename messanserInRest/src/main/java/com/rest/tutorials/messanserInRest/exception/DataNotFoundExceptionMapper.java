package com.rest.tutorials.messanserInRest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.rest.tutorials.messanserInRest.model.ErrorMessage;

@Provider // need to mention this to register this class with jersey
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage error = new ErrorMessage(exception.getMessage(), 404, "something");
		// create error msg and mapped it to response which will be send to end
		// user
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
