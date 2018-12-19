package scene;

import java.io.IOException;

import org.apache.http.client.CookieStore;

import com.edu.demo1029.HttpDriver;
import com.edu.demo1029.ReadPro;

import net.sf.json.JSONObject;

public class Common {
	public static CookieStore getLoginCookie() throws IOException, Exception {
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", "20000000004");
		user.element("password", "netease123");

		CookieStore cookie = HttpDriver.doPostgetCookie(ReadPro.getProValue("url") + "/common/fgadmin/login", user);
		return cookie;
	}
	
	public static CookieStore getLoginCookie(String phoneNumber,String password) throws IOException, Exception {
		JSONObject user = new JSONObject();
		user.element("phoneArea", "86");
		user.element("phoneNumber", phoneNumber);
		user.element("password", password);

		CookieStore cookie = HttpDriver.doPostgetCookie(ReadPro.getProValue("url") + "/common/fgadmin/login", user);
		return cookie;
	}

}
