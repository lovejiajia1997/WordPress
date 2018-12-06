package ludanqi123;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * 
 * @author ludanqi
 * 删除目录
 *
 */

public class Delete_Catalog_Test extends BaseTest{

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
		//鼠标移动语句只能使用driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='文章']"))).perform();
		Thread.sleep(1000);
		//进入“分类目录”页面
		webtest.click("xpath=//a[text()='分类目录']");
		Thread.sleep(1000);	
		//删除目录
		actions.moveToElement(driver.findElement(By.xpath("//a[@aria-label='“theo”（编辑）']"))).perform();
		webtest.click("xpath=//a[@aria-label='删除“theo”']");
		Thread.sleep(1000);	
		//在弹出对话框中选择确定（取消为dismiss）
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);	
		//断言
		assertFalse(webtest.ifContains("lovetheo"));
	}
}