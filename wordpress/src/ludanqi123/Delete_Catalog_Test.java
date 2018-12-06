package ludanqi123;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 
 * @author ludanqi
 * ɾ��Ŀ¼
 *
 */

public class Delete_Catalog_Test extends BaseTest{

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
		action.login("ludanqi", "970901");
		Thread.sleep(1000);
		//����ƶ����ֻ��ʹ��driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='����']"))).perform();
		Thread.sleep(1000);
		//���롰����Ŀ¼��ҳ��
		webtest.click("xpath=//a[text()='����Ŀ¼']");
		Thread.sleep(1000);	
		//ɾ��Ŀ¼
		actions.moveToElement(driver.findElement(By.xpath("//a[@aria-label='��theo�����༭��']"))).perform();
		webtest.click("xpath=//a[@aria-label='ɾ����theo��']");
		Thread.sleep(1000);	
		//�ڵ����Ի�����ѡ��ȷ����ȡ��Ϊdismiss��
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);	
		//����
		assertFalse(webtest.ifContains("lovetheo"));
	}
}