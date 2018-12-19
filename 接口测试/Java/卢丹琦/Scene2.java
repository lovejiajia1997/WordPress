package scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

import net.sf.json.JSONObject;
/**
 * ����2�������µ�����(δ��¼�����ջ���ַ)
 * @author yzhldq
 *
 */
public class Scene2 {

	@Test
	public void scene2() throws IOException, Exception {
		JSONObject user = new JSONObject();
		//��¼�ɹ�
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000004");
		user.element("password", "netease123");
		String result = HttpDriver.doPost(ReadPro.getProValue("url") + "/common/fgadmin/login", user);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ѯ�ջ���ַ
		CookieStore cookie =  Common.getLoginCookie("20000000004","netease123");		
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/fgadmin/address/list",cookie);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//�����˷�
		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "�㽭ʡ_������_������");
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//�ύ����
		JSONObject address = new JSONObject();		
		address.element("id", 1);
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
		result = HttpDriver.doPost(ReadPro.getProValue("url") + "/common/fgadmin/submit",address,cookie);
		System.out.println(result);	
//		AssertTest.assertMessageEquels(result,"message","success");
	}
}
