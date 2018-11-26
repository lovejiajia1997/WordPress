package com.edu.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.edu.utils.ObjectMap;

public class Admin_AddFilmPage {
	public WebElement element;
	public WebDriver driver;
	ObjectMap objMap = new ObjectMap("ObjectMap/admin_addfilm.properties");
	
	public Admin_AddFilmPage(WebDriver wd) {
		this.driver = wd;
	}
	
	public WebElement getfilm_man() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_manage"));
		return element;
	}
	
	public WebElement getfilm_mes() throws Exception {
		this.element = driver.findElement(objMap.getlocator("addfilm_message"));
		return element;
	}
	
	public WebElement getf_name() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_name"));
		return element;
	}
	
	public WebElement getf_pname() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_petname"));
		return element;
	}
		
	public WebElement getf_director() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_director"));
		return element;
	}
		
	public WebElement getf_edi() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_editor"));
		return element;
	}
	
	public WebElement getf_nation() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_nation"));
		return element;
	}
		
	public WebElement getf_lan() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_language"));
		return element;
	}
		
	public WebElement getf_showtime() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_showtime"));
		return element;
	}
	
	public WebElement getf_min() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_minutes"));
		return element;
	}
	
	public WebElement getf_pic() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_picname"));
		return element;
	}

	public WebElement getf_con() throws Exception {
		this.element = driver.findElement(objMap.getlocator("film_filmcon"));
		return element;
	}
	
	public WebElement getframe() throws Exception {
		this.element = driver.findElement(objMap.getlocator("frame"));
		return element;
	}
	
	public WebElement getsubmit() throws Exception {
		this.element = driver.findElement(objMap.getlocator("submit"));
		return element;
	}
}
