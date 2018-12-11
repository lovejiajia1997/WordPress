package shisujia;
/*
 * author:shisujia
 * ����û���
 */
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


public class AddUser_Test extends BaseTest{
	
	Login_Action action;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	
	@Test
	public void addUser() throws Exception {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='�û�']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='����û�']")).click();
		Thread.sleep(3000);
		webtest.type("id=user_login","1234567" );
		webtest.type("id=email","1234567@qq.com" );
		webtest.type("id=first_name","�ؼ�" );
		webtest.type("id=last_name","ʷ" );
		webtest.click("xpath=//button[text()='��ʾ����']" );
		Thread.sleep(1000);
		webtest.typeAndClear("id=pass1-text","1234567" );
		webtest.click("name=pw_weak");
		Thread.sleep(1000);
		webtest.click("id=role");
		Thread.sleep(1000);
		webtest.click("xpath=//option[text()='����Ա']");
		Thread.sleep(1000);
		webtest.click("id=createusersub");
		Thread.sleep(1000);	
		System.out.println("����û��ɹ�");
	}
	
}