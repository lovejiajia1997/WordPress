package com.webtest.demo;

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
 * �޸�����
 *
 */

public class Modify_Article_Test extends BaseTest{

Login_Action action;
	
	@BeforeMethod
	public void setup()
	{
		action=new Login_Action(webtest);
	}

	@Test
	public void testLogin() throws Exception  {		
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("ludanqi", "970901");
		Thread.sleep(1000);
		//�ƶ����ֻ��ʹ��driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='����']"))).perform();
		Thread.sleep(1000);
		//���롰�������¡�ҳ��
		webtest.click("xpath=//a[text()='��������']");
		Thread.sleep(1000);	
		//�����Ŀ�ϵĻ���վ
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'���ո��')]"))).perform();
		webtest.click("xpath=//a[@aria-label='�༭�����Ա��⡱']");
		Thread.sleep(1000);	
		//�رյ����Ի���
		webtest.click("xpath=//button[@class='components-button components-icon-button nux-dot-tip__disable']");
		Thread.sleep(1000);	
		//�޸�����
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='editor-block-list__insertion-point-inserter']"))).perform();
		webtest.click("xpath=//p[@aria-label='������ֻ�����/�������']");
		Thread.sleep(1000);	
		webtest.type("id=mce_0","������");
		webtest.click("xpath=//button[contains(.,'����')]");
		//����
		assertTrue(webtest.ifContains("Post updated"));		
	}

}
