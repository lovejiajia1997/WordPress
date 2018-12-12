package project.wordpress;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


/**
 * author:yuezhewei
 * Settings
 */
public class Settings_Test extends BaseTest {
	
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
	
	
	@Test(priority=0,description="×«Ð´")
	  public void compose() {
		  webtest.click("link=Settings");
		  webtest.click("link=×«Ð´");
		  webtest.selectByValue("name=default_category", "2");
		  webtest.selectByValue("id=default_post_format", "0");
		  webtest.typeAndClear("id=mailserver_url", "541520730@qq.com");
		  webtest.typeAndClear("id=mailserver_login", "ceshi");
		  webtest.typeAndClear("id=mailserver_pass", "123456");
		  webtest.selectByValue("id=default_email_category", "2");
		  webtest.click("xpath=//input[@type='submit']");
	  }
	
	
	@Test(priority=1,description="ÌÖÂÛ")
	public void discuss() {
		webtest.click("link=Settings");
		  webtest.click("link=ÌÖÂÛ");				 
		  webtest.click("xpath=//input[@id='default_pingback_flag']");
		  webtest.click("xpath=//input[@id='default_ping_status']");
		  webtest.click("xpath=//input[@id='default_comment_status']");
		  
		  webtest.click("xpath=//input[@id='require_name_email']");
		  webtest.click("xpath=//input[@id='comment_registration']");
		  webtest.click("xpath=//input[@id='close_comments_for_old_posts']");
		  webtest.typeAndClear("name=close_comments_days_old", "999999999");
		  
		  webtest.click("xpath=//input[@id='show_comments_cookies_opt_in']");
		  webtest.click("xpath=//input[@id='thread_comments']");
		  webtest.selectByValue("id=thread_comments_depth","3");
		  
		  webtest.click("xpath=//input[@id='page_comments']");
		  webtest.typeAndClear("name=comments_per_page", "999999999");
		  webtest.selectByValue("id=default_comments_page","oldest");
		  
		  webtest.click("xpath=//input[@id='comments_notify']");
		  webtest.click("xpath=//input[@id='moderation_notify']");
		  webtest.click("xpath=//input[@id='comment_moderation']");
		  webtest.click("xpath=//input[@id='comment_whitelist']");
		  
		  webtest.typeAndClear("name=moderation_keys", "upup²âÊÔ");
		  webtest.typeAndClear("name=blacklist_keys", "upup²âÊÔ");
		  
		  webtest.typeAndClear("name=comment_max_links", "999999999");
		  webtest.click("xpath=//input[@type='submit']");
	}
	
	@Test(priority=2)
	public void medio() throws InterruptedException {
		  webtest.click("link=Settings");	
		  webtest.click("link=¹Ì¶¨Á´½Ó");		 
		  webtest.pause(1000);
		  webtest.click("link=ÆÓËØ");	
		  webtest.typeAndClear("name=category_base", "yuezhewei");
		  webtest.typeAndClear("name=tag_base", "upup");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=3)
	public void medio1() throws InterruptedException {
		  webtest.click("link=Settings");
		  webtest.click("link=¹Ì¶¨Á´½Ó");		 
		  webtest.pause(1000);
		  webtest.click("link=ÈÕÆÚºÍÃû³ÆÐÍ");	
		  webtest.typeAndClear("name=category_base", "yuezhewei");
		  webtest.typeAndClear("name=tag_base", "upup");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=4)
	public void medio2() throws InterruptedException {
		  webtest.click("link=Settings");
		  webtest.click("link=¹Ì¶¨Á´½Ó");		 
		  webtest.pause(1000);
		  webtest.click("link=custom");	
		  webtest.typeAndClear("name=category_base", "yuezhewei");
		  webtest.typeAndClear("name=tag_base", "upup");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	
	
	@Test(priority=5)
	public void medio3() throws InterruptedException {
		  webtest.click("link=Settings");		 
		  webtest.pause(1000);
		  webtest.click("xpath=//a[@href='options-media.php']");	
		  webtest.typeAndClear("name=thumbnail_size_w", "0");
		  webtest.typeAndClear("name=thumbnail_size_h", "0");
		  webtest.click("xpath=//input[@id='thumbnail_crop']");
		  
		  webtest.typeAndClear("name=medium_size_w", "0");
		  webtest.typeAndClear("name=medium_size_h", "0");
		  webtest.typeAndClear("name=large_size_w", "0");		  
		  webtest.typeAndClear("name=large_size_h", "0");	
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=6)
	public void medio4() {
		  webtest.click("link=Settings");
		  webtest.pause(1000);
		  webtest.click("xpath=//a[@href='options-media.php']");
		  webtest.typeAndClear("name=thumbnail_size_w", "1");
		  webtest.typeAndClear("name=thumbnail_size_h", "2");
		  webtest.click("xpath=//input[@id='thumbnail_crop']");
		  
		  webtest.typeAndClear("name=medium_size_w", "3");
		  webtest.typeAndClear("name=medium_size_h", "4");
		  webtest.typeAndClear("name=large_size_w", "5");
		  webtest.typeAndClear("name=large_size_h", "6");
		  webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=7)
	public void medio5() {
		  webtest.click("link=Settings");
		  webtest.pause(1000);
		  webtest.click("xpath=//a[@href='options-media.php']");	
		  webtest.typeAndClear("name=thumbnail_size_w", "999999999");
		  webtest.typeAndClear("name=thumbnail_size_h", "999999999");
		  webtest.click("xpath=//input[@id='thumbnail_crop']");
		  
		  webtest.typeAndClear("name=medium_size_w", "999999999");
		  webtest.typeAndClear("name=medium_size_h", "999999999");
		  webtest.typeAndClear("name=large_size_w", "999999999");
		  webtest.typeAndClear("name=large_size_h", "999999999");
		  webtest.click("xpath=//input[@type='submit']");
	}
	
	@Test(priority=8)
	  public void read() throws InterruptedException {

		webtest.click("link=Settings");
		webtest.click("link=ÔÄ¶Á");		 		  
		webtest.typeAndClear("name=posts_per_page","0");
		webtest.typeAndClear("name=posts_per_rss", "0");	 
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(1000);	
    }
	  @Test(priority=9)
	  public void read1() throws InterruptedException {

		  webtest.click("link=Settings");
		  webtest.click("link=ÔÄ¶Á");		 		  
		  webtest.typeAndClear("name=posts_per_page","1");
		  webtest.typeAndClear("name=posts_per_rss", "1");	 
		  webtest.click("xpath=//input[@type='submit']");
		  Thread.sleep(1000);	
	  }
	  @Test(priority=10)
	  public void read2() throws InterruptedException {
			
		  webtest.click("link=Settings");
		  webtest.click("link=ÔÄ¶Á");		 		  
		  webtest.typeAndClear("name=posts_per_page","99999999999");
		  webtest.typeAndClear("name=posts_per_rss", "99999999999");	 
		  webtest.click("xpath=//input[@type='submit']");
		  Thread.sleep(1000);	
    
    } 
	  
	  @Test(priority=11)
	   public void routine() throws InterruptedException {
		   webtest.click("link=Settings");
		   webtest.typeAndClear("id=blogname","upup");	   
		   webtest.typeAndClear("name=blogdescription", "wordpressÕ¾µã");
		   webtest.typeAndClear("name=new_admin_email", "541520730@qq.com");
		   webtest.click("xpath=//input[@type='checkbox']");
		   webtest.selectByValue("id=default_role","editor");
		   webtest.selectByValue("id=WPLANG", "zh_CN");
		   webtest.click("xpath=//input[@id='submit']");
		   
	   } 
	
}
