/**
 * author:����
 * ���Ҳ��
 */
package liujiang;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PluginFind_Test extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void findplugin() {
		webtest.click("xpath=//a[@href='plugins.php']");
		webtest.click("link=��װ���");
		webtest.type("name=s", "dd");
		webtest.enter();
		webtest.pause(300000);
	}
}
