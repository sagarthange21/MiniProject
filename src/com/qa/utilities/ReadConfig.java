package com.qa.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() 
	{
		File Src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis= new FileInputStream(Src);
			pro= new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception is "+ e.getMessage());
		}
	}


	public String getApplicationURL()
	{
		String url= pro.getProperty("baseURl");
		return url;
	}


	public String getUsername()
	{
		String userName= pro.getProperty("userName");
		return userName;
	}

	public String getPassword()
	{
		String passWord= pro.getProperty("passWord");
		return passWord;
	}

	public String getChromepath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}


}
