package NewPackage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewDemo4 {
	@Test
	public void inputText() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");//调用Selenium驱动
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");//声明driver对象（将要启动什么浏览器）
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http:\\www.baidu.com";
		driver.get(baseUrl);
		WebElement input = driver.findElement(By.id("kw"));
		input.clear();//清空
		Thread.sleep(3000);
		input.sendKeys("hello");
		input.getText();
		input.submit();
		Thread.sleep(3000);
		driver.close();
	}

}