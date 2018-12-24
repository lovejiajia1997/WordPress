package ludanqi123;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import project.wordpress.Login_Action;

/**
 * 
 * @author ludanqi
 * ���Ŀ¼
 *
 */

public class Add_Catalog_Test extends BaseTest{
	
Login_Action action;
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		action=new Login_Action(webtest);
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}

	@Test
	public void testLogin() throws Exception  {	
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
		//����ƶ����ֻ��ʹ��driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='����']"))).perform();
		Thread.sleep(3000);
		//���롰����Ŀ¼��ҳ��
		driver.findElement(By.xpath("//a[text()='����Ŀ¼']")).click();
		Thread.sleep(1000);	
		//����Ŀ¼
		webtest.type("name=tag-name","theo");
		webtest.type("id=tag-slug","zzt");
		webtest.click("xpath=//input[@id='submit']");
		//����
		assertTrue(webtest.ifContains("theo"));
	}
}