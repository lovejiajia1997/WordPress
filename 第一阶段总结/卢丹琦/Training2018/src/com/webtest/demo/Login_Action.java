package com.webtest.demo;

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	
	private WebDriverEngine webtest;
	
	public Login_Action(WebDriverEngine webtest) {
		this.webtest=webtest;
	}
	  
	public void login(String email,String password) 
	{
	
		webtest.click("link=��¼");
		webtest.type("name=username", email);
		webtest.type("name=password", password);
		webtest.click("xpath=//input[@value='���ϵ�¼']");
		
	 }
	  
	 public boolean is_login()
	 {
		 return webtest.isElementPresent("id=logoutLink");
	 }
	  

}
