package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Front_Login_Test extends BaseTest {

	@Test
	public void testSearch() throws Exception {
		webtest.open("http://localhost:8032/mymovie/");
		webtest.click("link=��¼");
		webtest.type("name=username", "qingdao01");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//input[@value='���ϵ�¼']");
		assertTrue(webtest.ifContains("�˳�"));

	}

	@Test
	public void Failed() throws Exception {
		webtest.open("http://localhost:8032/mymovie/");
		webtest.click("link=��¼");
		webtest.type("name=username", "qingdao01");
		webtest.type("name=password", "123");
		webtest.click("xpath=//input[@value='���ϵ�¼']");
		assertTrue(webtest.ifContains("�˳�"));

	}

}
