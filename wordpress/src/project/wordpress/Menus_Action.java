package project.wordpress;

import com.webtest.core.WebDriverEngine;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����5:59:35 
* ��˵�� 
*/

public class Menus_Action {
	
	private WebDriverEngine webtest;
	
	
	public void addMenus(String name) {
		this.menus();
		
		webtest.click("xpath=//a[contains(.,'�����²˵�')]");
		webtest.typeAndClear("xpath=//input[@id='menu-name']", name);
		webtest.click("xpath=//input[@id='save_menu_header']");
	}
	
	public void editMenus(String name) {
		this.menus();
		webtest.selectByVisibleText("name=menu", name);
		webtest.click("xpath=//input[@value='ѡ��']");
		//�޸Ĳ˵��Ĳ���
		webtest.click("xpath=//input[@id='auto-add-pages']");
		
		webtest.click("xpath=//input[@id='save_menu_header']");
	}
	
	public void delMenus(String name) throws InterruptedException{
		this.menus();
		webtest.selectByVisibleText("name=menu", name);
		webtest.click("xpath=//input[@value='ѡ��']");
		webtest.click("xpath=//a[contains(.,'ɾ���˵�')]");
		try {
			webtest.alertAccept();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public Menus_Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	
	
	public void login() {
		webtest.open("http://localhost:8032/wordpress/wp-admin/nav-menus.php");
		webtest.typeAndClear("id=user_login", "admin");
		webtest.typeAndClear("id=user_pass", "admin");
		webtest.click("id=wp-submit");
	}
	
	public void menus() {
		this.login();
		webtest.click("xpath=//li[@id='menu-appearance']/a/div[@class='wp-menu-name']");
		webtest.click("xpath=//a[@href='nav-menus.php']");
		
	}
}