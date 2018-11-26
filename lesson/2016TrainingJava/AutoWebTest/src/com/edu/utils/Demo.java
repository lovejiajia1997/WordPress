package com.edu.utils;

import java.io.IOException;

import org.testng.annotations.Test;

public class Demo {
	ReadProperties pro = new ReadProperties();
	
	@Test
	public void demo1() throws IOException {
		pro.getPropertiesValue("login.login_link");
	}
}
