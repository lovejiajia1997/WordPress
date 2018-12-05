/**
 * author:刘江
 * 更改页面
 */
package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class ChangePages extends BaseTest {
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void changePages() throws InterruptedException {
		webtest.click("link=页面");
		webtest.mouseoverElement("id=post-106");
		webtest.click("class=edit");
		webtest.typeAndClear("id=title", "test");
		webtest.typeAndClear("id=tinymce", "test");
		webtest.click("id=publish");
	}
}
