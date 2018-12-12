package project.wordpress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

/**
 * author:刘江
 * 创建页面
 */

public class Plugin_Test extends BaseTest{
	Login_Action action;
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		action=new Login_Action(webtest);
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
		Thread.sleep(1000);
	}
	
	@Test(priority=0)
	public void plugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("link=安装插件");
		webtest.click("link=BuddyPress ");
		webtest.click("link=现在安装");
	}
	
	@Test(priority=1)
	public void findplugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("link=安装插件");
		webtest.type("name=s", "dd");
		webtest.enter();
		webtest.pause(300000);
	}
	
	@Test(priority=2)
	public void actionplugin() throws InterruptedException {
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
