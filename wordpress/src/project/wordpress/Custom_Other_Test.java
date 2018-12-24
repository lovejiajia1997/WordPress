package project.wordpress;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * 
 * @author ludanqi
 * 对自定义模块中除“主题、小工具、菜单、顶部”外的其他部分进行测试
 *
 */
public class Custom_Other_Test extends BaseTest{

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

	@Test
	public void custom() throws Exception  {		
		
		//鼠标移动语句只能使用driver
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='外观']"))).perform();
		Thread.sleep(1000);
		//进入“自定义”页面
		webtest.click("xpath=//a[text()='自定义']");
		Thread.sleep(1000);	
		
		//1.对站点身份进行操作(前提：执行本类前需要执行媒体库上传照片类）
		webtest.click("xpath=//h3[contains(.,'站点身份')]");
		Thread.sleep(1000);	
		//添加图标
		webtest.click("xpath=//button[contains(.,'选择图标')]");
		Thread.sleep(1000);	
		Add_Picture ap= new Add_Picture();
		ap.addpic(webtest,actions,"TheWinterLight");
		webtest.click("xpath=//button[contains(.,'裁剪图像')]");
		//添加站点标题
		webtest.type("id=_customize-input-blogname","冬日告白");
		//添加站点图标
		webtest.click("xpath=//button[contains(.,'选择图像')]");
		Thread.sleep(3000);	
		ap.addpic(webtest,actions,"TheWinterLight");
		webtest.click("xpath=//button[contains(.,'裁剪图像')]");
		//返回
		webtest.click("xpath=//button[@tabindex='0']");
		Thread.sleep(1000);			
		
		//2.对颜色进行操作
		webtest.click("xpath=//h3[contains(.,'颜色')]");
		Thread.sleep(1000);	
		//勾选暗色
		webtest.click("xpath=//input[@id='_customize-input-colorscheme-radio-dark']");
		//更改顶部文字颜色为白色
		webtest.click("xpath=//button[@class='button wp-color-result']");
		webtest.click("xpath=//a[@style='background-color: rgb(255, 255, 255); height: 19.5784px; width: 19.5784px; margin-left: 3.6425px;']");		
		//返回
		webtest.click("xpath=//button[@tabindex='0']");
		Thread.sleep(1000);	
		
		//3.主页设置进行操作
		webtest.click("xpath=//h3[contains(.,'主页设置')]");
		Thread.sleep(1000);	
		//改变为主页显示一个静态页面
		webtest.click("xpath=//input[@value='page']");
		Thread.sleep(1000);	
		//主页选择示例页面
		webtest.click("xpath=//select[@id='_customize-input-page_on_front']");
		Thread.sleep(1000);	
		webtest.click("xpath=//option[contains(.,'示例页面')]");
		Thread.sleep(1000);	
		//返回
		webtest.click("xpath=//button[@tabindex='0']");
		Thread.sleep(1000);	
			
		//4.保存更改
		webtest.click("xpath=//input[@value='发布']");
		
		//断言
		assertTrue(webtest.ifContains("已发布"));
	}
}