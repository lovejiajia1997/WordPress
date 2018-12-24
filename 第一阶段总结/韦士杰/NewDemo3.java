package NewPackage;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class NewDemo3 {
	@Test
	public void controlWindow() {
		wd.get("http://localhost:8032/MyMovie/");
		JavascriptExecutor js = (JavascriptExecutor)wd;
		js.executeScript("window.open('http://www.baidu.com/')");
		Set<String>window = Wd.getWindowHandles();
		for (String s : window) {
			System.out.println(s);
			boolean status = Wd.SwitchTo().window(s).getTitle().contains("My Movie");
			if (status) {
				Wd.findElement(By.linkText("登录")).click();
			}
		}
		Wd.close();
	}

}
