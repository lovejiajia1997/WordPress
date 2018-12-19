package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Login_Test extends BaseTest {

	Login_Action action;

	// 实例化action
	@BeforeMethod
	public void setup() {
		action = new Login_Action(webtest);
	}

	//
	@Test
	public void LoginSuccess() throws Exception {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		action.login("yty", "12345678");
		assertTrue(webtest.ifContains("仪表盘"));

	}

	@Test
	public void LoginFailed() throws Exception {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		action.login("yty", "123");
		assertTrue(webtest.ifContains("仪表盘"));

	}

}
