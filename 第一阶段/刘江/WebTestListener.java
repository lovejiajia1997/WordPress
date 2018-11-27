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
 * ¼àÌýÆ÷£¬ÓÃÀýÊ§°Ü£¬½ØÆÁ
 */


public class WebTestListener  extends TestListenerAdapter{
	  FreemarkerTemplateEngine ft= new  FreemarkerTemplateEngine();
	  Sendmail mail = new Sendmail();	  
	  @Override
	  public void onFinish(ITestContext testContext) {
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
			try {
				String txt = ft.run(Result);
				System.out.println(txt);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
}



