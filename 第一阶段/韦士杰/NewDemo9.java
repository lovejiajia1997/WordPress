package NewPackage;

import java.net.CookieStore;
import java.net.URLEncoder;

import javax.swing.RowFilter.Entry;
import javax.tools.JavaFileObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

public class NewDemo9 {
	static CloseableHttpClient httpClient = null;
	static CloseableHttpResponse respone = null;

	public static String doGet(String url) throws Exception {
		httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}
	
	public static String doGet(String url,JavaFileObject data) throws Exception {
		String para=URLEncoder.encode(data.toString(), "UTF-8");
		httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url+"?"+para);
		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}
	
	public static String doGet(String url,String para) throws Exception {
		httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url+"?"+para);
		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}
	
	public static String doGet(String url,Map para) throws Exception {
		//把map类型转换为String,并用&加以拼接
		StringBuilder sBuilder =new StringBuilder();
		int size =para.size();
		for(Entry< String, String> entry :((Object) para).EntrySet()) {
			sBuilder.append(((Object) entry).getKey()+"="+entry.getValueCount());
			size--;
			if(size>=1) {
				sBuilder.append("&");
			}
			
		}
		httpClient = HttpClients.createDefault();
		
		HttpGet get = new HttpGet(url+"?"+sBuilder.toString());
		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}


//
//	public static String doGet(String url,JOSNObject para) {
//		把JOSNObject转换为String类型
//	}

	public static String doPost(String url, JavaFileObject para) throws Exception {
		httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity(para.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	
	}
	public static String doPost(String url, JavaFileObject para,CookieStore cookie) throws Exception {
		RequestConfig gConfig = RequestConfig.custom().
				setCookieSpec(CookieSpecs.STANDARD).build();
			httpClient =HttpClients.custom().
				setDefaultRequestConfig(gConfig).
				setDefaultCookieStore((org.apache.http.client.CookieStore) cookie).build();
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity(para.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	
	}
	
	public static CookieStore doPostgetCookie(String url, JavaFileObject para) throws Exception {
	
		RequestConfig gConfig = RequestConfig.custom().
				setCookieSpec(CookieSpecs.STANDARD).build();
		CookieStore cookie =(CookieStore) new BasicCookieStore();
		httpClient =HttpClients.custom().
				setDefaultRequestConfig(gConfig).
				setDefaultCookieStore((org.apache.http.client.CookieStore) cookie).build();
		
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity(para.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		
		HttpEntity entity = respone.getEntity();
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return cookie;
	
	}
}
