package com.rest.tutorials.messanserInRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rest.tutorials.messanserInRest.database.DatabaseClass;
import com.rest.tutorials.messanserInRest.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		Message m1 = new Message(1l, "Hello World!", "ketan");
		Message m2 = new Message(2l, "Hello Jersey!", "ketan");
		messages.put(m1.getId(), m1);
		messages.put(m2.getId(), m2);
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message m) {
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}

	public Message updateMessage(Message m) {

		if (messages.containsKey(m.getId())) {
			messages.put(m.getId(), m);
			return m;
		} else
			return null;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
