package com.grio23util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public String getValue(String filepath, String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.err.println("file not found" + filepath);
		}

		Properties prop = new Properties();

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.err.println("unable to load properties file:" + filepath);
		}

		return prop.getProperty(key);

	}

	/**
	 * This method can be used on OR.properties file only
	 * 
	 * @param key for which we want the locator
	 * @return the locator value in the form of{@code String}
	 */

	public String[] getLocator(String key) {

		String baseDir = System.getProperty("user.dir");// CWD
		return getValue(baseDir + "/src/main/resources/OR.properties", key).split("##");

	}

}
