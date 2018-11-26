package com.edu.appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edu.pageObjects.LoginPage;


public class Login_Action {
	public static void execute(WebDriver wd,String name,String password) throws Exception {
		wd.get("http://localhost:8032/mymovie");
		LoginPage mPage = new LoginPage(wd);
		mPage.getLink().click();
		Thread.sleep(1500);
		mPage.getu_name().sendKeys(name);
		mPage.getu_pwd().sendKeys(password);
		mPage.getsubmit().click();
	}

}
