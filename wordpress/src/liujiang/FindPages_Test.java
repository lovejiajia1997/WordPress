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

public class FindPages_Test extends BaseTest{
	Login_Action action;
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
	}
	@Test
	public void findPages() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='ҳ��']"))).perform();
		Thread.sleep(3000);
		//���롰д�½�ҳ�桱ҳ��
		driver.findElement(By.xpath("//a[text()='����ҳ��']")).click();
		Thread.sleep(1000);	
		webtest.type("name=s", "test");
		webtest.click("id=search-submit");
		Thread.sleep(5000);
	}
}
