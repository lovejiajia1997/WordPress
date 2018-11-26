package NewPackage;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewDemo2 {
	@Test
	public void getPage() {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http:\\www.baidu.com";
		driver.get(baseUrl);
		String title = driver.getTitle();//获得title
		String pageSource = driver.getPageSource();//获得源代码
		String pageUrl = driver.getCurrentUrl();
		System.out.println(title+pageSource+pageUrl);
		driver.quit();	
	}

}
