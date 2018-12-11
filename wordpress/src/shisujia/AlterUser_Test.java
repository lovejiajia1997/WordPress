package shisujia;
/*
 * author:shisujia
 * �༭����������
 */

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AlterUser_Test extends BaseTest{
	Login_Action action;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	
	
	@Test
	public void alterUser() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='�û�']"))).perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='�ҵĸ�������']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("����");
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("����");
		driver.findElement(By.id("nickname")).clear();
		driver.findElement(By.id("nickname")).sendKeys("�Ѽ�");
		driver.findElement(By.id("display_name")).click();
		driver.findElement(By.xpath("//option[contains(.,'���� ����')]")).click();
		driver.findElement(By.id("submit")).click();	
	}
}
