package com.hyder.utils;

import java.io.File;
import java.io.FileInputStream;
<<<<<<< HEAD
=======
import java.io.IOException;
>>>>>>> cda4c41 (HybridFrameWork)
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	private static Properties prop;
	
<<<<<<< HEAD
	public static Properties getProp() {
=======
	public static Properties getProp() throws IOException {
>>>>>>> cda4c41 (HybridFrameWork)
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
<<<<<<< HEAD
=======
			finally {
				if(input!=null) {
					input.close();
				}
			}
>>>>>>> cda4c41 (HybridFrameWork)
		}
		return prop;
	}
}
