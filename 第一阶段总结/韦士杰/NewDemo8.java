package NewPackage;

import javax.tools.JavaFileObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import netscape.javascript.JSObject;

public class NewDemo8 {
	CloseableHttpClient httpClient =null;
	@BeforeClass
	public void startUp() {
		httpClient= HttpClients.createDefault();
	}
	@AfterClass
	public void tearDown() throws Exception {
		httpClient.close();
	}
	
	public void doGet(String url) {
		
	}
	public void doPost(String url,JavaFileObject para) {
		
	}
	@Test(timeout=0)
	public void loginSuccess() throws Exception {
		JSObject success_user = new JSObject(null);
	
		String url="http://study-perf.qa.netease.com/common/fgadmin/login";
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity(success_user.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println("login"+content);
		EntityUtils.consume(entity);
		respone.close();
	
	}
	public String address;
	public float fee;

	@Test(timeout=1)
	public void submit() throws Exception {
		
		String url="http://study-perf.qa.netease.com/fgadmin/orders/submit";
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity("{\"skuIds\":\"2,3\",\"skuNumbers\":\"1,1\",\"stockIds\":\"74966312,74966313\",\"receiverName\":\"晓晓\",\"cellPhone\":\"15215235548\"\r\n" + 
				",\"addressDetail\":\"河北师大新校区\",\"province\":\"河北省\",\"city\":\"石家庄市\",\"area\":\"裕华区\",\"voiceStatus\":0,\"needInvoice\"\r\n" + 
				":0,\"invoiceHead\":\"\",\"transportFee\":0,\"logisticsCompanyId\":1,\"accessSource\":\"noSource\",\"accessDevice\"\r\n" + 
				":0}");
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println("submit"+content);
		EntityUtils.consume(entity);
		respone.close();
	
	}
}
