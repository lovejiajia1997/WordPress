package shisujia;

import com.webtest.core.WebDriverEngine;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login(String username,String password) throws Exception 
	  {
	
			webtest.type("id=user_login", username);
			webtest.type("name=pwd", password);
			webtest.click("xpath=//input[@id='wp-submit']");
			
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }
	  

}