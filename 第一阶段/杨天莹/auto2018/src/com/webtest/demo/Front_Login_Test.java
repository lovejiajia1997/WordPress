package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Front_Login_Test extends BaseTest {

	@Test
	public void testSearch() throws Exception {
		webtest.open("http://localhost:8032/mymovie/");
		webtest.click("link=登录");
		webtest.type("name=username", "qingdao01");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='马上登录']");
		assertTrue(webtest.ifContains("退出"));

	}

	@Test
	public void Failed() throws Exception {
		webtest.open("http://localhost:8032/mymovie/");
		webtest.click("link=登录");
		webtest.type("name=username", "qingdao01");
		webtest.type("name=password", "123");
		webtest.click("xpath=//input[@value='马上登录']");
		assertTrue(webtest.ifContains("退出"));

	}

}
