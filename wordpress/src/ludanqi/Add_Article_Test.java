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
 * 创建新文章
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
	public void testLogin() throws Exception  {		
		
		//执行本类前需要执行媒体库上传照片类
		
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("ludanqi", "970901");
		Thread.sleep(1000);
		//鼠标移动语句只能使用driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(1000);
		//进入“写文章”页面
		webtest.click("xpath=//a[text()='写文章']");
		Thread.sleep(1000);	
		//关闭弹出对话框
		webtest.click("xpath=//button[@class='components-button components-icon-button nux-dot-tip__disable']");
		Thread.sleep(1000);	
		//写文章（type只能传id,class,name,link,css,xpath,tag）
		webtest.type("id=post-title-0","冬日告白");
		actions.sendKeys(Keys.ENTER).perform();
		webtest.type("id=mce_0","初雪渐渐，甜蜜来袭，耳边回响得都是最甜蜜的温暖告白。"
				+ "最美的时光往往不是别的风景，而是闲来无事。"
				+ "在冬日的下午，聆听朱正廷先生的《The Winter Light》，来赴雪中那温润少年的邀请！"
				+ "这个冬天，有渐渐初雪，有香甜可可，有甜蜜笑容，更有《冬日告白》");
		//添加图片
		actions.sendKeys(Keys.ENTER).perform();
		actions.moveToElement(driver.findElement(By.xpath("//p[@id='mce_1']"))).perform();
		webtest.click("xpath=//button[@aria-label='添加图像']");
		Thread.sleep(1000);	
		webtest.click("xpath=//button[contains(.,'媒体库')]");
		Thread.sleep(1000);	
		webtest.type("class=search","TheWinterLight");
		actions.sendKeys(Keys.ENTER).perform();
		webtest.click("xpath=//div[@class='thumbnail']");
		Thread.sleep(1000);	
		webtest.click("xpath=//button[@class='button media-button button-primary button-large media-button-select']");	
		Thread.sleep(1000);	
		
//		//预览
//		webtest.click("xpath=//button[contains(.,'预览')]");
//		Thread.sleep(5000);	
////		webtest.click("xpath=//a[@class='post-edit-link']");
////		Thread.sleep(1000);	
//		actions.keyDown(Keys.CONTROL).sendKeys(driver.findElement(By.tagName("input")),"w").keyUp(Keys.CONTROL).perform();
		
		//发布文章
		webtest.click("xpath=//button[contains(.,'发布...')]");
		Thread.sleep(1000);	
		webtest.click("xpath=//button[@class='components-button editor-post-publish-button is-button is-default is-primary is-large']");
		
		//断言
		assertTrue(webtest.ifContains("Post published"));
	}

}
