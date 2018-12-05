/**
 * author:Áõ½­
 * É¾³ýÒ³Ãæ
 */
package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DeletePages extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void deletePages() throws InterruptedException {
//		webtest.mouseoverElement("xpath=//input[contains(@id,'post-')]");
		webtest.click("link=Ò³Ãæ");
		webtest.mouseoverElement("id=post-104");
		webtest.click("class=submitdelete");
		webtest.click("class=trash");
		webtest.mouseoverElement("id=post-104");
		webtest.click("class=delete");
	} 
}
