package shisujia;
/*
 * author:shisujia
 * ɾ���û���
 */
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DeleteUser_Test extends BaseTest {
	Login_Action action;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		driver.findElement(By.xpath("//div[text()='�û�']")).click();
		Thread.sleep(3000);
	}

	@Test(description="ɾ�������û�")
	public void deleteUser() throws Exception  {			
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//td[contains(.,' 1234567�༭ | ɾ�� | �鿴��ʾ����')]"))).perform();
		Thread.sleep(3000);
		webtest.click("xpath=//a[text()='ɾ��'");
		Thread.sleep(1000);
		webtest.click("id=submit");
		Thread.sleep(1000);		
	}
	
//	@Test(description="����ɾ���û�")
//	public void deleteUser_batch() throws Exception  {
//		driver.findElement(By.xpath("//input[@id='user_14']")).click();
//		driver.findElement(By.xpath("//input[@id='user_9']")).click();
//		driver.findElement(By.name("action")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//option[text()='ɾ��']")).click();
//		driver.findElement(By.id("doaction")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("delete_option0")).click();
//		driver.findElement(By.id("submit")).click();
//		Thread.sleep(60000);		
//	}
	
}
