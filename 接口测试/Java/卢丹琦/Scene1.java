package scene;

import java.io.IOException;

import org.testng.annotations.Test;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

import net.sf.json.JSONObject;
import qingguo1030.AssertTest;

/**
 * ����1�������Ʒ�б��鿴��Ʒ����
 * @author yzhldq
 *
 */
public class Scene1 {

	@Test
	public void scene1() throws IOException, Exception {
		//��ȡ������Ʒ��sku�б�ɹ�
		String result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ȡgoodsId=1����Ʒsku��Ϣ�ɹ�
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList","goodsId=1");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ȡgoodsId=2����Ʒsku��Ϣ�ɹ�
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList","goodsId=2");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
		
		//��ȡgoodsId=3����Ʒsku��Ϣ�ɹ�
		result = HttpDriver.doGet(ReadPro.getProValue("url")+"/common/skuList","goodsId=3");
		System.out.println(result);
		AssertTest.assertMessageEquels(result,"message","success");
	}
}
