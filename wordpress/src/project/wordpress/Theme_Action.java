package project.wordpress;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.utils.Log;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:21:21 
* wordpress��Ŀ
* ���ģ���£��������Ĳ����� 
*/

public class Theme_Action extends BaseTest{

	private WebDriverEngine webtest;
	
	
	//�����Ѱ�װ����	
	public void changeTheme(String name) throws InterruptedException {
		this.theme();
		if(webtest.isElementPresent("xpath=//h2[contains(.,'"+name+"')]")) {
			
			webtest.mouseoverElement("xpath=//h2[contains(.,'"+name+"')]");
			webtest.JavaScriptClick("xpath=//a[contains(@aria-label,'����"+name+"')]");
		}else {

			if(webtest.isElementPresent("xpath=//h2[contains(.,'"+name+"')]")) {
				webtest.mouseoverElement("xpath=//h2[contains(.,'"+name+"')]");
				webtest.JavaScriptClick("xpath=//a[contains(@aria-label,'����"+name+"')]");
			}else {
				Log.info(name+"����Ӧ��");
			}
		}
	}
	
	//�������
	//�������Ⲣ���
	public void addThemeBySearch(String name) throws InterruptedException {
		{
			this.theme();
//		ͨ��������ӽ�����ӽ���
			webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
//		ͨ����ť������ӽ���
//		webtest.click("xpath=//a[contains(.,'���������')]");

		webtest.typeAndClear("id=wp-filter-search-input",name);
		try {
			webtest.wait(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webtest.mouseoverElement("xpath=//h3[contains(.,'"+name+"')]");
		if(webtest.isElementPresent("xpath=//a[@aria-label='��װ"+name+"']")) {
			webtest.JavaScriptClick("xpath=//a[@aria-label='��װ"+name+"']");
			webtest.typeAndClear("id=wp-filter-search-input",name);
			webtest.wait(5000);		
			webtest.mouseoverElement("xpath=//h3[contains(.,'"+name+"')]");
			if(webtest.isElementPresent("xpath=//a[@aria-label='��װ"+name+"']")) {
				webtest.JavaScriptClick("xpath=//a[@aria-label='��װ"+name+"']");				
				int i=0;
				while(i<2 && !webtest.ifContains("���ڰ�װ")) {
					webtest.pause(5000);
					i++;
				}
			}else {
				Log.error("Theme_Action-"+name+"�����Ѱ�װ");
			}
			}
		} 
	}
	
	//ɾ����ӵ�����
	public void delTheme(String name) throws InterruptedException {
		this.theme();
		String themediv = "xpath=//h2[contains(.,'"+name+"')]";
		
		webtest.click(themediv);
		if(webtest.isElementPresent("xpath=//a[contains(.,'ɾ��')]")) {
			webtest.click("xpath=//a[contains(.,'ɾ��')]");
			webtest.alertAccept();
			webtest.pause(5000);
		}else {
			Log.error("Theme_Action-"+name+"��������ʹ��");
		}
			
	}
	
	
	
	
	
	
	public Theme_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	public void login() {
		webtest.open("/wp-login.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "VJH$zxPNT3%enjVfHX");
		webtest.click("id=wp-submit");
	}
	
	public void theme() {
		this.login();
		webtest.click("xpath=//div[text()='���']");
		webtest.click("xpath=//a[@aria-current='page']");		
	}
	
}
