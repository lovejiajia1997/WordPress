package ludanqi123;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 
 * @author ludanqi
 * ɾ������
 *
 */

public class Delete_Article_Test extends BaseTest{

Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	@Test
	public void testLogin() throws Exception  {		
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
		Thread.sleep(1000);
		//���롰�������¡�ҳ��
		webtest.click("xpath=//div[text()='����']");
		Thread.sleep(1000);	
		
		//�������վ
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'���ո��')]"))).perform();
		driver.findElement(By.xpath("//a[@aria-label='�ƶ������ո�ס���������']")).click();
		Thread.sleep(1000);
		//����
		assertTrue(webtest.ifContains("���ƶ�1ƪ���µ�����վ"));
	}

}
