package com.edu.test;

import static org.testng.Assert.assertEquals;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import com.edu.test.Common;

import net.sf.json.JSONObject;

/**
 *  
 * @author Shisujia
 * 
 **/

public class AddAddress_Test {
	String url = "/fgadmin/address/new";
	String result;
	public void assertion(int code,String message) {
		JSONObject json = JSONObject.fromObject(result);	
		assertEquals(json.getString("message"),message);
		assertEquals(json.getInt("code"),code);
	}
	
	@Test(description="��ӵ�ַ�ɹ�")
	public void addAddressSuccess() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
		this.assertion(200, "success");
	}	
	
	@Test(description="��ӵ�ַʧ�ܣ�id�����ǿ�")
	public void addAddressFail10() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","123");
		address.element("receiverName","jiajia");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail", "");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
		this.assertion(400, "must be null");		
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�δ��¼")
	public void addAddressFail11() throws Exception {
		JSONObject address = new JSONObject();
		address.element("id","123");
		address.element("receiverName","jiajia");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail", "");	
		result = HttpDriver.doPost(url, address);
		System.out.println(result);
		this.assertion(403, "�����µ�¼");
		
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�receiveName�������Ͳ���ȷ")
	public void addAddressFail0() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		double receiveName=2.355555;
		address.element("receiverName",receiveName);
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail", "");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
		
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�receiveName�������Ͳ���ȷ")
	public void addAddressFail1() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","1");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�cellphone�������Ͳ���ȷ")
	public void addAddressFail2() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","123");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�province�������Ͳ���ȷ")
	public void addAddressFail3() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","123");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�city�������Ͳ���ȷ")
	public void addAddressFail4() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","123");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");		
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�area�������Ͳ���ȷ")
	public void addAddressFail5() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","123");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�ȱ��receiverName����")
	public void addAddressFail6() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�ȱ��cellPhone����")
	public void addAddressFail7() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","");
		address.element("province","�㽭ʡ");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�ȱ��province����")
	public void addAddressFail8() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","");
		address.element("city","������");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}
	
	@Test(description="��ӵ�ַʧ�ܣ�province��city��ƥ��")
	public void addAddressFail9() throws Exception {
		CookieStore cookie = Common.getLoginCookie("200000000077","netease123");
		JSONObject address = new JSONObject();
		address.element("id","");
		address.element("receiverName","sujia");
		address.element("cellPhone","12345678910");
		address.element("province","�㽭ʡ");
		address.element("city","ʯ��ׯ��");
		address.element("area","������");
		address.element("addressDetail","�㽭��ѧ");	
		result = HttpDriver.doPost(url, address, cookie);
		System.out.println(result);
	}

}
