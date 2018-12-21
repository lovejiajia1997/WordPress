package project.wordpress;
/**
 * @author ludanqi
 * 目录操作类
 */
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

import ludanqi123.Login_Action;

public class Catalog_Test extends BaseTest{
	
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
	public void addCatalog() throws Exception  {	
		
		//鼠标移动语句只能使用driver
		webtest.mouseoverElement("xpath=//div[text()='文章']");	
		//进入“分类目录”页面
		driver.findElement(By.xpath("//a[text()='分类目录']")).click();
		Thread.sleep(1000);
		
		//创建目录
		webtest.type("name=tag-name","theo");
		webtest.type("id=tag-slug","zzt");
		webtest.click("xpath=//input[@id='submit']");
		
		//断言
		assertTrue(webtest.ifContains("theo"));
	}
	
	@Test(priority=1)
	public void findCataLog() throws Exception  {	
		
		//鼠标移动语句只能使用driver
		webtest.mouseoverElement("xpath=//div[text()='文章']");
		
		//进入“分类目录”页面
		driver.findElement(By.xpath("//a[text()='分类目录']")).click();
		Thread.sleep(1000);	
		
		//在搜索框搜索"theo"目录
		webtest.type("id=tag-search-input","theo");
		webtest.click("xpath=//input[@class='button']");
		webtest.mouseoverElement("xpath=//a[@aria-label='“theo”（编辑）']");
		webtest.click("xpath=//a[@aria-label='查看“theo”存档']");
		Thread.sleep(1000);	
		
		//断言
		assertTrue(webtest.ifContains("未找到"));
		webtest.goBack();
	}
	
	@Test(priority=2)
	public void modifyCatalog() throws Exception  {	

		//鼠标移动语句只能使用driver
		webtest.mouseoverElement("xpath=//div[text()='文章']");

		//进入“分类目录”页面
		driver.findElement(By.xpath("//a[text()='分类目录']")).click();
		Thread.sleep(1000);
		
		//修改目录
		webtest.mouseoverElement("xpath=//a[@aria-label='“theo”（编辑）']");
		webtest.click("xpath=//a[@aria-label='编辑“theo”']");
		Thread.sleep(1000);	
		webtest.type("name=name","love");
		webtest.type("name=slug","love");
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(1000);
		
		//断言
		assertTrue(webtest.ifContains("分类已更新"));
	}
	
	
	@Test(priority=3)
	public void deleteCataLog() throws Exception  {	
		
		//鼠标移动语句只能使用driver
		webtest.mouseoverElement("xpath=//div[text()='文章']");
		//进入“分类目录”页面
		driver.findElement(By.xpath("//a[text()='分类目录']")).click();
		Thread.sleep(1000);
		//删除目录

		webtest.mouseoverElement("xpath=//a[contains(.,'theolove')]");
		webtest.runJs("arguments[0].click();","xpath=//a[contains(.,'删除')]");
		Thread.sleep(1000);	
		//在弹出对话框中选择确定（取消为dismiss）
		webtest.alertAccept();	
		
		//断言
		assertFalse(webtest.ifContains("lovetheo"));
	}
}
