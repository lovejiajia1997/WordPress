package com.edu.testCases;

import org.testng.annotations.Test;

import com.edu.appModules.Admin_AddFilm_Action;
import com.edu.appModules.Admin_Login_Action;

public class Admin_Test extends BaseTest{
	@Test(priority = 0)
	public void login() throws Exception {
		Admin_Login_Action.execute(driver,"admin","admin");
	}
	
	@Test(priority = 1)
	public void message() throws Exception {
		Admin_AddFilm_Action.execute_addmessage(driver,"盗墓笔记","盗笔",
				"李仁港","南派三叔","中国大陆","国语，普通话",
				"2018-09-01","136","D:\\file\\图片\\william\\ELLEMEN.jpg");
		
	}
	
	@Test(priority = 2)
	public void con() throws Exception {
		Admin_AddFilm_Action.execute_addcon(driver);
		Admin_AddFilm_Action.execute_submit(driver);
	}
}
