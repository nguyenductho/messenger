package vn.mobifone.thonguyen.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import vn.mobifone.thonguyen.messenger.database.DatabaseClass;
import vn.mobifone.thonguyen.messenger.model.Message;

public class MessageServices {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageServices() {
		//messages.put(1L, new Message(1, "Hello World", "koushik"));
		//messages.put(2L, new Message(2, "Hello Jersey", "koushik"));
	}
	
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			//throw new DataNotFoundException("Message with id " + id + " not found");
			return new Message(-1,"message does not exist", "error");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

}
