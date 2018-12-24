/**
 * @author:Î¤Ê¿½Ü
 * µÇÂ¼µÇ³ö
 */

package project.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/**
 * @author:Î¤Ê¿½Ü
 * µÇÂ¼µÇ³ö
 */
public class Login_Test extends BaseTest{
	Login_Action action;
	
	@Test(priority=0)
	public void loginIn() throws InterruptedException
	{
		action=new Login_Action(webtest);
		//µÇÂ¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}
	
	@Test(priority=1)
	public void loginOut() throws InterruptedException {
		action=new Login_Action(webtest);
		//µÇÂ¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('class',arguments[1]);",driver.findElement(By.id("wp-admin-bar-my-account")),"menupop with-avatar hover");
		Thread.sleep(3000);
		driver.findElement(By.linkText("µÇ³ö")).click();

		Thread.sleep(5000);
	}

}
