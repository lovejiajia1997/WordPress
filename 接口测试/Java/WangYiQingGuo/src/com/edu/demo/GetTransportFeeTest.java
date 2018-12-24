package com.edu.demo;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import com.edu.core.HttpDriver;

/**
 *  
 * @author Shi Sujia
 * 
 **/

public class GetTransportFeeTest {
	String url = "/common/getTransportFee";
	
	@Test(description="")
	public void getFee() throws Exception {
		Map<String,Object> address = new HashMap();
		address.put("id", "1");
		address.put("addressDetail", "�ӱ�ʡ_�żҿ���_������");	
		String result = HttpDriver.doGet(url,address);
		System.out.println(result);
	}
}
