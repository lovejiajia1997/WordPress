package com.webtest.core;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.webtest.utils.Log;

/**
 * 监听器，用例失败，截屏
 */


public class WebTestListener extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  
		  Log.error(tr.getInstance()+"-"+tr.getName()+"运行失败，需要截屏");
		  BaseTest tb = (BaseTest) tr.getInstance();
          WebDriver driver = tb.getDriver();    
		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
		  ss.screenShot();
		  
	  }
	  
//	  @Override
//	  public void onTestSuccess(ITestResult tr) {
//		  
//		  Log.info(tr.getInstance()+"-"+tr.getName()+"运行成功，发送邮件");
//		  BaseTest tb = (BaseTest) tr.getInstance();
////        WebDriver driver = tb.getDriver();    
//		  MailPoster ss = new MailPoster();
//		  ss.sendmail();	  
//	  }
	  
	  @Override
		public void onFinish(ITestContext tr) {
			super.onFinish(tr);
			Log.info(tr.getName()+"发送邮件");  
	        FolderPackage pa = new FolderPackage();
	        pa.fileToZip();
	        MailPoster ss = new MailPoster();
			ss.sendmail();	 		
		}

}
