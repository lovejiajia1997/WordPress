package com.webtest.core;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.FileToZIP;
import com.webtest.utils.Log;

/**
 * author:lihuanzhen
 * ������������ʧ�ܣ�����
 * ����ִ�гɹ��������ʼ�
 */


public class WebTestListener  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  Log.error(tr.getInstance()+"-"+tr.getName()+"����ʧ�ܣ���Ҫ����");
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();		  
	  }
	  
//	  @Override
//	  public void onTestSuccess(ITestResult tr) {
//		  Log.info(tr.getInstance()+"-"+tr.getName()+"���гɹ�����Ҫ���͵����ʼ�");
//		  BaseTest wp = (BaseTest) tr.getInstance();
//          WebDriver driver = wp.getDriver(); 
//          FileToZIP ftz = new FileToZIP();
//          ftz.fileToZip();
//		  SeleniumSendMail sm = new SeleniumSendMail();
//		  sm.sendmail();
//		  
//	  }
	  
	
	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
		Log.info(testContext.getName());
        FileToZIP ftz = new FileToZIP();
        ftz.fileToZip();
		SeleniumSendMail sm = new SeleniumSendMail();
		sm.sendmail();
	}
}
