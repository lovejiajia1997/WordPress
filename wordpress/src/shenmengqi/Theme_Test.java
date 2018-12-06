package shenmengqi;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/** 
* author:shenmengqi 
* @version ����ʱ�䣺2018��12��3�� ����3:26:56 
* ���ģ���£��������Ĳ������� 
*/

public class Theme_Test extends BaseTest{
	
	String changethemename = "Twenty Thirteen";
	String addthemename = "Twenty Thirteen";

	
	@Test(description="�����Ѱ�װ������",priority=0)
	public void changeTheme() {
		waiguan.changeTheme(changethemename);
	}
	
	
	@Test(description="�������",priority=1)
	public void addThemeByLink() {
		waiguan.addThemeByLink(addthemename);
		assertFalse(webtest.ifContains("���ڰ�װ"));
		
	}
	
	
	@Test(description="�����������",priority=2)
	public void addThemeBySearch() {
		waiguan.addThemeBySearch(addthemename);
		assertFalse(webtest.ifContains("���ڰ�װ"));
	}
	
	
	@Test(description="ɾ���Ѱ�װ����",priority=3)
	public void delTheme() {
		waiguan.delTheme(addthemename);
		assertFalse(webtest.ifContains(addthemename));
	}
	
	
	
	Theme_Action waiguan;
	
	@BeforeMethod
	public void setup() {
		waiguan = new Theme_Action(webtest);
	}
	
}
