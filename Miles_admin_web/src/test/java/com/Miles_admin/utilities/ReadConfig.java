package com.Miles_admin.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties pro= new Properties();
	public ReadConfig() {
		
		File src = new File("./Configurations/Config.properties");
		try {
			FileInputStream file = new FileInputStream(src);
			
			pro.load(file);
		}
		catch (Exception e) {
			System.out.println("exception is" +e);
		}
	}
	
	
	
	
	  public String getchromepath() { 
		  String platform = pro.getProperty("Chromepath");
	  return platform;
	  }
	 
	public String geturl() {
		String url = pro.getProperty("BaseURL");
		return url;
	}


	public String getFirefoxpath() {
		 String platform = pro.getProperty("Firefoxpath");
		  return platform;
		
	}
	


	public String getIEpath() {
		 String platform = pro.getProperty("IEpath");
		  return platform;
		
	}
	
	public String getEdgepath() {
		 String platform = pro.getProperty("Edgepath");
		  return platform;
		
	}
	
}
