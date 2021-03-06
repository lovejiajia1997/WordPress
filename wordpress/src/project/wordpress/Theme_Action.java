package project.wordpress;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.utils.Log;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:21:21 
* wordpress项目
* 外观模块下，添加主题的操作类 
*/

public class Theme_Action extends BaseTest{

	private WebDriverEngine webtest;
	
	
	//启用已安装主题	
	public void changeTheme(String name) throws InterruptedException {
		this.theme();
		if(webtest.isElementPresent("xpath=//h2[contains(.,'"+name+"')]")) {
			
			webtest.mouseoverElement("xpath=//h2[contains(.,'"+name+"')]");
			webtest.JavaScriptClick("xpath=//a[contains(@aria-label,'激活"+name+"')]");
		}else {

			if(webtest.isElementPresent("xpath=//h2[contains(.,'"+name+"')]")) {
				webtest.mouseoverElement("xpath=//h2[contains(.,'"+name+"')]");
				webtest.JavaScriptClick("xpath=//a[contains(@aria-label,'激活"+name+"')]");
			}else {
				Log.info(name+"正在应用");
			}
		}
	}
	
	//添加主题
	//搜索主题并添加
	public void addThemeBySearch(String name) throws InterruptedException {
		{
			this.theme();
//		通过添加链接进入添加界面
			webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
//		通过按钮进入添加界面
//		webtest.click("xpath=//a[contains(.,'添加新主题')]");

		webtest.typeAndClear("id=wp-filter-search-input",name);
		try {
			webtest.wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webtest.mouseoverElement("xpath=//h3[contains(.,'"+name+"')]");
		if(webtest.isElementPresent("xpath=//a[@aria-label='安装"+name+"']")) {
			webtest.JavaScriptClick("xpath=//a[@aria-label='安装"+name+"']");
			webtest.typeAndClear("id=wp-filter-search-input",name);
			webtest.wait(5000);		
			webtest.mouseoverElement("xpath=//h3[contains(.,'"+name+"')]");
			if(webtest.isElementPresent("xpath=//a[@aria-label='安装"+name+"']")) {
				webtest.JavaScriptClick("xpath=//a[@aria-label='安装"+name+"']");				
				int i=0;
				while(i<2 && !webtest.ifContains("正在安装")) {
					webtest.pause(5000);
					i++;
				}
			}else {
				Log.error("Theme_Action-"+name+"主题已安装");
			}
			}
		} 
	}
	
	//删除添加的主题
	public void delTheme(String name) throws InterruptedException {
		this.theme();
		String themediv = "xpath=//h2[contains(.,'"+name+"')]";
		
		webtest.click(themediv);
		if(webtest.isElementPresent("xpath=//a[contains(.,'删除')]")) {
			webtest.click("xpath=//a[contains(.,'删除')]");
			webtest.alertAccept();
			webtest.pause(5000);
		}else {
			Log.error("Theme_Action-"+name+"主题正在使用");
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
