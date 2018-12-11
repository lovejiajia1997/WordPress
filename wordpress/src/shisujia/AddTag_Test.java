package shisujia;
/*
 * author:shisujia
 * ��ӱ�ǩ��
 */
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class AddTag_Test extends BaseTest{
	Login_Action action; 
	
	@BeforeMethod
	public void setup() throws Exception
	{
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
	}
	
	
	@Test
	public void addTag() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='����']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='��ǩ']")).click();
		Thread.sleep(1000);
		//�������		
		webtest.type("id=tag-name", "firstTag");
		//�������
		webtest.type("id=tag-slug", "��һ��tag");
		//�����ӱ�ǩ
		webtest.click("id=submit");
		Thread.sleep(1000);
		Assert.assertFalse(ifContains("���෨���Ѵ���ͬ����Ŀ"));
		System.out.println("��ӱ�ǩ�ɹ�");
	}
}
