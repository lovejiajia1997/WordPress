package project.wordpress;
import org.openqa.selenium.By;
import org.testng.Assert;
/*
 * author:shisujia
 * ��ǩ������
 */
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;




public class Tag_Test extends BaseTest {
	Login_Action action;
	
	@BeforeClass
	public void login() throws Exception
	{
		action=new Login_Action(webtest);
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}
	
	@Test(priority=0)
	public void addTag() throws InterruptedException {
		
		webtest.mouseoverElement("xpath=//div[text()='����']");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='��ǩ']")).click();
		Thread.sleep(1000);
		//�������		
		webtest.type("id=tag-name", "firstTag");
		//�������
		webtest.type("id=tag-slug", "��һ��tag");
		//�����ӱ�ǩ
		webtest.click("id=submit");
		Thread.sleep(1000);
		Assert.assertFalse(ifContains("���෨���Ѵ���ͬ����Ŀ"));
		System.out.println("��ӱ�ǩ�ɹ�");
	}
	
	
	@Test(priority=1)
	public void alterTag() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='����']");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='��ǩ']")).click();
		Thread.sleep(3000);
		webtest.mouseoverElement("xpath=//td[contains(.,'firstTagfirstTag��һ��tag0�༭ | ���ٱ༭ | ɾ�� | �鿴��ʾ����')]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@aria-label='�༭��firstTag��']");
		Thread.sleep(3000);
		webtest.typeAndClear("id=name", "firstTag123");
		webtest.typeAndClear("id=slug", "firstTag123");
		webtest.type("id=description", "����WordPress��Ŀ�ĵ�һ����ǩѽ");
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(3000);
		System.out.println("�޸ı�ǩ�ɹ�");
	}
	
	
	@Test(priority=2)
	public void deleteTag() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='����']");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='��ǩ']")).click();
		Thread.sleep(1000);
		webtest.mouseoverElement("xpath=//td[contains(.,'firstTag123firstTag123firsttag1230�༭ | ���ٱ༭ | ɾ�� | �鿴��ʾ����')]");	
		webtest.click("xpath=//a[contains(@aria-label,'ɾ����firstTag123��')]");
		Thread.sleep(1000);
		//�������ڴ���
		webtest.alertAccept();
		System.out.println("ɾ����ǩ�ɹ�");
	
	}
}
