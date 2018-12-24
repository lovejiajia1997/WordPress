package project.wordpress;

import java.io.IOException;

import com.webtest.core.WebDriverEngine;
import com.webtest.utils.ReadProperties;

public class Login_Action {
	private WebDriverEngine webtest;
	  public Login_Action(WebDriverEngine webtest) {
		  this.webtest=webtest;
	  }
	  
	  public void login() 
	  {
			try {
				String username = ReadProperties.getPropertyValue("username");
				String password = ReadProperties.getPropertyValue("password");
				webtest.typeAndClear("id=user_login", username);
				webtest.typeAndClear("name=pwd", password);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	
			webtest.click("xpath=//input[@id='wp-submit']");		
		
	  }
	  
	  public void loginNew(String username,String password) throws Exception 
	  {
			webtest.typeAndClear("id=user_login", username);
			webtest.typeAndClear("name=pwd", password);
			webtest.click("xpath=//input[@id='wp-submit']");		
		
	  }
	  
	  public boolean is_login()
	  {
		  return webtest.isElementPresent("id=logoutLink");
	  }

	


}