package com.wordpress.appModules;

import com.webtest.utils.Log;
import com.wordpress.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:21:21 
* wordpress��Ŀ
* ���ģ���£��������Ĳ����� 
*/

public class Theme_Action {

	private WebDriverEngine webtest;
	
	
	//�����Ѱ�װ����
	public void changeTheme(String name) {
		this.theme();
		
		if(webtest.isElementPresent("xpath=//h2[@id='"+name+"-name']")) {
			webtest.click("xpath=//h2[@id='"+name+"-name']");
			if(webtest.isElementPresent("xpath=//a[@aria-label='����"+name+"']")) {
				webtest.click("xpath=//a[@aria-label='����"+name+"']");
				int i = 0;
				while(i<5 && !webtest.isTextPresent("�Ѽ���")) {
					webtest.pause(1000);
					i++;
				}
			}else {
				Log.error("��������Ӧ��");
			}
		}else {
			
			Log.error(name+"����Ԫ�ز�����");
		}
	}
	
	
	//�������
	//�������Ⲣ��װ
	public void addThemeBySearch(String name) {
		String installpath = "xpath=//a[@data-slug='"+name+"']";//��װ��ťԪ��λ��
		String usepath = "xapth=//a[@aria-label='����"+name+"']";//���ð�ťԪ��λ��
		
		this.theme();
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.typeAndClear("id=wp-filter-search-input",name);
		
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
//		�����ͣ
//		webtest.mouseoverElement("xpath=//h3[contains(.,'"+name+"')]");
		
		//�ж�����Ԫ���Ƿ����
		if (webtest.isElementPresent(installpath)) {
			int i  = 0;
			webtest.click(installpath);
			while(!webtest.isElementPresent(usepath) && i<20) {
				webtest.pause(1000);
				i++;
			}
		}//�ж������Ƿ��Ѱ�װ
		else if(webtest.isElementPresent(usepath)) {
			Log.info("�����Ѱ�װ");
		}
		else {
			Log.error("����Ԫ��δ�ҵ�");
		}
		
		
	}
	//ͨ�����Ӱ�װ����
	public void addThemeByLink(String name) {
		String installpath = "xpath=//a[@data-slug='"+name+"']";//��װ��ťԪ��λ��
		String usepath = "xapth=//a[@aria-label='����"+name+"']";//���ð�ťԪ��λ��
		
		this.theme();
		
		webtest.click("xpath=//a[contains(.,'���������')]");
		webtest.click(installpath);
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		if (webtest.isElementPresent(installpath)) {
			int i  = 0;
			webtest.click(installpath);
			while(!webtest.isElementPresent(usepath) && i<4) {
				webtest.pause(5000);
				i++;
			}
		}
		else if(webtest.isElementPresent(usepath)) {
			Log.info("�����Ѱ�װ");
		}
		else {
			Log.error("����Ԫ��δ�ҵ�");
		}
	}
	//ͨ����ť��װ����
	public void addThemeByButton(String name) {
		
		String installpath = "xpath=//a[@data-slug='"+name+"']";//��װ��ťԪ��λ��
		String usepath = "xapth=//a[@aria-label='����"+name+"']";//���ð�ťԪ��λ��
		
		this.theme();
		
		webtest.click("xpath=//a[@class='hide-if-no-js page-title-action']");
		webtest.click(installpath);
		
		webtest.click("xpath=//h3[contains(.,'"+name+"')]");
		
		if (webtest.isElementPresent(installpath)) {
			int i  = 0;
			webtest.click(installpath);
			while(!webtest.isElementPresent(usepath) && i<20) {
				webtest.pause(1000);
				i++;
			}
		}
		else if(webtest.isElementPresent(usepath)) {
			Log.info("�����Ѱ�װ");
		}
		else {
			Log.error("����Ԫ��δ�ҵ�");
		}
	}

	
	//ɾ����ӵ�����
	public void delTheme(String name) {
		this.theme();
		String themediv = "xpath=//h2[@id='"+name+"-name']";
		
		if(webtest.isElementPresent(themediv)) {
			if(webtest.isElementPresent("xpath=//h2[contains(.,'��ǰ��"+name+"')]")) {//�ж������Ƿ�����ʹ��
				Log.error("Ҫɾ�������⣺"+name+"����ʹ��");
			}else {
				webtest.click(themediv);
				webtest.click("xpath=//a[contains(.,'ɾ��')]");
				webtest.alertAccept();
				webtest.pause(5000);
			}	
		}else {
			Log.error(name+"����δ��װ");
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
