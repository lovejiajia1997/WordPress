package com.edu.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edu.utils.ObjectMap;

public class Admin_LoginPage {
	public WebElement element;
	public WebDriver driver;
	ObjectMap objMap = new ObjectMap("ObjectMap/admin_login.properties");
	
	public Admin_LoginPage(WebDriver wd){
		this.driver = wd;
	}
	
	public WebElement getu_name() throws Exception {
		this.element = driver.findElement(objMap.getlocator("u_Name"));
		return element;
	}
	
	public WebElement getu_Pwd() throws Exception {
		this.element = driver.findElement(objMap.getlocator("u_Pwd"));
		return element;
	}
	
	public WebElement getsubmitBtn() throws Exception {
		this.element = driver.findElement(objMap.getlocator("submitBtn"));
		return element;
	}
}
