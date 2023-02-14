package com.Inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	Properties prop;
	
	public Readconfig() 
	{
		
		prop=new Properties();
		File src=new File(".\\src\\test\\resources\\Properties\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String appurl()
	{
		String url=prop.getProperty("url");
		
		return url;
	} 
	
	public String getUsername()
	{
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
	

}
