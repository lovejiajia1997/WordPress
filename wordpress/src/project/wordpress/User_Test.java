package project.wordpress;

/*
 * author:shisujia
 * �û�������
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/*
 * author:shisujia
 * �û�������
 */
public class User_Test extends BaseTest{
	Login_Action action;
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		action=new Login_Action(webtest);
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=0)
	public void addUser() throws Exception {
		
		webtest.mouseoverElement("xpath=//div[text()='�û�']");
		driver.findElement(By.xpath("//a[text()='����û�']")).click();
		Thread.sleep(3000);
		webtest.type("id=user_login","1234567" );
		webtest.type("id=email","1234567@qq.com" );
		webtest.type("id=first_name","�ؼ�" );
		webtest.type("id=last_name","ʷ" );
		webtest.click("xpath=//button[text()='��ʾ����']" );
		webtest.typeAndClear("id=pass1-text","1234567" );
		webtest.click("name=pw_weak");
		webtest.click("id=role");
		webtest.click("xpath=//option[text()='����Ա']");
		webtest.click("id=createusersub");
		System.out.println("����û��ɹ�");
	}
	
	
	@Test(priority=1)
	public void alterUser() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='�û�']");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='�ҵĸ�������']")).click();
		Thread.sleep(2000);
		webtest.typeAndClear("id=first_name", "����");
		webtest.typeAndClear("id=last_name", "����");
		webtest.typeAndClear("id=nickname", "�Ѽ�");
		webtest.click("id=display_name");
		webtest.click("xpath=//option[contains(.,'���� ����')]");
		webtest.click("id=submit");	
		Assert.assertTrue(ifContains("�Ѹ����û�"));
	}
	
	@Test(priority=2)
	public void findUser() throws InterruptedException {
		webtest.click("xpath=//div[text()='�û�']");
		webtest.type("id=s", "1234567");
		webtest.click("id=search-submit");
		Assert.assertTrue(ifContains("1234567"));
	}
	
	@Test(description="ɾ�������û�",priority=3)
	public void deleteUser() throws Exception  {
		webtest.click("xpath=//div[text()='�û�']");
		webtest.mouseoverElement("xpath=//a[text()='1234567']");
		Thread.sleep(3000);
		webtest.runJs("arguments[0].click();", "xpath=//a[contains(.,'ɾ��')]");
		webtest.click("id=submit");
		Assert.assertTrue(ifContains("�û���ɾ��"));
	}
}
