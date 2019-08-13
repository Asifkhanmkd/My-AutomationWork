package com.nopCommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties prop;
	FileInputStream fis;

	public ReadConfig() {
     
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\configuration\\config.properties");
		} catch (FileNotFoundException e1) {
		   e1.printStackTrace();
		}

		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
          e.printStackTrace();
		}

	}

	public String getUrl() {
		String url = prop.getProperty("url");
		return url;

	}

	public String getEmail() {
		String email = prop.getProperty("email");
		return email;

	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;

	}

	public String getChromePath() {
		String cpath = prop.getProperty("chromePath");
		return cpath;

	}

	public String iesysProp() {
		String syspro = prop.getProperty("iesysProp");
		return syspro;

	}
	public String ffoxsysProp() {
		String syspro = prop.getProperty("ffoxsysProp");
		return syspro;

	}

	public String getFireFoxPath() {
		String ff = prop.getProperty("firefoxPath");
		return ff;

	}

	public String getIePath() {
		String iePath = prop.getProperty("iePath");
		return iePath;

	}

	public String getLog4j() {
		String log4jPath = prop.getProperty("log4jPath");
		return log4jPath;

	}

	public String chrosysProp() {
		String chrosys = prop.getProperty("chromesysProp");
		return chrosys;
		
	}
}
