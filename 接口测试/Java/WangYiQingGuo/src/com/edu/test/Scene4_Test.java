package com.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

/**
 * ����4�������µ�����(�ѵ�¼�����ջ���ַ)
 * @author yzhldq
 *
 */
public class Scene4_Test {

	@Test
	public void Scene4() throws Exception {

		String addressList_url = "/fgadmin/address/list";
		String getTransportFee_url = "/common/getTransportFee";
		String submit_url = "/common/fgadmin/submit";
		
		//��ѯ�ջ���ַ
		CookieStore cookie =  Common.getLoginCookie("20000000004","netease123");		
		String result = HttpDriver.doGet(addressList_url,cookie);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//�����˷�
		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "�ӱ�ʡ_ʯ��ׯ��_ԣ����");
		result = HttpDriver.doGet(getTransportFee_url,map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//�ύ����
		cookie =  Common.getLoginCookie("20000000004","netease123");	
		JSONObject address = new JSONObject();		
		address.element("id", "");
		address.element("receiverName", "Tom");
		address.element("cellPhone", "18032430000");
		address.element("province", "�ӱ�ʡ");
		address.element("city", "ʯ��ׯ��");
		address.element("area", "ԣ����");
		address.element("addressDetail", "�϶�����·");
		address.element("transportFee", 0);
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");			
		result = HttpDriver.doPost(submit_url,address,cookie);
		System.out.println(result);	
	}
}
