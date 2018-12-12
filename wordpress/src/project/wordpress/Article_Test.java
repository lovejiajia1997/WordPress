package project.wordpress;

/**
 * @author ludanqi
 * 文章操作类
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
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login("admin", "admin");
		Thread.sleep(1000);
	}

	@Test(priority=0)
	public void addArticle() throws Exception  {				
			
		//鼠标移动语句只能使用driver
		webtest.mouseoverElement("xpath=//div[text()='文章']");

		
		//进入“写文章”页面
		webtest.click("xpath=//a[text()='写文章']");
		Thread.sleep(1000);	
		
		//关闭弹出对话框
		webtest.click("xpath=//button[@class='components-button components-icon-button nux-dot-tip__disable']");
		Thread.sleep(1000);	
		
		//写文章（type只能传id,class,name,link,css,xpath,tag）
		webtest.type("id=post-title-0","冬日告白");
		webtest.enter();
		webtest.type("id=post-content-0","初雪渐渐，甜蜜来袭，耳边回响得都是最甜蜜的温暖告白。"
				+ "最美的时光往往不是别的风景，而是闲来无事。"
				+ "在冬日的下午，聆听朱正廷先生的《The Winter Light》，来赴雪中那温润少年的邀请！"
				+ "这个冬天，有渐渐初雪，有香甜可可，有甜蜜笑容，更有《冬日告白》");

		//发布文章
		webtest.click("xpath=//button[contains(.,'发布...')]");
		Thread.sleep(2000);	
		webtest.click("xpath=//button[@class='components-button editor-post-publish-button is-button is-default is-primary is-large']");
		
		//断言
		assertTrue(webtest.ifContains("Post published"));
	}
	
	
	@Test(priority=1)
	public void findArticle() throws Exception  {		
		
		//移动语句只能使用driver
		webtest.click("xpath=//div[text()='文章']");	
		
		//在搜索框搜索文章"冬日告白"
		webtest.type("id=post-search-input","冬日告白");
		webtest.click("xpath=//input[@id='search-submit']");
		webtest.mouseoverElement("xpath=//a[contains(.,'冬日告白')]");
		webtest.click("xpath=//a[@aria-label='查看“冬日告白”']");
		
		//断言
		assertTrue(webtest.ifContains("朱正廷"));
	}
	
	
	@Test(priority=2)
	public void modifyArticle() throws Exception  {		
		//移动语句只能使用driver
		webtest.click("xpath=//div[text()='文章']");	
		
		//点击题目上的回收站
		webtest.mouseoverElement("xpath=//a[contains(.,'冬日告白')]");	
		driver.findElement(By.xpath("//a[@aria-label='编辑“冬日告白”']")).click();
		Thread.sleep(1000);	
		driver.findElement(By.id("post-content-0")).sendKeys("记忆中");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'更新')]")).click();
		Thread.sleep(1000);	
		
		//断言
		assertTrue(webtest.ifContains("Post updated"));		
	}
	
	
	@Test(priority=3)
	public void deleteArticle() throws Exception  {		
		
		//进入“所有文章”页面
		webtest.click("xpath=//div[text()='文章']");
		Thread.sleep(1000);	
		
		//点击回收站
		webtest.mouseoverElement("xpath=//a[contains(.,'冬日告白')]");	
		driver.findElement(By.xpath("//a[@aria-label='移动“冬日告白”到垃圾箱']")).click();
		Thread.sleep(1000);
		
		//断言
		assertTrue(webtest.ifContains("已移动1篇文章到回收站"));
	}
}
