package project.wordpress;

/**
 * @author ludanqi
 * ���²�����
 */
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

public class Article_Test extends BaseTest {

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
	public void addArticle() throws Exception  {				
			
		//����ƶ����ֻ��ʹ��driver
		webtest.mouseoverElement("xpath=//div[text()='����']");

		
		//���롰д���¡�ҳ��
		webtest.click("xpath=//a[text()='д����']");
		Thread.sleep(1000);	
		
		//�رյ����Ի���
		webtest.click("xpath=//button[@class='components-button components-icon-button nux-dot-tip__disable']");
		Thread.sleep(1000);	
		
		//д���£�typeֻ�ܴ�id,class,name,link,css,xpath,tag��
		webtest.type("id=post-title-0","���ո��");
		webtest.enter();
		webtest.type("id=post-content-0","��ѩ������������Ϯ�����߻���ö��������۵���ů��ס�"
				+ "������ʱ���������Ǳ�ķ羰�������������¡�"
				+ "�ڶ��յ����磬��������͢�����ġ�The Winter Light��������ѩ����������������룡"
				+ "������죬�н�����ѩ��������ɿɣ�������Ц�ݣ����С����ո�ס�");

		//��������
		webtest.click("xpath=//button[contains(.,'����...')]");
		Thread.sleep(2000);	
		webtest.click("xpath=//button[@class='components-button editor-post-publish-button is-button is-default is-primary is-large']");
		
		//����
		assertTrue(webtest.ifContains("Post published"));
	}
	
	
	@Test(priority=1)
	public void findArticle() throws Exception  {		
		
		//�ƶ����ֻ��ʹ��driver
		webtest.click("xpath=//div[text()='����']");	
		
		//����������������"���ո��"
		webtest.type("id=post-search-input","���ո��");
		webtest.click("xpath=//input[@id='search-submit']");
		webtest.mouseoverElement("xpath=//a[contains(.,'���ո��')]");
		webtest.click("xpath=//a[@aria-label='�鿴�����ո�ס�']");
		
		//����
		assertTrue(webtest.ifContains("����͢"));
	}
	
	
	@Test(priority=2)
	public void modifyArticle() throws Exception  {		
		//�ƶ����ֻ��ʹ��driver
		webtest.click("xpath=//div[text()='����']");	
		
		//�����Ŀ�ϵĻ���վ
		webtest.mouseoverElement("xpath=//a[contains(.,'���ո��')]");	
		driver.findElement(By.xpath("//a[@aria-label='�༭�����ո�ס�']")).click();
		Thread.sleep(1000);	
		driver.findElement(By.id("post-content-0")).sendKeys("������");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'����')]")).click();
		Thread.sleep(1000);	
		
		//����
		assertTrue(webtest.ifContains("Post updated"));		
	}
	
	
	@Test(priority=3)
	public void deleteArticle() throws Exception  {		
		
		//���롰�������¡�ҳ��
		webtest.click("xpath=//div[text()='����']");
		Thread.sleep(1000);	
		
		//�������վ
		webtest.mouseoverElement("xpath=//a[contains(.,'���ո��')]");	
		driver.findElement(By.xpath("//a[@aria-label='�ƶ������ո�ס���������']")).click();
		Thread.sleep(1000);
		
		//����
		assertTrue(webtest.ifContains("���ƶ�1ƪ���µ�����վ"));
	}
}
