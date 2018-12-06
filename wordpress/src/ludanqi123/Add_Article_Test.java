package ludanqi123;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * 
 * @author ludanqi
 * ����������
 *
 */
public class Add_Article_Test extends BaseTest{

Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	@Test
	public void addArticle() throws Exception  {		
		
		//ִ�б���ǰ��Ҫִ��ý����ϴ���Ƭ��
		
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
		Thread.sleep(1000);
		//����ƶ����ֻ��ʹ��driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='����']"))).perform();
		Thread.sleep(1000);
		//���롰д���¡�ҳ��
		webtest.click("xpath=//a[text()='д����']");
		Thread.sleep(1000);	
		//�رյ����Ի���
		webtest.click("xpath=//button[@class='components-button components-icon-button nux-dot-tip__disable']");
		Thread.sleep(1000);	
		//д���£�typeֻ�ܴ�id,class,name,link,css,xpath,tag��
		webtest.type("id=post-title-0","���ո��");
		actions.sendKeys(Keys.ENTER).perform();
		webtest.type("id=post-content-0","��ѩ������������Ϯ�����߻���ö��������۵���ů��ס�"
				+ "������ʱ���������Ǳ�ķ羰�������������¡�"
				+ "�ڶ��յ����磬��������͢�����ġ�The Winter Light��������ѩ����������������룡"
				+ "������죬�н�����ѩ��������ɿɣ�������Ц�ݣ����С����ո�ס�");
//		//���ͼƬ
//		actions.sendKeys(Keys.ENTER).perform();
//		actions.moveToElement(driver.findElement(By.xpath("//p[@id='mce_1']"))).perform();
//		webtest.click("xpath=//button[@aria-label='���ͼ��']");
//		Thread.sleep(1000);	
//		webtest.click("xpath=//button[contains(.,'ý���')]");
//		Thread.sleep(1000);	
//		webtest.type("class=search","TheWinterLight");
//		actions.sendKeys(Keys.ENTER).perform();
//		webtest.click("xpath=//div[@class='thumbnail']");
//		Thread.sleep(1000);	
//		webtest.click("xpath=//button[@class='button media-button button-primary button-large media-button-select']");	
//		Thread.sleep(1000);	

		
		//��������
		webtest.click("xpath=//button[contains(.,'����...')]");
		Thread.sleep(1000);	
		webtest.click("xpath=//button[@class='components-button editor-post-publish-button is-button is-default is-primary is-large']");
		
		//����
		assertTrue(webtest.ifContains("Post published"));
	}

}
