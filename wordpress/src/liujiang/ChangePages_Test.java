/**
 * author:����
 * ����ҳ��
 */
package liujiang;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class ChangePages_Test extends BaseTest {
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void changePages() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='ҳ��']"))).perform();
		Thread.sleep(2000);
		//���롰д�½�ҳ�桱ҳ��
		driver.findElement(By.xpath("//a[text()='����ҳ��']")).click();
		Thread.sleep(1000);	
		actions.moveToElement(driver.findElement(By.xpath("//a[@aria-label='��ҳ�桱���༭��']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='�༭��ҳ�桱']")).click();
		webtest.typeAndClear("id=post-title-0", "test");
		webtest.typeAndClear("id=post-content-0", "test");
		driver.findElement(By.xpath("//button[contains(.,'����')]")).click();
		Thread.sleep(1000);
	}
}
