package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Admin_Login extends BaseTest{

	@Test
	public void testLogin() throws InterruptedException {
		webtest.open("http://localhost:8032/MyMovie/admin.php/Login/index.html");
		webtest.type("name=username","admin");
		webtest.type("name=password","admin");
		webtest.click("xpath=//input[@value=' ']");
		Assert.assertTrue(webtest.isTextPresent("�˳�"));
	}
}

