/**
 * author:����
 * ����ҳ��
 */
package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Createpages extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void pagesTest() throws InterruptedException {
		for (int i = 0;i<5;i++) {
			webtest.click("link=�½�ҳ��");
			webtest.type("id=title", "test"+i);
			webtest.type("id=content_ifr", "babc");
			webtest.click("name=publish");
		    webtest.pause(3000);
		}
	}
	
}
