package com.hyder.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	private static Properties prop;
	public static Properties getProp() throws IOException {
		if (prop == null) {
			prop = new Properties();
			InputStream input = null;
			try {
				//Two arguments passed for property file location
				input = new FileInputStream(new File(Constants.PROP_LOCATION, Constants.PROP_NAME));
				prop.load(input);
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if(input!=null) {
					input.close();
				}
			}
		}
		return prop;
	}
}
