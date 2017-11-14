package com.rest.tutorials.messanserInRest.reources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.rest.tutorials.messanserInRest.model.Message;
import com.rest.tutorials.messanserInRest.service.MessageService;

/**
 * These resources are main classes in REST API as we know any url will request
 * for the particular resource and in url that particular resource will be
 * identified via @Path("/messages")
 * 
 * @author ketan
 *
 */
@Path("/messages") // - by this jersey will know that this the resource class
public class MessageResource {

	MessageService service = new MessageService();

	@GET // - as we know there might be many method called for the same resource
			// therefore we need to mention which HTTP method correspond to this
			// method
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {// @QueryParam is used to capture the
											// query param in url

		if (year > 0) {
			return service.getAllMessagesForYear(year);
		} else if (start > 0 && size > 0) {
			return service.getAllMessagesPaginated(start, size);
		}
		return service.getAllMessages();
	}

	/*in case of @BeanParam above method will look like 
	getMessages(@BeanParam MessageFilterBean bean){
		if(bean.getYear()>0)
			.
			.
	}*/

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") long id) {

		return service.getMessage(id);

	}

	/*@POST
	@Produces(MediaType.APPLICATION_JSON) // if not mentioned produces xml
	@Consumes(MediaType.APPLICATION_JSON) // not necessary to mention . will
											// judge the format from ip i gues
	public Message addMessage(Message msg) {
		return service.addMessage(msg);
	}*/

	// for returning our own own status code and header values in response
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage2(@Context UriInfo uriInfo, Message msg) {
		Message newMessage = service.addMessage(msg);
		// return Response.status(Status.CREATED).header("location",
		// "hardcodeURI").entity(newMessage).build();

		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build())
				.entity(newMessage).build();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public Message updateMessage(@PathParam("messageid") long id, Message msg) {
		msg.setId(id);
		return service.updateMessage(msg);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public Message deleteMessage(@PathParam("messageid") long id) {
		return service.removeMessage(id);
	}

	// for all the comment resource url would be /messages/1/comments - to
	// return the comments on message id 1. so basically comment is sub resource
	// to the message , instead of having multiple methods over here itself we
	// will one below method which will return the comment resource itself
	@Path("/{messageid}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
