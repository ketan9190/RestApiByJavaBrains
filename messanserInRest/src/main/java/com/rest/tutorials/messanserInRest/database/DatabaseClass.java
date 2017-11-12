package com.rest.tutorials.messanserInRest.database;

import java.util.HashMap;
import java.util.Map;

import com.rest.tutorials.messanserInRest.model.Message;
import com.rest.tutorials.messanserInRest.model.Profile;

/**
 * this behave as mock DB which message service will use
 * 
 * @author ketan
 *
 */
public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
