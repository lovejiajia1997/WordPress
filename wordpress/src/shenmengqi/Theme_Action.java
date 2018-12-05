package com.wordpress.appModules;

import com.webtest.utils.Log;
import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:21:21 
* wordpress项目
* 外观模块下，添加主题的操作类 
*/

public class Theme_Action {

	private WebDriverEngine webtest;
	
	
	//启用已安装主题
	public void changeTheme(String name) {
		this.theme();
		
		if(webtest.isElementPresent("xpath=//h2[@id='"+name+"-name']")) {
			webtest.click("xpath=//h2[@id='"+name+"-name']");
			if(webtest.isElementPresent("xpath=//a[@aria-label='激活"+name+"']")) {
				webtest.click("xpath=//a[@aria-label='激活"+name+"']");
				int i = 0;
				while(i<5 && !webtest.isTextPresent("已激活")) {
					webtest.pause(1000);
					i++;
				}
			}else {
				Log.error("主题正在应用");
			}
		}else {
			
			Log.error(name+"主题元素不存在");
		}
	}
	
	
	//添加主题
	//搜索主题并安装
	public void addThemeBySearch(String name) {
		String installpath = "xpath=//a[@data-slug='"+name+"']";//安装按钮元素位置
		String usepath = "xapth=//a[@aria-label='激活"+name+"']";//启用按钮元素位置
		
		this.theme();
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.typeAndClear("id=wp-filter-search-input",name);
		
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
//		鼠标悬停
//		webtest.mouseoverElement("xpath=//h3[contains(.,'"+name+"')]");
		
		//判断主题元素是否存在
		if (webtest.isElementPresent(installpath)) {
			int i  = 0;
			webtest.click(installpath);
			while(!webtest.isElementPresent(usepath) && i<20) {
				webtest.pause(1000);
				i++;
			}
		}//判断主题是否已安装
		else if(webtest.isElementPresent(usepath)) {
			Log.info("主题已安装");
		}
		else {
			Log.error("主题元素未找到");
		}
		
		
	}
	//通过链接安装主题
	public void addThemeByLink(String name) {
		String installpath = "xpath=//a[@data-slug='"+name+"']";//安装按钮元素位置
		String usepath = "xapth=//a[@aria-label='激活"+name+"']";//启用按钮元素位置
		
		this.theme();
		
		webtest.click("xpath=//a[contains(.,'添加新主题')]");
		webtest.click(installpath);
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		if (webtest.isElementPresent(installpath)) {
			int i  = 0;
			webtest.click(installpath);
			while(!webtest.isElementPresent(usepath) && i<4) {
				webtest.pause(5000);
				i++;
			}
		}
		else if(webtest.isElementPresent(usepath)) {
			Log.info("主题已安装");
		}
		else {
			Log.error("主题元素未找到");
		}
	}
	//通过按钮安装主题
	public void addThemeByButton(String name) {
		
		String installpath = "xpath=//a[@data-slug='"+name+"']";//安装按钮元素位置
		String usepath = "xapth=//a[@aria-label='激活"+name+"']";//启用按钮元素位置
		
		this.theme();
		
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.click(installpath);
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		if (webtest.isElementPresent(installpath)) {
			int i  = 0;
			webtest.click(installpath);
			while(!webtest.isElementPresent(usepath) && i<20) {
				webtest.pause(1000);
				i++;
			}
		}
		else if(webtest.isElementPresent(usepath)) {
			Log.info("主题已安装");
		}
		else {
			Log.error("主题元素未找到");
		}
	}

	
	//删除添加的主题
	public void delTheme(String name) {
		this.theme();
		String themediv = "xpath=//h2[@id='"+name+"-name']";
		
		if(webtest.isElementPresent(themediv)) {
			if(webtest.isElementPresent("xpath=//h2[contains(.,'当前："+name+"')]")) {//判断主题是否正在使用
				Log.error("要删除的主题："+name+"正在使用");
			}else {
				webtest.click(themediv);
				webtest.click("xpath=//a[contains(.,'删除')]");
				webtest.alertAccept();
				webtest.pause(5000);
			}	
		}else {
			Log.error(name+"主题未安装");
		}
		
	}
	
	
	
	
	
	
	public Theme_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void login() {
		webtest.open("/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void theme() {
		this.login();
		webtest.click("xpath=//div[text()='外观']");
		webtest.click("xpath=//a[@aria-current='page']");		
	}
	
}
