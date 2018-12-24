package project.wordpress;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * 
 * @author ludanqi
 * ���Զ���ģ���г������⡢С���ߡ��˵�������������������ֽ��в���
 *
 */
public class Custom_Other_Test extends BaseTest{

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

	@Test
	public void custom() throws Exception  {		
		
		//����ƶ����ֻ��ʹ��driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='���']"))).perform();
		Thread.sleep(1000);
		//���롰�Զ��塱ҳ��
		webtest.click("xpath=//a[text()='�Զ���']");
		Thread.sleep(1000);	
		
		//1.��վ����ݽ��в���(ǰ�᣺ִ�б���ǰ��Ҫִ��ý����ϴ���Ƭ�ࣩ
		webtest.click("xpath=//h3[contains(.,'վ�����')]");
		Thread.sleep(1000);	
		//���ͼ��
		webtest.click("xpath=//button[contains(.,'ѡ��ͼ��')]");
		Thread.sleep(1000);	
		Add_Picture ap= new Add_Picture();
		ap.addpic(webtest,actions,"TheWinterLight");
		webtest.click("xpath=//button[contains(.,'�ü�ͼ��')]");
		//���վ�����
		webtest.type("id=_customize-input-blogname","���ո��");
		//���վ��ͼ��
		webtest.click("xpath=//button[contains(.,'ѡ��ͼ��')]");
		Thread.sleep(3000);	
		ap.addpic(webtest,actions,"TheWinterLight");
		webtest.click("xpath=//button[contains(.,'�ü�ͼ��')]");
		//����
		webtest.click("xpath=//button[@tabindex='0']");
		Thread.sleep(1000);			
		
		//2.����ɫ���в���
		webtest.click("xpath=//h3[contains(.,'��ɫ')]");
		Thread.sleep(1000);	
		//��ѡ��ɫ
		webtest.click("xpath=//input[@id='_customize-input-colorscheme-radio-dark']");
		//���Ķ���������ɫΪ��ɫ
		webtest.click("xpath=//button[@class='button wp-color-result']");
		webtest.click("xpath=//a[@style='background-color: rgb(255, 255, 255); height: 19.5784px; width: 19.5784px; margin-left: 3.6425px;']");		
		//����
		webtest.click("xpath=//button[@tabindex='0']");
		Thread.sleep(1000);	
		
		//3.��ҳ���ý��в���
		webtest.click("xpath=//h3[contains(.,'��ҳ����')]");
		Thread.sleep(1000);	
		//�ı�Ϊ��ҳ��ʾһ����̬ҳ��
		webtest.click("xpath=//input[@value='page']");
		Thread.sleep(1000);	
		//��ҳѡ��ʾ��ҳ��
		webtest.click("xpath=//select[@id='_customize-input-page_on_front']");
		Thread.sleep(1000);	
		webtest.click("xpath=//option[contains(.,'ʾ��ҳ��')]");
		Thread.sleep(1000);	
		//����
		webtest.click("xpath=//button[@tabindex='0']");
		Thread.sleep(1000);	
			
		//4.�������
		webtest.click("xpath=//input[@value='����']");
		
		//����
		assertTrue(webtest.ifContains("�ѷ���"));
	}
}