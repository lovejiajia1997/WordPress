package shenmengqi;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����4:38:42 
* wordpress��Ŀ
*   ���ģ���£�С������ɾ�Ĳ�Ĳ����� 
*/

public class LittleTools_Action {
	
	private WebDriverEngine webtest;
	
	String addtoolspath = "html.wp-toolbar body.wp-admin.wp-core-ui.js.widgets_access.widgets-php.auto-fold.admin-bar.branch-4-9.version-4-9-8.admin-color-fresh.locale-zh-cn.customize-support.svg div#wpwrap div#wpcontent div#wpbody div#wpbody-content div.wrap div.widget-liquid-left div#widgets-left div#available-widgets.widgets-holder-wrap div.widget-holder div#widget-list div#widget-1_rss-__i__.widget div.widget-top div.widget-title-action a.widget-control-edit.hide-if-js";
	String edittoolspath = "html.wp-toolbar body.wp-admin.wp-core-ui.js.widgets_access.widgets-php.auto-fold.admin-bar.branch-4-9.version-4-9-8.admin-color-fresh.locale-zh-cn.customize-support.svg div#wpwrap div#wpcontent div#wpbody div#wpbody-content div.wrap div.widget-liquid-right div#widgets-right.wp-clearfix.single-sidebar div.sidebars-column-1 div.widgets-holder-wrap div#sidebar-1.widgets-sortables div#widget-18_rss-2.widget div.widget-top div.widget-title-action a.widget-control-edit.hide-if-js";
	String savepath = "//input[@id='savewidget']";
	
	
	public void addTools() {
		this.tools();
		webtest.click("css="+addtoolspath);
		webtest.click("xpath="+savepath);
	}
	
	
	public void editTools(String url,String i) {
		this.tools();
		webtest.click("css="+edittoolspath);
		//�ڴ�����RSS feed URL
		webtest.type("xpath=//input[@id='rss-url-2']", url);
		//�����˵�
		webtest.selectByValue("xpath=//select[@id='rss-items-2']", i);
		//��ѡ��,��ʾ��Ŀ����
		webtest.click("xpath=//input[@id='rss-show-author-2']");
		webtest.click("xpath=//input[@id='rss-show-date-2']");
		
		webtest.click("xpath="+savepath);
	}
	
	
	public void delTools() {
		this.tools();
		webtest.click("css="+edittoolspath);
		webtest.click("xpath=//input[@id='removewidget']");
		webtest.click("xpath="+savepath);
	}
	
	
	
	
	
	public LittleTools_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void tools() {
		this.login();
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[text()='С����']");
		
		
//		webtest.click("xpath=//button[@id='show-settings-link']");
//		if(webtest.isElementPresent("xpath=//a[@id='access-on']")) {
//			webtest.click("xpath=//a[@id='access-on']");
//		}
	}
	
	
}
