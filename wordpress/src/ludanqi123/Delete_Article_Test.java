package ludanqi123;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 
 * @author ludanqi
 * 删除文章
 *
 */

public class Delete_Article_Test extends BaseTest{

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
		Thread.sleep(3000);
		//移动语句只能使用driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(3000);
		//进入“所有文章”页面
		webtest.click("xpath=//a[text()='所有文章']");
		Thread.sleep(1000);	
		//点击题目上的回收站
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'冬日告白')]"))).perform();
		webtest.click("xpath=//a[@aria-label='移动“冬日告白”到垃圾箱']");
		//断言
		assertTrue(webtest.ifContains("已移动1篇文章到回收站"));
	}

}
