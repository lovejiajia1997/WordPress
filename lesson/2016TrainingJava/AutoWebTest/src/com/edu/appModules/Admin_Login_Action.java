package com.edu.appModules;

import org.openqa.selenium.WebDriver;

import com.edu.pageObjects.Admin_LoginPage;

public class Admin_Login_Action {
	public static void execute(WebDriver wd,String name,String password) throws Exception {
		wd.get("http://localhost:8032/MyMovie/admin.php/Login/index.html");
		Admin_LoginPage alPage = new Admin_LoginPage(wd);
		alPage.getu_name().sendKeys(name);
		alPage.getu_Pwd().sendKeys(password);
		alPage.getsubmitBtn().click();
		Thread.sleep(1000);
		
	}
	
}
