package com.edu.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edu.utils.ObjectMap;

public class LoginPage {
	public WebElement element;
	public WebDriver driver;
	ObjectMap objMap = new ObjectMap("ObjectMap/login.properties");
	
	public LoginPage(WebDriver wd) {
		this.driver = wd;
	}
	
	public WebElement getLink() throws Exception {
		this.element =driver.findElement(objMap.getlocator("login.login_link"));
		return element;
	}
	
	public WebElement getu_name() throws Exception {
		this.element =driver.findElement(objMap.getlocator("login.uName"));
		return element;
	}
	
	public WebElement getu_pwd() throws Exception {
		this.element =driver.findElement(objMap.getlocator("login.uPwd"));
		return element;
	}
	
	public WebElement getsubmit() throws Exception {
		this.element =driver.findElement(objMap.getlocator("login.submitBtn"));
		return element;
	}

}
