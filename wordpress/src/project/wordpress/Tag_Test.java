package project.wordpress;
import org.openqa.selenium.By;
import org.testng.Assert;
/*
 * author:shisujia
 * 标签操作类
 */
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;




public class Tag_Test extends BaseTest {
	Login_Action action;
	
	@BeforeClass
	public void login() throws Exception
	{
		action=new Login_Action(webtest);
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}
	
	@Test(priority=0)
	public void addTag() throws InterruptedException {
		
		webtest.mouseoverElement("xpath=//div[text()='文章']");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='标签']")).click();
		Thread.sleep(1000);
		//添加名称		
		webtest.type("id=tag-name", "firstTag");
		//添加名称
		webtest.type("id=tag-slug", "第一个tag");
		//点击添加标签
		webtest.click("id=submit");
		Thread.sleep(1000);
		Assert.assertFalse(ifContains("分类法中已存在同名项目"));
		System.out.println("添加标签成功");
	}
	
	
	@Test(priority=1)
	public void alterTag() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='文章']");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='标签']")).click();
		Thread.sleep(3000);
		webtest.mouseoverElement("xpath=//td[contains(.,'firstTagfirstTag第一个tag0编辑 | 快速编辑 | 删除 | 查看显示详情')]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@aria-label='编辑“firstTag”']");
		Thread.sleep(3000);
		webtest.typeAndClear("id=name", "firstTag123");
		webtest.typeAndClear("id=slug", "firstTag123");
		webtest.type("id=description", "我是WordPress项目的第一个标签呀");
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(3000);
		System.out.println("修改标签成功");
	}
	
	
	@Test(priority=2)
	public void deleteTag() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='文章']");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='标签']")).click();
		Thread.sleep(1000);
		webtest.mouseoverElement("xpath=//td[contains(.,'firstTag123firstTag123firsttag1230编辑 | 快速编辑 | 删除 | 查看显示详情')]");	
		webtest.click("xpath=//a[contains(@aria-label,'删除“firstTag123”')]");
		Thread.sleep(1000);
		//弹出窗口处理
		webtest.alertAccept();
		System.out.println("删除标签成功");
	
	}
}
