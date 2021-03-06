package project.wordpress;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;


/** 
* author:shenmengqi 
* @version 创建时间：2018年12月3日 下午3:26:56 
* 外观模块下，添加主题的测试用例 
*/

public class Theme_Test extends BaseTest{
	
	String changethemename = "Twenty Sixteen";
	String addthemename = "Relativity";

	
	@Test(description="启用已安装的主题",priority=0)
	public void changeTheme() throws InterruptedException {
		waiguan.changeTheme(changethemename);
		assertTrue(webtest.ifContains("新主题已激活"));
	}
	
	@Test(description="将主题恢复至默认主题",priority=1)

	public void theme() throws InterruptedException {
		waiguan.changeTheme("Twenty Seventeen");
		assertTrue(webtest.ifContains("新主题已激活"));
	}

	
	@Test(description="搜索添加主题",priority=2)
	public void addThemeBySearch() throws InterruptedException {
		waiguan.addThemeBySearch(addthemename);
		assertFalse(webtest.ifContains("正在安装"));
	}
	
	
	@Test(description="删除已安装主题",priority=3)
	public void delTheme() throws InterruptedException {
		waiguan.delTheme(addthemename);
		assertFalse(webtest.ifContains(addthemename));
	}
	
	
	Theme_Action waiguan;
	
	@BeforeMethod
	public void setup() {
		waiguan = new Theme_Action(webtest);
	}
	
}
