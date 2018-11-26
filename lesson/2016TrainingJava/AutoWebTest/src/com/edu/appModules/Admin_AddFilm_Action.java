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
		add_con.getf_con().sendKeys("《盗墓笔记》是一本最初连载在起点中文网上的小说，"
				+ "后由中国友谊、时代文艺、上海文化于2007年-2011年陆续出版发行，作者南派三叔。 [1] "
				+ " 《盗墓笔记捌：大结局（上、下）》于2011年12月19日上市，至此《盗墓笔记》系列完结，共出版实体书九本。"
				+ "《盗墓笔记》系列是南派三叔的代表作，其堪称近年来中国出版界的经典之作，获得百万读者狂热追捧。"
				+ "南派三叔也凭此作名满天下，跻身中国超级畅销书作家行列。");
		wd.switchTo().defaultContent();
		
	}
	
	public static void execute_submit(WebDriver wd) throws Exception {
		Admin_AddFilmPage sub = new Admin_AddFilmPage(wd);
		sub.getsubmit().click();
	}
}
