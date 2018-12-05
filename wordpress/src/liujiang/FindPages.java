/**
 * author:¡ıΩ≠
 * ≤È’““≥√Ê
 */
package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FindPages extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void findPages() {
		webtest.type("name=s", "test4");
		webtest.click("id=search-submit");
	}
}
