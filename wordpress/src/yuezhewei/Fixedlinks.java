package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * author:yuezhewei
 * Settings�����۵Ĳ���
 */
public class Fixedlinks extends BaseTest {
	@BeforeMethod
	public void testLogin() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		webtest.typeAndClear("id=user_login","admin");
		webtest.typeAndClear("id=user_pass", "123456");
		webtest.click("xpath=//input[@value='��¼']");	
	}	
	@Test(priority=0)
	public void medio() throws InterruptedException {
		  webtest.click("link=Settings");	
		  webtest.click("link=�̶�����");		 
		  webtest.pause(1000);
		  webtest.click("link=����");	
		  webtest.typeAndClear("name=category_base", "yuezhewei");
		  webtest.typeAndClear("name=tag_base", "upup");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=1)
	public void medio1() throws InterruptedException {
		  webtest.click("link=Settings");
		  webtest.click("link=�̶�����");		 
		  webtest.pause(1000);
		  webtest.click("link=���ں�������");	
		  webtest.typeAndClear("name=category_base", "yuezhewei");
		  webtest.typeAndClear("name=tag_base", "upup");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=2)
	public void medio2() throws InterruptedException {
		  webtest.click("link=Settings");
		  webtest.click("link=�̶�����");		 
		  webtest.pause(1000);
		  webtest.click("link=custom");	
		  webtest.typeAndClear("name=category_base", "yuezhewei");
		  webtest.typeAndClear("name=tag_base", "upup");	
		  webtest.click("xpath=//input[@type='submit']");
	}
}
