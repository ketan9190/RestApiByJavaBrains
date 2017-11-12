package com.rest.tutorials.messanserInRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rest.tutorials.messanserInRest.database.DatabaseClass;
import com.rest.tutorials.messanserInRest.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		Profile m1 = new Profile(1l, "ketan", "ketan", "gupta");
		Profile m2 = new Profile(2l, "profile2", "ketan", "gupta");
		profiles.put(m1.getProfileName(), m1);
		profiles.put(m2.getProfileName(), m2);
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String name) {
		return profiles.get(name);
	}

	public Profile addProfile(Profile m) {
		m.setId(profiles.size() + 1);
		profiles.put(m.getProfileName(), m);
		return m;
	}

	public Profile updateProfile(Profile m) {

		if (profiles.containsKey(m.getProfileName())) {
			profiles.put(m.getProfileName(), m);
			return m;
		} else
			return null;
	}

	public Profile removeProfile(String name) {
		return profiles.remove(name);
	}

}
