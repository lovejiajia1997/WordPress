package project.wordpress;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

/**
 * author:刘江
 * 创建页面
 */


public class Pages_Test extends BaseTest{
	
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
	public void caeatePagesTest() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='页面']");
		Thread.sleep(2000);
		//进入“写新建页面”页面
		driver.findElement(By.xpath("//a[text()='新建页面']")).click();
		Thread.sleep(1000);	
		webtest.type("id=post-title-0", "页面");
		webtest.type("id=post-content-0", "这是页面的内容");
		webtest.click("xpath=//button[contains(.,'发布...')]");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'发布')]")).click();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=1)
	public void findPages() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='页面']");
		Thread.sleep(2000);
		//进入“写新建页面”页面
		driver.findElement(By.xpath("//a[text()='所有页面']")).click();
		Thread.sleep(1000);	
		webtest.type("name=s", "test");
		webtest.click("id=search-submit");
		Thread.sleep(5000);
	}
	
	
	@Test(priority=2)
	public void changePages() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='页面']");
		Thread.sleep(2000);
		//进入“写新建页面”页面
		driver.findElement(By.xpath("//a[text()='所有页面']")).click();
		Thread.sleep(1000);	
		webtest.mouseoverElement("xpath=//a[@aria-label='“页面”（编辑）']");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@aria-label='编辑“页面”']")).click();
		webtest.typeAndClear("id=post-title-0", "test");
		webtest.typeAndClear("id=post-content-0", "test");
		driver.findElement(By.xpath("//button[contains(.,'更新')]")).click();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=3)
	public void deletePages() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='页面']");
		Thread.sleep(2000);
		//进入“写新建页面”页面
		driver.findElement(By.xpath("//a[text()='所有页面']")).click();
		Thread.sleep(1000);	
		webtest.mouseoverElement("xpath=//a[@aria-label='“test”（编辑）']");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@aria-label='移动“test”到垃圾箱']")).click();
		Assert.assertTrue(ifContains("已移动1篇文章到回收站"));
		
	}
}
