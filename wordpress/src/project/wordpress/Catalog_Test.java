package project.wordpress;
/**
 * @author ludanqi
 * Ŀ¼������
 */
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

public class Catalog_Test extends BaseTest{
	
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
	public void addCatalog() throws Exception  {	
		
		//����ƶ����ֻ��ʹ��driver
		webtest.mouseoverElement("xpath=//div[text()='����']");	
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
	
	@Test(priority=1)
	public void findCataLog() throws Exception  {	
		
		//����ƶ����ֻ��ʹ��driver
		webtest.mouseoverElement("xpath=//div[text()='����']");
		
		//���롰����Ŀ¼��ҳ��
		driver.findElement(By.xpath("//a[text()='����Ŀ¼']")).click();
		Thread.sleep(1000);	
		
		//������������"theo"Ŀ¼
		webtest.type("id=tag-search-input","theo");
		webtest.click("xpath=//input[@class='button']");
		webtest.mouseoverElement("xpath=//a[@aria-label='��theo�����༭��']");
		webtest.click("xpath=//a[@aria-label='�鿴��theo���浵']");
		Thread.sleep(1000);	
		
		//����
		assertTrue(webtest.ifContains("δ�ҵ�"));
		webtest.goBack();
	}
	
	@Test(priority=2)
	public void modifyCatalog() throws Exception  {	

		//����ƶ����ֻ��ʹ��driver
		webtest.mouseoverElement("xpath=//div[text()='����']");

		//���롰����Ŀ¼��ҳ��
		driver.findElement(By.xpath("//a[text()='����Ŀ¼']")).click();
		Thread.sleep(1000);
		
		//�޸�Ŀ¼
		webtest.mouseoverElement("xpath=//a[@aria-label='��theo�����༭��']");
		webtest.click("xpath=//a[@aria-label='�༭��theo��']");
		Thread.sleep(1000);	
		webtest.type("name=name","love");
		webtest.type("name=slug","love");
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(1000);
		
		//����
		assertTrue(webtest.ifContains("�����Ѹ���"));
	}
	
	
	@Test(priority=3)
	public void deleteCataLog() throws Exception  {	
		
		//����ƶ����ֻ��ʹ��driver
		webtest.mouseoverElement("xpath=//div[text()='����']");
		//���롰����Ŀ¼��ҳ��
		driver.findElement(By.xpath("//a[text()='����Ŀ¼']")).click();
		Thread.sleep(1000);
		//ɾ��Ŀ¼

		webtest.mouseoverElement("xpath=//a[contains(.,'theolove')]");
		webtest.runJs("arguments[0].click();","xpath=//a[contains(.,'ɾ��')]");
		Thread.sleep(1000);	
		//�ڵ����Ի�����ѡ��ȷ����ȡ��Ϊdismiss��
		webtest.alertAccept();	
		
		//����
		assertFalse(webtest.ifContains("lovetheo"));
	}
}
