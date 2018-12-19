package scene;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

import net.sf.json.JSONObject;
/**
 * ����3�������µ�����(�ѵ�¼�����ջ���ַ)
 * @author yzhldq
 *
 */
public class Scene3 {

	@Test
	public void scene3() throws Exception {

		//��ѯ�ջ���ַ
		CookieStore cookie =  Common.getLoginCookie();		
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/fgadmin/address/list",cookie);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//����ջ���ַ
		cookie =  Common.getLoginCookie();	
		JSONObject address = new JSONObject();		
		address.element("id", "");
		address.element("receiverName", "Tom");
		address.element("cellPhone", "18032430000");
		address.element("province", "�ӱ�ʡ");
		address.element("city", "ʯ��ׯ��");
		address.element("area", "ԣ����");
		address.element("addressDetail", "�϶�����·");				
		result = HttpDriver.doPost(ReadPro.getProValue("url") + "/fgadmin/address/new",address,cookie);
		System.out.println(result);	
		AssertTest.assertMessageEquels(result,"message","success");
		
		//�����˷�
		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "�ӱ�ʡ_ʯ��ׯ��_ԣ����");
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//�ύ����
		cookie =  Common.getLoginCookie();		
		address = new JSONObject();		
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
		result = HttpDriver.doPost(ReadPro.getProValue("url") + "/common/fgadmin/submit",address,cookie);
		System.out.println(result);	
	}
}
