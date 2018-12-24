package NewPackage;

import static org.junit.Assert.*;

import javax.tools.JavaFileObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import netscape.javascript.JSObject;

public class NewDemo7 {
	public String login(JavaFileObject user) throws Exception {
		System.setProperty("webdriver.gecko.driver", "F:\\NewStudy\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "F:\\study\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="http:\\www.baidu.com";
		driver.get(baseUrl);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url="http://study-perf.qa.netease.com/common/fgadmin/login";
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity(user.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println(content);
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();

		return baseUrl;
	
	}
	
	@Test(timeout=0)
	public void LoginBySuccess() throws Exception {

		JavaFileObject success_user = (JavaFileObject) new JSObject(null);

		String message=this.login(success_user);
		assertEquals(message, "success");
		
	}
	
	@Test(timeout=1)
	public void LoginByFail() throws Exception {
		JavaFileObject user = (JavaFileObject) new JSObject(null);
	
		String message=this.login(user);
		assertEquals(message, "ÓÃ»§Ãû»òÕßÃÜÂë´íÎó");
		}

}
