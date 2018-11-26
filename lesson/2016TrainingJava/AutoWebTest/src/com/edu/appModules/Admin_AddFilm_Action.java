package com.edu.appModules;

import org.openqa.selenium.WebDriver;

import com.edu.pageObjects.Admin_AddFilmPage;


public class Admin_AddFilm_Action {
	public static void execute_addmessage(WebDriver wd,String film_name,String film_petname,
			String film_director,String film_editor,String film_nation,String film_language,
			String film_showtime,String film_minutes,String film_picname) throws Exception {
		//wd.get("http://localhost:8032/MyMovie/admin.php/Index/index.html");
		Admin_AddFilmPage add_flPage = new Admin_AddFilmPage(wd);
		add_flPage.getfilm_man().click();
		add_flPage.getfilm_mes().click();
		Thread.sleep(1000);
		add_flPage.getf_name().sendKeys(film_name);
		add_flPage.getf_pname().sendKeys(film_petname);
		add_flPage.getf_director().sendKeys(film_director);
		add_flPage.getf_edi().sendKeys(film_editor);
		add_flPage.getf_nation().sendKeys(film_nation);
		add_flPage.getf_lan().sendKeys(film_language);
		add_flPage.getf_showtime().sendKeys(film_showtime);
		add_flPage.getf_min().sendKeys(film_minutes);
		add_flPage.getf_pic().sendKeys(film_picname);
	}
	
	public static void execute_addcon(WebDriver wd) throws Exception {
		Admin_AddFilmPage add_con = new Admin_AddFilmPage(wd);
		
		wd.switchTo().frame(add_con.getframe());
		Thread.sleep(500);
		add_con.getf_con().click();
		add_con.getf_con().sendKeys("����Ĺ�ʼǡ���һ���������������������ϵ�С˵��"
				+ "�����й����ꡢʱ�����ա��Ϻ��Ļ���2007��-2011��½�����淢�У������������塣 [1] "
				+ " ����Ĺ�ʼǰƣ����֣��ϡ��£�����2011��12��19�����У����ˡ���Ĺ�ʼǡ�ϵ����ᣬ������ʵ����ű���"
				+ "����Ĺ�ʼǡ�ϵ������������Ĵ��������俰�ƽ������й������ľ���֮������ð�����߿���׷����"
				+ "��������Ҳƾ�����������£������й������������������С�");
		wd.switchTo().defaultContent();
		
	}
	
	public static void execute_submit(WebDriver wd) throws Exception {
		Admin_AddFilmPage sub = new Admin_AddFilmPage(wd);
		sub.getsubmit().click();
	}
}
