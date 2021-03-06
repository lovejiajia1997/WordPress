package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class NSDataProvider {

	@DataProvider(name = "WP_user")
	public Object[][] getTxtData() throws IOException {
		return new TxtDataProvider().getTxtUser("data/WP_user.txt");
	}

	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data/sheet1.xlsx", "Sheet1");
	}

	@DataProvider(name = "mysql")
	public Object[][] getMysqlDada() throws IOException {
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + "FROM `mm_movie` ");
	}

//	@DataProvider(name = "Emailusertxt")
//	public Object[][] getEmailuser() throws IOException {
//		return new TxtDataProvider().getTxtUser("data/Emailuser.txt");
//	}

}
