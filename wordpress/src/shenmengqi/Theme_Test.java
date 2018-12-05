package com.wordpress.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Theme_Action;
import com.wordpress.core.BaseTest;
import com.wordpress.core.Checker;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:26:56 
* ���ģ���£��������Ĳ������� 
*/

public class Theme_Test extends BaseTest{
	
	String changethemename = "Twenty Fifteen";
	String addthemename = "Twenty Thirteen";

	
	@Test(description="�����Ѱ�װ������")
	public void changeTheme() {
		waiguan.changeTheme("changethemename");
		checker.isPresent("�������Ѽ���");
	}
	
	
	@Test(description="�������")
	public void addThemeByLink() {
		waiguan.addThemeByLink(addthemename);
		checker.isNotPresent("���ڰ�װ");
		
	}
	
	
	@Test(description="�����������",priority=1)
	public void addThemeBySearch() {
		waiguan.addThemeBySearch(addthemename);
		checker.isNotPresent("���ڰ�װ");
	}
	
	
	@Test(description="ɾ���Ѱ�װ����",priority=2)
	public void delTheme() {
		waiguan.delTheme(addthemename);
		checker.isNotPresent(addthemename);
	}
	
	
	
	Theme_Action waiguan;
	Checker checker;
	
	@BeforeMethod
	public void setup() {
		waiguan = new Theme_Action(webtest);
	}
	
}
