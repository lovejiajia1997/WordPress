package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * author:yuezhewei
 * Settings��׫д�Ĳ���
 */
public class Compose extends BaseTest {  
	@BeforeMethod
  public void login (){
	  //��ҳ��
	   webtest.open("http://localhost:8032/wordpress/wp-login.php?loggedout=true");
	   //�ı�������
	   webtest.type("name=log","admin");
	   webtest.type("name=pwd","123456");
	   webtest.click("xpath=//input[@type='submit']");
	   assertTrue(webtest.isTextPresent("��¼"));	  
  }
  @Test(priority=1)
  public void compose() {
	  webtest.click("link=Settings");
	  webtest.click("link=׫д");
	  webtest.selectByValue("name=default_category", "2");
	  webtest.selectByValue("id=default_post_format", "0");
	  webtest.typeAndClear("id=mailserver_url", "541520730@qq.com");
	  webtest.typeAndClear("id=mailserver_login", "ceshi");
	  webtest.typeAndClear("id=mailserver_pass", "123456");
	  webtest.selectByValue("id=default_email_category", "2");
	  webtest.click("xpath=//input[@type='submit']");
  }

}
