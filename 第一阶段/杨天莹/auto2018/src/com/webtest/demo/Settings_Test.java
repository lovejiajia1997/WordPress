package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * @author 杨天莹 Settings测试
 */
public class Settings_Test extends BaseTest {
	Login_Action action;

	@BeforeMethod
	public void setup() {
		action = new Login_Action(webtest);
	}

	// 评论数量的设置
	@Test
	public void Settings_MorePage() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		action.login("yty", "12345678");
		webtest.click("xpath=//div[text()='Settings ']");
		webtest.click("link=阅读");
		webtest.typeAndClear("xpath=//input[@id='posts_per_page']", "20");
//		webtest.type("xpath=//input[@id='posts_per_page']", "20");
		webtest.click("xpath=//input[text()='全文']");
		webtest.click("xpath=//input[@value='保存更改']");
	}

	// 评论黑名单设置
	@Test
	public void Set_BlackList() throws InterruptedException {
		webtest.open("http://localhost:8032/wordpress/wp-login.php?");
		action.login("yty", "12345678");
		webtest.click("xpath=//div[text()='Settings ']");
		webtest.click("link=讨论");
		for (int i = 0; i < 12; i++) {
			webtest.KeyDown();
		}
		webtest.click("xpath=//textarea[@id='blacklist_keys']");
		webtest.type("xpath=//textarea[@id='blacklist_keys']", "恶劣");

		// 鼠标移出
		webtest.click("xpath=//th[text()='评论黑名单']");

		for (int i = 0; i < 5; i++) {
			webtest.KeyDown();
		}
		webtest.click("xpath=//input[@value='保存更改']");
	}

}
