package com.wordpress.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.LittleTools_Action;
import com.wordpress.appModules.Theme_Action;
import com.wordpress.core.BaseTest;
import com.wordpress.core.Checker;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��5�� ����4:37:02 
* ���ģ���£�С���ߵ���ɾ�Ĳ��������
*/

public class LittleTools_Test extends BaseTest{
	LittleTools_Action tools;
	Checker checker;
	
	@BeforeMethod
	public void setup() {
		tools = new LittleTools_Action(webtest);
	}
	
	@Test(priority=0)
	public void addTools() {
		tools.addTools();
		checker.isPresent("�޸��ѱ���");
		
	}
	
	@Test (priority=1)
	public void editTools() {
		tools.editTools("www.123.com","8");
		checker.isPresent("�޸��ѱ���");
	}
	
	@Test(priority=2)
	public void delTools() {
		tools.delTools();
		checker.isPresent("�޸��ѱ���");
	}
}
