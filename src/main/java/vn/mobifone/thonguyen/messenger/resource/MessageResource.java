package vn.mobifone.thonguyen.messenger.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import vn.mobifone.thonguyen.messenger.model.Message;
import vn.mobifone.thonguyen.messenger.service.MessageServices;

@Path("messages")
public class MessageResource {
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	
	MessageServices messageService = new MessageServices();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages() {
		return messageService.getAllMessages();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		
		Message newMessage = messageService.addMessage(message);
		return newMessage;
		
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) {
		Message message = messageService.getMessage(id);
		return message;
		
	}
	

	
}
