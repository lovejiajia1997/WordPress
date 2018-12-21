package training;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

/**
 * 
 * @author yzhldq
 *
 */
public class Get_Transport_Fee_Test {

	@Test(description = "��ȡ�˷ѳɹ�")
	public void success1() throws Exception {

		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "�㽭ʡ_������_������");
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
	}
	
	@Test(description = "��ȡ�˷ѳɹ�")
	public void success2() throws Exception {

		Map map = new HashMap();
		map.put("id", 2);
		map.put("addressDetail", "�㽭ʡ_������_������");
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
	}
	
	@Test(description = "��¼ʧ�ܣ�id�������Ͳ���ȷ")
	public void idError() throws Exception {

		Map map = new HashMap();
		map.put("id", 1.25);
		map.put("addressDetail", "�㽭ʡ_������_������");
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","����ʧ��");
		
	}
	
	@Test(description = "��¼ʧ�ܣ�addressDetail�������Ͳ���ȷ")
	public void addressDetailError() throws Exception {

		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "123");
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","����ʧ��");
		
	}
	
	@Test(description = "��¼ʧ�ܣ�ȱ��id����")
	public void lackID() throws Exception {

		Map map = new HashMap();
		map.put("addressDetail", "�㽭ʡ_������_������");
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","����ʧ��");
		
	}
	
	@Test(description = "��¼ʧ�ܣ�ȱ��addressDetail����")
	public void lackAddressDetail() throws Exception {

		Map map = new HashMap();
		map.put("id", 1);
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","����ʧ��");
		
	}
}
