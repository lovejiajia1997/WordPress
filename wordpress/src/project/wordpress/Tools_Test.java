package project.wordpress;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * @author ����Ө ����ģ�����
 */
public class Tools_Test extends BaseTest {

	Login_Action action;
	
	@BeforeClass
	public void login() throws Exception
	{
		action=new Login_Action(webtest);
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}

	// ��������
	@Test(description = "��������")
	public void Tools_In() {

		webtest.click("xpath=//div[text()='����']");
		webtest.click("link=����");
		// ����
		webtest.click("xpath=//a[@aria-label='����Blogger']");
		webtest.type("xpath=//input[@id='upload']", "D:\\WordPress_UPUP\\Test.txt");
		webtest.click("xpath=//input[@id='submit']");
		webtest.click("xpath=//input[@value='Submit']");
		assertTrue(webtest.ifContains("All done"));
	}

	// ������ò���[������ã�����]
	@Test()
	public void Duoli() {

		webtest.click("xpath=//div[contains(text(),'���')]");
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.click("xpath=//a[@aria-label='������ö���']");
	}

}
