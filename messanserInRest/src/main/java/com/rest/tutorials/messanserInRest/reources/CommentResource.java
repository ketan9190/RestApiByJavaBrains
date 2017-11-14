package com.rest.tutorials.messanserInRest.reources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {
	// we can write comment service similar to message service and implement
	// this resource as well in similar way
	@GET
	@Path("/123")
	public String test() {
		return "in sub resource";
	}
}
