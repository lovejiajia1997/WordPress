package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * @author 杨天莹 工具模块测试
 */
public class Tools_Test extends BaseTest {

	Login_Action action;

	@BeforeMethod
	public void setup() {
		action = new Login_Action(webtest);
	}

	// 导入文章
	@Test(description = "导入文章")
	public void Tools_In() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "yty");
		webtest.typeAndClear("id=user_pass", "12345678");
		webtest.click("xpath=//input[@id='wp-submit']");

		webtest.click("xpath=//div[text()='工具']");
		webtest.click("link=导入");
		// 安装
		webtest.click("xpath=//a[@aria-label='安装Movable Type和TypePad']");
		// 导入
		webtest.click("xpath=//a[@aria-label='运行Blogger']");
		webtest.type("xpath=//input[@id='upload']", "C:\\Users\\杨天莹\\Desktop\\PS\\PS.txt");
		webtest.click("xpath=//input[@id='submit']");
		webtest.click("xpath=//input[@value='Submit']");
		assertTrue(webtest.ifContains("All done"));
	}

	// 导出文章【存在问题未实现】
//	@Test(description = "导出文章【存在问题未实现】")
	public void Tools_Out() throws InterruptedException {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "yty");
		webtest.typeAndClear("id=user_pass", "12345678");
		webtest.click("xpath=//input[@id='wp-submit']");

		webtest.click("xpath=//div[text()='工具']");
		webtest.click("link=导出");
//		webtest.runJs("arguments[0].click();", "xpath=//label[contains(.,'文章')");
		webtest.runJs("arguments[0].click();", "xpath=//input[@value='posts']");
		Thread.sleep(3000);
		// webtest.click("xpath=//label[contains(text(),'文章')");
//		driver.findElement(By.xpath("//label[contains(.,' 文章')]"));
		webtest.click("xpath=//select[@id='cat']");
		webtest.selectByVisibleText("xpath=//select[@id='cat']", "影视作品");
		webtest.click("xpath=//input[@id='submit']");
//		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyEnter();
	}

	// 插件启用测试[启用你好，多莉]
	@Test()
	public void Duoli() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		webtest.typeAndClear("id=user_login", "yty");
		webtest.typeAndClear("id=user_pass", "12345678");
		webtest.click("xpath=//input[@id='wp-submit']");

		webtest.click("xpath=//div[contains(text(),'插件')]");
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.click("xpath=//a[@aria-label='激活你好多莉']");
	}

}
