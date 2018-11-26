package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class NSDataProvider {

	
	@DataProvider(name="txt")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser("user.txt");
	}
	
	@DataProvider(name="admin")
	public  Object[][] getAdminData() throws IOException{
		return new  TxtDataProvider().getTxtUser("admin.txt");
	}
	
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  TxtDataProvider().getTxtUser("movie.txt");
	}

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("user.xlsx","Sheet1");
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `mm_movie` ");
	}
	
}
