package com.edu.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

/**
 * ����1�������Ʒ�б��鿴��Ʒ����
 * @author yzhldq
 *
 */
public class Scene1_Test {

	@Test
	public void scene1() throws IOException, Exception {
		
		String url = "/common/skuList";
		//��ȡ������Ʒ��sku�б�ɹ�
		String result = HttpDriver.doGet(url);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ȡgoodsId=1����Ʒsku��Ϣ�ɹ�
		result = HttpDriver.doGet(url,"goodsId=1");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ȡgoodsId=2����Ʒsku��Ϣ�ɹ�
		result = HttpDriver.doGet(url,"goodsId=2");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ȡgoodsId=3����Ʒsku��Ϣ�ɹ�
		result = HttpDriver.doGet(url,"goodsId=3");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
	}
}
