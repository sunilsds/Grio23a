package com.grio23util;

public class Environment {

	String filepath = "/src/main/resources/Environment.properties";

	public String getAppurl() {

		PropUtil prop = new PropUtil();

		String baseDir = System.getProperty("user.dir");

		return prop.getValue(baseDir + filepath, "app_url");
	}

	
	public String getAppurlAjio() {

		PropUtil prop = new PropUtil();

		String baseDir = System.getProperty("user.dir");

		return prop.getValue(baseDir + filepath, "app_url_ajio");
	}

	
	public String getAppurlYepMe() {

		PropUtil prop = new PropUtil();

		String baseDir = System.getProperty("user.dir");

		return prop.getValue(baseDir + filepath, "app-url-yepme");
	}
}
