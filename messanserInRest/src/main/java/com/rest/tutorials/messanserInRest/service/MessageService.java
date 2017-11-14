package com.rest.tutorials.messanserInRest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.rest.tutorials.messanserInRest.database.DatabaseClass;
import com.rest.tutorials.messanserInRest.exception.DataNotFoundException;
import com.rest.tutorials.messanserInRest.model.Message;

/**
 * this class is kind of stub class which will have connection to database and
 * fetch/post values from/to there
 * 
 * @author ketan
 *
 */
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

	// for filtering based on year
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messageListForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message msg : messages.values()) {
			cal.setTime(msg.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messageListForYear.add(msg);
			}
		}
		return messageListForYear;
	}

	// for pagination
	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> newList = new ArrayList<Message>(messages.values());
		if (start + size > newList.size())
			return null;
		return newList.subList(start, start + size);
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("Message with id :" + id + " not found");
		}
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
