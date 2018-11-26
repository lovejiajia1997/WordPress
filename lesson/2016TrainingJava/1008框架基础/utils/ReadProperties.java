package com.edu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadProperties {

	@Test
	public void test1() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("conf/login.properties");
		prop.load(fis);
		fis.close();
		String locator=prop.getProperty("main.link");
		System.out.println(locator);
		
		String locatorValue=new String(locator.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(locatorValue);
		
	}
}
