package project.wordpress;

/*
 * author:shisujia
 * 用户操作类
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/*
 * author:shisujia
 * 用户操作类
 */
public class User_Test extends BaseTest{
	Login_Action action;
	
	@BeforeClass
	public void login() throws InterruptedException
	{
		action=new Login_Action(webtest);
		//登录
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}
	
	
	@Test(priority=0)
	public void addUser() throws Exception {
		
		webtest.mouseoverElement("xpath=//div[text()='用户']");
		driver.findElement(By.xpath("//a[text()='添加用户']")).click();
		Thread.sleep(3000);
		webtest.type("id=user_login","1234567" );
		webtest.type("id=email","1234567@qq.com" );
		webtest.type("id=first_name","素佳" );
		webtest.type("id=last_name","史" );
		webtest.click("xpath=//button[text()='显示密码']" );
		webtest.typeAndClear("id=pass1-text","1234567" );
		webtest.click("name=pw_weak");
		webtest.click("id=role");
		webtest.click("xpath=//option[text()='管理员']");
		webtest.click("id=createusersub");
		System.out.println("添加用户成功");
	}
	
	
	@Test(priority=1)
	public void alterUser() throws InterruptedException {
		webtest.mouseoverElement("xpath=//div[text()='用户']");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='我的个人资料']")).click();
		Thread.sleep(2000);
		webtest.typeAndClear("id=first_name", "名字");
		webtest.typeAndClear("id=last_name", "姓氏");
		webtest.typeAndClear("id=nickname", "佳佳");
		webtest.click("id=display_name");
		webtest.click("xpath=//option[contains(.,'姓氏 名字')]");
		webtest.click("id=submit");	
		Assert.assertTrue(ifContains("已更新用户"));
	}
	
	@Test(priority=2)
	public void findUser() throws InterruptedException {
		webtest.click("xpath=//div[text()='用户']");
		webtest.type("id=s", "1234567");
		webtest.click("id=search-submit");
		Assert.assertTrue(ifContains("1234567"));
	}
	
	@Test(description="删除单个用户",priority=3)
	public void deleteUser() throws Exception  {
		webtest.click("xpath=//div[text()='用户']");
		webtest.mouseoverElement("xpath=//a[text()='1234567']");
		Thread.sleep(3000);
		webtest.runJs("arguments[0].click();", "xpath=//a[contains(.,'删除')]");
		webtest.click("id=submit");
		Assert.assertTrue(ifContains("用户已删除"));
	}
}
