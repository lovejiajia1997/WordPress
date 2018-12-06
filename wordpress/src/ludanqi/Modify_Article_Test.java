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
 * 修改文章
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
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("ludanqi", "970901");
		Thread.sleep(1000);
		//移动语句只能使用driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(1000);
		//进入“所有文章”页面
		webtest.click("xpath=//a[text()='所有文章']");
		Thread.sleep(1000);	
		//点击题目上的回收站
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'冬日告白')]"))).perform();
		webtest.click("xpath=//a[@aria-label='编辑“测试标题”']");
		Thread.sleep(1000);	
		//关闭弹出对话框
		webtest.click("xpath=//button[@class='components-button components-icon-button nux-dot-tip__disable']");
		Thread.sleep(1000);	
		//修改文章
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='editor-block-list__insertion-point-inserter']"))).perform();
		webtest.click("xpath=//p[@aria-label='添加文字或输入/添加内容']");
		Thread.sleep(1000);	
		webtest.type("id=mce_0","记忆中");
		webtest.click("xpath=//button[contains(.,'更新')]");
		//断言
		assertTrue(webtest.ifContains("Post updated"));		
	}

}
