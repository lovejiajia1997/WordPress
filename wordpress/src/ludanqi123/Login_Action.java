package ludanqi123;

import com.webtest.core.WebDriverEngine;

/**
 * 
 * @author ludanqi
 * µÇÂ¼
 *
 */

public class Login_Action {
	
	private WebDriverEngine webtest;
	
	public Login_Action(WebDriverEngine webtest){		
		 this.webtest=webtest;
	}
	  
	public void login(String name,String password){
		
		webtest.typeAndClear("name=log", name);
		webtest.typeAndClear("name=pwd", password);
		webtest.click("xpath=//input[@value='µÇÂ¼']");
	 }
	  
	 public boolean is_login(){
		 
		 return webtest.isElementPresent("id=logoutLink");
	 }	  

}
