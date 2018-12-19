package com.webtest.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * @author 杨天莹 基类：初始化浏览器 关闭浏览器
 */

public class BaseTest {

	public WebDriverEngine webtest;
	private WebDriver driver;
	public String driverType;

	/*
	 * 
	 * public FirefoxProfile FilefoxDriverProfile() { // 声明一个profile对象
	 * FirefoxProfile profile = new FirefoxProfile();
	 * profile.setPreference("browser.download.folderList", 2);
	 * profile.setPreference("browser.download.manager.showWhenStarting", false);
	 * profile.setPreference("browser.download.dir", DownloadFilepath);
	 * profile.setPreference("browser.helperApps.neverAsk.openFile",
	 * "application/xhtml+xml,application/xml,application/x-msdownload,application/octet/octet-stream,application/exe,txt/csv,application/pdf,application/x-msexcl,application/x-excel,application/excel,image/png,image/jpeg,text/html,text/plain,text/x-c"
	 * ); profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
	 * "application/xhtml+xml,application/xml,application/x-msdownload,application/octet/octet-stream,application/exe,txt/csv,application/pdf,application/x-msexcl,application/x-excel,application/excel,image/png,image/jpeg,text/html,text/plain,text/x-c"
	 * ); // 不会打开未知MIMe类型
	 * profile.setPreference("browser.helperApps.alwaysAsk.force", false); //
	 * 不会弹出警告框 profile.setPreference("browser.download.manager.alertOnEXEopen",
	 * false); profile.setPreference("browser.download.manager.focusWhenStarting",
	 * false); profile.setPreference("browser.download.manager.useWindow", false);
	 * profile.setPreference("browser.download.manager.showAlertOnComplete", false);
	 * profile.setPreference("browser.download.manager.closewhenDone", false);
	 * return profile; }
	 */

	private WebDriver newWebDriver(String driverType) throws IOException {

		WebDriver driver = null;
		if (driverType.equalsIgnoreCase("firefox")) {
			String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
			Log.info("Using Firefox");
		} else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver", chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");

		} else {
			return null;
		}

		return driver;

	}

	@BeforeClass
	public void doBeforeSuite() throws Exception {

		driverType = ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);

	}

	/*
	 * @AfterSuite public void doAfterMethod() { if(this.driver != null){
	 * this.driver.quit(); } Log.info("Quitted Browser"); }
	 * 
	 * 
	 */

	public WebDriver getDriver() {
		return driver;
	}

}
