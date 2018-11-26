package com.edu.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edu.utils.ObjectMap;

public class LoginPage {
	public WebElement element;
	public WebDriver driver;
	ObjectMap objMap = new ObjectMap("conf/login.properties");
	
	public LoginPage(WebDriver wd) {
		this.driver = wd;
	}
	
	public WebElement getLink() throws Exception {
		this.element =driver.findElement(objMap.getlocator("main.link"));
		return element;
	}
	

}
