package shisujia;

import org.testng.annotations.Test;

import com.webtest.core.WebDriverEngine;

public class AddUser_Action {
		public WebDriverEngine webtest = null;
		public AddUser_Action(WebDriverEngine webtest) {
			this.webtest = webtest;
		}
		
		@Test
		public void add_movie(String filmname,String petname,String director,
				String editor,String nation,String language,String showtime,
				String minutes,String picname) {
			webtest.type("name=filmname",filmname);
			webtest.type("name=petname",petname);
			webtest.type("name=director",director);
			webtest.type("name=editor",editor);
			webtest.type("name=nation",nation);
			webtest.type("name=language",language);
			webtest.type("name=showtime",showtime);
			webtest.type("name=minutes",minutes);
			webtest.click("xpath=//span[text()='添加影片信息']");
			webtest.type("name=picname",picname);
			webtest.click("xpath=//button[@type='submit']");
			webtest.click("xpath=//span[text()='添加影片信息']");
		}
}