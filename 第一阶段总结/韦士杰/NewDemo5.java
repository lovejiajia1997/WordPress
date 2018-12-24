package NewPackage;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewDemo5 {
	@Test
	public void identifyWindowByPageSource() {

		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");//调用Selenium驱动
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");//声明driver对象（将要启动什么浏览器）
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http:\\www.baidu.com";
		driver.get(baseUrl);
		String pwindowHandle = driver.getWindowHandle();
		System.out.println(pwindowHandle);
		WebElement link1 = 	driver.findElement(By.tagName("a"));
		link1.click();
		Set<String>allwindowHandles	= driver.getWindowHandles();
		if(!allwindowHandles.isEmpty());{
			for (String windowHandle : allwindowHandles) {
				if(driver.switchTo().window(windowHandle).getPageSource().contains("百度新闻")) {
					driver.findElement(By.tagName("a")).click();
					System.out.println("定位到第二个界面");
				}
			}
		}
		driver.switchTo().window(pwindowHandle);
		System.out.println(driver.getTitle());
	}

}
