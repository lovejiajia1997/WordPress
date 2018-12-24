package project.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


public class Media_Test extends BaseTest {
	Login_Action action;
	
	@BeforeClass
	public void login() throws Exception
	{
		action=new Login_Action(webtest);
		//µÇÂ¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}
	
	@Test(priority=0)
	public void Upload() throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);",driver.findElement(By.id("menu-media")),"wp-has-submenu wp-not-current-submenu menu-top menu-icon-media opensub");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Ìí¼Ó']")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//input[starts-with(@id,'html5_')]")).sendKeys("F:\\641A6675.JPG");		
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public  void Delete() throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);",driver.findElement(By.id("menu-media")),"wp-has-submenu wp-not-current-submenu menu-top menu-icon-media opensub");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(.,'Ã½Ìå¿â')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='http://localhost:8032/wordpress/wp-content/uploads/2018/12/641A6675-10-100x100.jpg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(.,'ÓÀ¾ÃÉ¾³ý')]")).click();
		Thread.sleep(2000);
		webtest.alertAccept();

	}

}
