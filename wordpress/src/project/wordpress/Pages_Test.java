package project.wordpress;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

/**
 * author:����
 * ����ҳ��
 */


public class Pages_Test extends BaseTest{
	
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
	public void caeatePagesTest() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='ҳ��']");
		Thread.sleep(2000);
		//���롰д�½�ҳ�桱ҳ��
		driver.findElement(By.xpath("//a[text()='�½�ҳ��']")).click();
		Thread.sleep(1000);	
		webtest.type("id=post-title-0", "ҳ��");
		webtest.type("id=post-content-0", "����ҳ�������");
		webtest.click("xpath=//button[contains(.,'����...')]");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'����')]")).click();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=1)
	public void findPages() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='ҳ��']");
		Thread.sleep(2000);
		//���롰д�½�ҳ�桱ҳ��
		driver.findElement(By.xpath("//a[text()='����ҳ��']")).click();
		Thread.sleep(1000);	
		webtest.type("name=s", "test");
		webtest.click("id=search-submit");
		Thread.sleep(5000);
	}
	
	
	@Test(priority=2)
	public void changePages() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='ҳ��']");
		Thread.sleep(2000);
		//���롰д�½�ҳ�桱ҳ��
		driver.findElement(By.xpath("//a[text()='����ҳ��']")).click();
		Thread.sleep(1000);	
		webtest.mouseoverElement("xpath=//a[@aria-label='��ҳ�桱���༭��']");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@aria-label='�༭��ҳ�桱']")).click();
		webtest.typeAndClear("id=post-title-0", "test");
		webtest.typeAndClear("id=post-content-0", "test");
		driver.findElement(By.xpath("//button[contains(.,'����')]")).click();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=3)
	public void deletePages() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='ҳ��']");
		Thread.sleep(2000);
		//���롰д�½�ҳ�桱ҳ��
		driver.findElement(By.xpath("//a[text()='����ҳ��']")).click();
		Thread.sleep(1000);	
		webtest.mouseoverElement("xpath=//a[@aria-label='��test�����༭��']");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@aria-label='�ƶ���test����������']")).click();
		Assert.assertTrue(ifContains("���ƶ�1ƪ���µ�����վ"));
		
	}
}
