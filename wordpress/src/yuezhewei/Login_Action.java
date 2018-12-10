package com.webtest.demo;

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String email,String password) 
	  {
	
			//webtest.click("link=µÇÂ¼");
			webtest.type("name=log", "admin");
			webtest.type("name=pwd", "123456");
			webtest.click("xpath=//input[@type='submit']");
		
	  }
	  
//	//  public boolean is_login()
//	  {
//		  return webtest.isElementPresent("id=logoutLink");
//	  }
	  public void addfilm() {
		  
	  }

}
