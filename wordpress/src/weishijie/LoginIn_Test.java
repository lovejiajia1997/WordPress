package weishijie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginIn_Test {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://localhost:8032/wordpress/wp-login.php";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("weishijie");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("wsj12521");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(2000);
		//成功登录
	}
	@Test
	public void failLogin() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http://localhost:8032/wordpress/wp-login.php";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("weishijie");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("wsj11111");
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
		Thread.sleep(2000);
		//密码错误，登录失败
	}

}
