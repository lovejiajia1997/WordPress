package com.webtest.demo;
import com.webtest.core.*;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 
 * @author ludanqi
 * ��������
 *
 */

public class Find_Article_Test extends BaseTest{

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
		driver.findElement(By.xpath("//a[text()='��������']")).click();
		Thread.sleep(1000);	
		//����������������"���ո��"
		webtest.type("id=post-search-input","���ո��");
		webtest.click("xpath=//input[@id='search-submit']");
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'���ո��')]"))).perform();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@aria-label='�鿴�����ո�ס�']");
		//����
		assertTrue(webtest.ifContains("����͢"));

	}

}
