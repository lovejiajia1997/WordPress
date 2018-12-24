package com.webtest.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.webtest.utils.Log;

import freemarker.template.TemplateException;

/**
 * author:lihuanzhen
 * ������������ʧ�ܣ�����
 */


public class WebTestListener  extends TestListenerAdapter{
//	  @Override
//	  public void onTestFailure(ITestResult tr) {
//		  
//		  Log.error(tr.getInstance()+"-"+tr.getName()+"����ʧ�ܣ���Ҫ����");
//		  BaseTest tb = (BaseTest) tr.getInstance();
//          WebDriver driver = tb.getDriver();    
//		  SeleniumScreenShot ss = new SeleniumScreenShot(driver);
//		  ss.screenShot();  
//	  }
	
	  //�ڼ������аѲ��Խ������map�Ž�freemarker��ִ������String����Ϊ�ʼ�������
	  FreemarkerTemplateEngine ft= new  FreemarkerTemplateEngine();
	  Javamail mail = new Javamail();	  
//	  public WebTestListener() {
//		  super();
//		  }	  
//	  private String writeResultToMailTemplate() {		
//	  ITestNGMethod method[]=this.getAllTestMethods();
//	  List failedList=this.getFailedTests();
//	  List passedList=this.getPassedTests();
//	  return null;
//	  }
	  @Override
	  public void onFinish(ITestContext testContext) {
//		  List<ITestResult> failedList1=this.getFailedTests();
//		  List<ITestResult> passedList1=this.getPassedTests(); 
//		  List failedList2 = new ArrayList();
//		  List passedList2 = new ArrayList();
//		  //�õ�ʧ�ܵĲ���������
//		  for(int i=0;i<failedList1.size();i++) {
//			  System.out.println(failedList1.get(i).getInstanceName() + "." + failedList1.get(i).getName());
//
//				failedList2.add(failedList1.get(i).getInstanceName() + "." + failedList1.get(i).getName());
//		  }
//		  //�õ��ɹ��Ĳ���������
//		  for(int i=0;i<passedList1.size();i++) {
//			  passedList2.add(passedList1.get(i).getInstanceName() + "." + passedList1.get(i).getName());
//		  }
		  ITestNGMethod method[]=this.getAllTestMethods();
			List failedList=this.getFailedTests();
			List passedList=this.getPassedTests();
			List failedList1=new ArrayList();
			List passedList1=new ArrayList();
		  for(int j=0;j<failedList.size();j++)
			{
				ITestResult tr=(ITestResult) failedList.get(j);
				for(int i=0;i<method.length;i++)
				{
					if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
					{
						if(method[i].getDescription()!=null)
						{
							tr.setAttribute("name", method[i].getDescription());
						}
						else
						{
							tr.setAttribute("name", "");
						}
						break;
					}
				}
				failedList1.add(tr);
			}
		  for(int j=0;j<passedList.size();j++)
			{
				ITestResult tr=(ITestResult) passedList.get(j);
				for(int i=0;i<method.length;i++)
				{
					if(tr.getMethod().getMethodName().equals(method[i].getMethodName()))
					{
						if(method[i].getDescription()!=null)
						{
							tr.setAttribute("name", method[i].getDescription());
						}
						else
						{
							tr.setAttribute("name", "");
						}
						break;
					}
				}
				passedList1.add(tr);
			}
		    Map Result = new HashMap();
		    Result.put("date", new Date());
		    Result.put("failedList",failedList);   
		    Result.put("passedList",passedList1); 
		    Result.put("casesize",passedList.size()+failedList.size()); 
		    Result.put("failcasesize",failedList.size());

			// ����FreemakerTemplateEngine run���� ��result ת��ΪString ��Ϊ�ʼ�������
			try {
				String txt = ft.run(Result);
				System.out.println(txt);
//				mail.send(txt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
}



