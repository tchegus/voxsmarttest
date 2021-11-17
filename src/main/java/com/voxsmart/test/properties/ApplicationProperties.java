package com.voxsmart.test.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

	public static String APPLICATION_PROPERTIES_FILE_NAME="application.properties";
	
	public static Properties getApplicationProperties() {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		try(InputStream resourceStream = loader.getResourceAsStream(APPLICATION_PROPERTIES_FILE_NAME)) {
		    props.load(resourceStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props;
	}
	
	
}
