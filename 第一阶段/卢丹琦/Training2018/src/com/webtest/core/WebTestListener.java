package com.webtest.core;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.Log;

/**
 * ������������ʧ�ܣ�����
 */


public class WebTestListener extends TestListenerAdapter{
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
//		  
//		  Log.info(tr.getInstance()+"-"+tr.getName()+"���гɹ��������ʼ�");
//		  BaseTest tb = (BaseTest) tr.getInstance();
////        WebDriver driver = tb.getDriver();    
//		  MailPoster ss = new MailPoster();
//		  ss.sendmail();	  
//	  }
	  
	  @Override
		public void onFinish(ITestContext tr) {
			super.onFinish(tr);
			Log.info(tr.getName()+"�����ʼ�");  
	        FolderPackage pa = new FolderPackage();
	        pa.fileToZip();
	        MailPoster ss = new MailPoster();
			ss.sendmail();	 		
		}

}
