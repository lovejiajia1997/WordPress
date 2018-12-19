package project.wordpress;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����4:38:42 
* wordpress��Ŀ
*   ���ģ���£�С������ɾ�Ĳ�Ĳ����� 
*   ByUser �����Զ���ҳ���¶�С���߽�����ɾ�Ĳ�Ȳ���
*/

public class LittleTools_Action {
	
	private WebDriverEngine webtest;
	
	int toolsid = 24;//������ҳ�������ǵڼ������ֵ�С���ߣ�������־��Ǽ�
	int editi = 3;//ҳ���г��ֵ��Ǽ���С���ߣ�������־��Ǽ�
	
	String editid = "widget-"+toolsid+"_rss-"+editi;
	//������水ť
	String savepath = "//input[@id='savewidget']";
	
	
	public void addTools() {
		String addid = "widget-1_rss-__i__";
		this.tools();
		webtest.click("xpath=//div[@id='"+addid+"']/div/div/a/span[@class='add']");
		webtest.click("xpath="+savepath);
	}
	
	public void addToolsByUser() {
		this.toolsByUser();
		webtest.pause(1000);
		webtest.click("xpath=//h3[contains(.,'���ͱ���')]");
		webtest.click("xpath=//button[contains(.,'����С����')]");
		webtest.click("id=widget-1_rss-__i__");
		webtest.tapClick();webtest.tapClick();webtest.tapClick();webtest.tapClick();
		webtest.tapClick();webtest.tapClick();webtest.tapClick();webtest.tapClick();
		webtest.enter();
		webtest.click("id=save");
	}
	
	
	public void editTools(String url,String i) {
		this.tools();
		webtest.click("xpath=//div[@id='"+editid+"']/div/div/a/span[@class='edit']");
		//�ڴ�����RSS feed URL
		webtest.type("xpath=//input[@id='rss-url-"+editi+"']", url);
		//�����˵�
		webtest.selectByValue("xpath=//select[@id='rss-items-"+editi+"']", i);
		//��ѡ��,��ʾ��Ŀ����
		webtest.click("xpath=//input[@id='rss-show-author-"+editi+"']");
		webtest.click("xpath=//input[@id='rss-show-date-"+editi+"']");
		
		webtest.click("xpath="+savepath);
	}
	
	
	public void delTools() {
		this.tools();
		webtest.click("xpath=//div[@id='"+editid+"']/div/div/a/span[@class='edit']");
		webtest.click("xpath=//input[@id='removewidget']");
	}
	
	
	public void delToolsByUser() {
		this.toolsByUser();
		webtest.pause(1000);
		webtest.click("xpath=//h3[contains(.,'���ͱ���')]");
		webtest.click("xpath=//div[starts-with(@id,'widget-24_rss-')]");
		webtest.tapClick();webtest.tapClick();webtest.tapClick();
		webtest.tapClick();webtest.tapClick();webtest.tapClick();
		webtest.tapClick();webtest.tapClick();webtest.tapClick();
		webtest.tapClick();webtest.tapClick();webtest.tapClick();
		webtest.tapClick();webtest.tapClick();
		webtest.enter();
//		webtest.click("xpath=//button[contains(.,'�Ƴ�')]");
		webtest.pause(1000);
		webtest.click("id=save");
	
	}
	
	public LittleTools_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("id=wp-submit");
	}
	
	public void tools() {
		this.login();
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[text()='С����']");
	}
	
	public void toolsByUser() {
		this.login();
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[text()='�Զ���']");
		webtest.click("xpath=//h3[contains(.,'С����')]");
	}
	
	
}