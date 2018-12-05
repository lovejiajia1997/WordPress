/**
 * author:刘江
 * 删除插件
 */
package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PluginDelete extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void actionplugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("xpath=//a[contains(@href,\"plugins.php?action=activate&plugin=akismet%2Fakismet.php\")]");
		//启用该插件
		webtest.click("xpath=//a[contains(@href,\"plugins.php?action=deactivate&plugin=akismet%2Fakismet.php\")]");
		//停用该插件
		webtest.click("xpath=//a[contains(@href,\"plugins.php?action=delete-selected&checked%5B0%5D=akismet\")]");
		//删除该插件
		webtest.alertAccept();
	}
}
