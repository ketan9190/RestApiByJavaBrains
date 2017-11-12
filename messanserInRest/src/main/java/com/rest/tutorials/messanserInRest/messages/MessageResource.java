package com.rest.tutorials.messanserInRest.messages;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.tutorials.messanserInRest.model.Message;
import com.rest.tutorials.messanserInRest.service.MessageService;

@Path("/messages") // - by this jersey will know that this the resource class
public class MessageResource {

	MessageService service = new MessageService();

	@GET // - as we know there might be many method called for the same resource
			// therefore we need to mention which HTTP method correspond to this
			// method
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return service.getAllMessages();
	}
}
