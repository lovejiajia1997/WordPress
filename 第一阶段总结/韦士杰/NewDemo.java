package NewPackage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewDemo {
	public static void main(String[]args) {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http:\\www.baidu.com";
		driver.get(baseUrl);

		System.out.println(driver.getTitle());
		driver.quit();
	}
	@Test
	public void visitRecentURL() {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");//调用Selenium驱动
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");//声明driver对象（将要启动什么浏览器）
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http:\\www.baidu.com";
		driver.get(baseUrl);
		//driver去打开浏览器并输入你要测试的网页地址（使用get方法打开测试站点）
		driver.manage().window().maximize();//将网页最大化
		WebElement search = driver.findElement(By.id("kw"));
		//定位搜索框
		search.sendKeys("淘宝");
		//在搜索框输入“淘宝”
		WebElement submitButton = driver.findElement(By.id("su"));
		//定位“百度一下”按键
		submitButton.click();
		//点击“百度一下”按键
		driver.navigate().back();//返回
		driver.navigate().forward();//前进
        driver.navigate().refresh();//刷新
        driver.close();

	}
	
	
}
