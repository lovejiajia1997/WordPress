package com.edu.demo;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

/**
*  
* @author Shi Sujia
* 
**/

public class SkuListTest {
	String url = "/common/skuList";
	String result = null;
	public String getMessage(String result) {
		JSONObject json =JSONObject.fromObject(result);
		return json.getString("message");
	}
	
	public void skulist(){
		try {
			result = HttpDriver.doGet(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		assertEquals(this.getMessage(result),"success");
	}
	
	public void skulist(String addUrl) {
		try {
			result = HttpDriver.doGet(url,addUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		assertEquals(this.getMessage(result),"success");
	}
	
	@Test(description="��ȡ������Ʒ��sku��Ϣ")
	public void skulist1(){
		this.skulist();
	}
	
	
	@Test(description="��ȡid������Χ����Ʒ��sku��Ϣ")
	public void skulist2() {
		this.skulist("goodsId=2147483648");
	}
	
	@Test(description="��ȡid�����ڵ���Ʒ��sku��Ϣ")
	public void skulist3() {
		this.skulist("goodsId=9999");
	}
	
//	@Test(description="��ȡid���ʹ������Ʒ��sku��Ϣ")
//	public void skulist4() {
//		this.skulist("goodsId=\"1\"");
//	}
	
	@Test(description="��ȡidΪ1����Ʒ��sku��Ϣ")
	public void skulist5(){
		this.skulist("goodsId=1");
	}
	
}
