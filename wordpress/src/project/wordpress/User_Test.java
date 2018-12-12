package project.wordpress;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

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
		action.login("admin", "admin");
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
	}
	
	@Test(description="ɾ�������û�",priority=2)
	public void deleteUser() throws Exception  {			
		webtest.mouseoverElement("xpath=//td[contains(.,' 1234567�༭ | ɾ�� | �鿴��ʾ����')]");
		Thread.sleep(1000);
		webtest.click("xpath=//a[text()='ɾ��'");
		webtest.click("id=submit");
	}
}
