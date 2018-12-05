package com.wordpress.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.appModules.Theme_Action;
import com.wordpress.core.BaseTest;
import com.wordpress.core.Checker;

/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:26:56 
* 外观模块下，添加主题的测试用例 
*/

public class Theme_Test extends BaseTest{
	
	String changethemename = "Twenty Fifteen";
	String addthemename = "Twenty Thirteen";

	
	@Test(description="启用已安装的主题")
	public void changeTheme() {
		waiguan.changeTheme("changethemename");
		checker.isPresent("新主题已激活");
	}
	
	
	@Test(description="添加主题")
	public void addThemeByLink() {
		waiguan.addThemeByLink(addthemename);
		checker.isNotPresent("正在安装");
		
	}
	
	
	@Test(description="搜索添加主题",priority=1)
	public void addThemeBySearch() {
		waiguan.addThemeBySearch(addthemename);
		checker.isNotPresent("正在安装");
	}
	
	
	@Test(description="删除已安装主题",priority=2)
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
