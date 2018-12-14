package project.wordpress;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.webtest.core.WebDriverEngine;

public class Add_Picture{

	public void addpic(WebDriverEngine webtest,Actions actions,String picname) throws InterruptedException {
		webtest.click("xpath=//button[contains(.,'Γ½ΜεΏβ')]");
		Thread.sleep(1000);	
		webtest.type("class=search",picname);
		actions.sendKeys(Keys.ENTER).perform();
		webtest.click("xpath=//div[@class='thumbnail']");
		Thread.sleep(1000);	
		webtest.click("xpath=//button[@class='button media-button button-primary button-large media-button-select']");	
		Thread.sleep(1000);	
		webtest.click("//tr[last()-1");
		Thread.sleep(1000);	
	}
}
