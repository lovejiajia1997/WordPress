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
 * 查找文章
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
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("ludanqi", "970901");
		Thread.sleep(1000);
		//移动语句只能使用driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(1000);
		//进入“所有文章”页面
		driver.findElement(By.xpath("//a[text()='所有文章']")).click();
		Thread.sleep(1000);	
		//在搜索框搜索文章"冬日告白"
		webtest.type("id=post-search-input","冬日告白");
		webtest.click("xpath=//input[@id='search-submit']");
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'冬日告白')]"))).perform();
		Thread.sleep(1000);
		webtest.click("xpath=//a[@aria-label='查看“冬日告白”']");
		//断言
		assertTrue(webtest.ifContains("朱正廷"));

	}

}
