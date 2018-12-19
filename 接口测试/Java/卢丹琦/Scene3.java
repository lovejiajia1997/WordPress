package scene;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

import net.sf.json.JSONObject;
/**
 * 场景3：完整下单流程(已登录、无收货地址)
 * @author yzhldq
 *
 */
public class Scene3 {

	@Test
	public void scene3() throws Exception {

		//查询收货地址
		CookieStore cookie =  Common.getLoginCookie();		
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/fgadmin/address/list",cookie);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//添加收货地址
		cookie =  Common.getLoginCookie();	
		JSONObject address = new JSONObject();		
		address.element("id", "");
		address.element("receiverName", "Tom");
		address.element("cellPhone", "18032430000");
		address.element("province", "河北省");
		address.element("city", "石家庄市");
		address.element("area", "裕华区");
		address.element("addressDetail", "南二环东路");				
		result = HttpDriver.doPost(ReadPro.getProValue("url") + "/fgadmin/address/new",address,cookie);
		System.out.println(result);	
		AssertTest.assertMessageEquels(result,"message","success");
		
		//计算运费
		Map map = new HashMap();
		map.put("id", 1);
		map.put("addressDetail", "河北省_石家庄市_裕华区");
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/getTransportFee",map);
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//提交订单
		cookie =  Common.getLoginCookie();		
		address = new JSONObject();		
		address.element("id", "");
		address.element("receiverName", "Tom");
		address.element("cellPhone", "18032430000");
		address.element("province", "河北省");
		address.element("city", "石家庄市");
		address.element("area", "裕华区");
		address.element("addressDetail", "南二环东路");
		address.element("transportFee", 0);
		address.element("skuIds", "2,3");
		address.element("skuNumbers", "1,1");
		address.element("stockIds", "74966312,74966313");				
		result = HttpDriver.doPost(ReadPro.getProValue("url") + "/common/fgadmin/submit",address,cookie);
		System.out.println(result);	
	}
}
