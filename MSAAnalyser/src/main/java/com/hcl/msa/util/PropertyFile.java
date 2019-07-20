package com.hcl.msa.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PropertyFile {
	private static Map<String, String> props = new HashMap<String, String>();

	private static PropertyFile instance = null;

	private PropertyFile() {
		load();
	}


	public static PropertyFile getInstance() {
		if (instance == null) {
			instance = new PropertyFile();
		}
		return instance;
	}

	private static void load() {

		try {
			ResourceBundle bundle = ResourceBundle.getBundle("config");
			Enumeration<String> e = bundle.getKeys();
			while (e.hasMoreElements()) {
				String config = e.nextElement();
				String value = bundle.getString(config);
				props.put(config, value);
			}

		} catch (Exception e) {
			System.out.println("Error retrieving properties file: " + e);
		}

	}


	public String getTechnology(String obj) {

		for (Map.Entry<String, String> entry : props.entrySet()) {
			if(entry.getKey().equals("Rest_Template")) {
				 if (obj != null && entry.getValue().equalsIgnoreCase(obj)) {
					return entry.getKey();
				} 
			}
			else if (obj != null && entry.getValue().contains(obj)) {
				return entry.getKey();
			} 
		}
		return "";

	}
	public static void main(String[] args) {
		load();
		//getTechnology("getForObject");

	}
}
