package shisujia;
/*
 * author:shisujia
 * ɾ����ǩ��
 */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class DeleteTag_Test extends BaseTest {
	Login_Action action; 
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	public boolean ifContains(String content) {
		return driver.getPageSource().contains(content);
	}
	
	@Test
	public void deleteTag() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='����']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='��ǩ']")).click();
		Thread.sleep(1000);
		actions.moveToElement(driver.findElement(By.xpath("//td[contains(.,'firstTag123firstTag123firsttag1230�༭ | ���ٱ༭ | ɾ�� | �鿴��ʾ����')]"))).perform();
		Thread.sleep(1000);
		webtest.click("xpath=//a[contains(@aria-label,'ɾ����firstTag123��')]");
		Thread.sleep(1000);
		//�������ڴ���
		Alert alert=driver.switchTo().alert();
		alert.accept();//�൱�ڵ��ȷ��
		System.out.println("ɾ����ǩ�ɹ�");
	
	}
}
