package com.edu.test;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

/**
 * 
 * @author yzhldq
 *
 */
public class Submit_Test {

	String url = "/common/fgadmin/submit";
	String username = "20000000004";
	String password = "netease123";
	
	@Test(description = "�ύ�����ɹ�")	
	public void success1() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
		
		String result = HttpDriver.doPost(url,address,cookie);
//		AssertTest.assertMessageEquels(result,"message","success");
	}
	
	@Test(description = "�ύ�����ɹ���������Ʊ")	
	public void success2() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "���׺����о�Ժ");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�δ������Ʒ")	
	public void commodityNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "");
		address.element("skuNumbers", "");
		address.element("stockIds", "");
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�δѡ���ջ���ַ")	
	public void addressNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�����Ʊ��û��д��Ʊ̧ͷ")	
	public void billNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�ȱ�ٻ�����")	
	public void goodsIDNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�ȱ��Ҫ����Ļ������")	
	public void skuNumbersNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("stockIds", "74966312,74966313");
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�ȱ�ٿ������ID")	
	public void stockIdNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�Ҫ����Ļ���������Ͳ���ȷ")	
	public void skuNumbersError1() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("stockIds", "74966312,74966313");
		address.element("skuNumbers", "11");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ�Ҫ����Ļ���������Ͳ���ȷ")	
	public void skuNumbersError2() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("stockIds", "74966312,74966313");
		address.element("skuNumbers", 11);
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ����������Ͳ���ȷ")	
	public void skuIdsError() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", 2);
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ��������ID���Ͳ���ȷ")	
	public void stockIdsError() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", 74966312);
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ������Ų�����")	
	public void skuIdsNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "222222,333333");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
	
	@Test(description = "�ύ����ʧ�ܣ��������ID������")	
	public void stockIdsNull() throws IOException, Exception{
		CookieStore cookie =  Common.getLoginCookie(username,password);
		
		JSONObject address = new JSONObject();	
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "11111111,11111111");
		address.element("receiverName", "����");
		address.element("cellPhone", "12615813537");
		address.element("addressDetail", "1 �� 3 ��Ԫ");
		address.element("province", "�㽭ʡ");
		address.element("city", "������");
		address.element("area", "������");
		address.element("voiceStatus", 0);
		address.element("needInvoice", 0);
		address.element("invoiceHead", "");	
		address.element("transportFee", 0);
		address.element("logisticsCompanyId", 1);
		address.element("accessSource", "noSource");
		address.element("accessDevice", 0);
				
		String result = HttpDriver.doPost(url,address,cookie);
	}
}
