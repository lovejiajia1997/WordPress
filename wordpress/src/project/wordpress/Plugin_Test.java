package project.wordpress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

/**
 * author:����
 * ����ҳ��
 */

public class Plugin_Test extends BaseTest{
	Login_Action action;
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		action=new Login_Action(webtest);
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
		Thread.sleep(1000);
	}
	
	@Test(priority=0)
	public void plugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("link=��װ���");
		webtest.click("link=BuddyPress ");
		webtest.click("link=���ڰ�װ");
	}
	
	@Test(priority=1)
	public void findplugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("link=��װ���");
		webtest.type("name=s", "dd");
		webtest.enter();
		webtest.pause(300000);
	}
	
	@Test(priority=2)
	public void actionplugin() throws InterruptedException {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("xpath=//a[contains(@href,\"plugins.php?action=activate&plugin=akismet%2Fakismet.php\")]");
		//���øò��
		webtest.click("xpath=//a[contains(@href,\"plugins.php?action=deactivate&plugin=akismet%2Fakismet.php\")]");
		//ͣ�øò��
		webtest.click("xpath=//a[contains(@href,\"plugins.php?action=delete-selected&checked%5B0%5D=akismet\")]");
		//ɾ���ò��
		webtest.alertAccept();
	}
}
