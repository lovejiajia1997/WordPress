package com.edu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadProperties {
	
	String filePath="ObjectMap/login.properties";
	
	public void getPropertiesValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		fis.close();
		String locator = prop.getProperty(key);
	
		String locatorValue=new String(locator.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(locatorValue);
		}
}
