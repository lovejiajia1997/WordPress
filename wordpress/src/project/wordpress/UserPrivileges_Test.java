package project.wordpress;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

/*
 * �û�Ȩ����֤��
 * author:shisujia
 */
public class UserPrivileges_Test extends BaseTest {
		
	@Test(description="��֤��ɫΪͶ���ߵ��û��Ƿ�����û�������Ȩ��")
	public void contributor(){
		//��¼���û�12�Ľ�ɫΪͶ����
		Login_Action action;
		action=new Login_Action(webtest);
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		try {
			action.loginNew("12", "12");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(ifContains("�û�"));
		System.out.println("��ɫΪͶ���ߵ��û��������û�Ȩ��");
		Assert.assertTrue(ifContains("����"));
		System.out.println("��ɫΪͶ���ߵ��û���������Ȩ��");		
	}
}
