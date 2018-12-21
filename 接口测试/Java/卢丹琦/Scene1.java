package scene;

import java.io.IOException;

import org.testng.annotations.Test;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

import net.sf.json.JSONObject;
import qingguo1030.AssertTest;

/**
 * 场景1：浏览商品列表并查看商品详情
 * @author yzhldq
 *
 */
public class Scene1 {

	@Test
	public void scene1() throws IOException, Exception {
		//获取所有商品的sku列表成功
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//获取goodsId=1的商品sku信息成功
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList","goodsId=1");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//获取goodsId=2的商品sku信息成功
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList","goodsId=2");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//获取goodsId=3的商品sku信息成功
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList","goodsId=3");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
	}
}
