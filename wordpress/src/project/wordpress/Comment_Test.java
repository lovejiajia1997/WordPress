package project.wordpress;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/**
 * @author ����Ө ����ģ�����
 */
public class Comment_Test extends BaseTest {
	Login_Action action;
	
	@BeforeClass
	public void login() throws Exception
	{
		action=new Login_Action(webtest);
		//��¼
		webtest.open("http://localhost:8032/wordpress/wp-login.php");
		action.login();
		Thread.sleep(1000);
	}

	// �������۹���
	@Test(priority = '1')
	public void Add_comment() throws Exception {
		webtest.open("http://localhost:8032/wordpress/");
		// ����DOWN��
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("link=���磬���ã�");
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}

		webtest.click("id=comment");
		Thread.sleep(2000);
		webtest.type("id=comment", "�Ȿ��ܺ�");
		// ����Ƴ�
		webtest.mouseoverElement("xpath=//h2[text()='����']");
		webtest.click("xpath=//h2[text()='����']");
		for (int i = 0; i < 5; i++) {
			webtest.KeyDown();
		}
		webtest.click("id=submit");
		assertTrue(webtest.ifContains("�Ȿ��ܺ�"));
	}

	// �ظ�����
	@Test(priority = '2')
	public void Reply() throws InterruptedException {

		webtest.open("http://localhost:8032/wordpress/"); // ����DOWN��
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("link=���磬���ã�");
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}

		webtest.click(
				"xpath=//a[@href='http://localhost:8032/wordpress/2018/11/27/%e6%b0%b4%e6%b5%92%e4%bc%a0%e8%af%bb%e5%90%8e%e6%84%9f/?replytocom=2#respond']");
		webtest.type("xpath=//textarea[@id='comment']", "����֮��"); // ����Ƴ�
		webtest.mouseoverElement("xpath=//h2[text()='����']");
		webtest.click("xpath=//h2[text()='����']");

		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();
		webtest.KeyDown();

		webtest.click("xpath=//input[@id='submit']");

	}

	// �ܷ���������
	@Test(priority = '3')
	public void Many() throws InterruptedException {

		// �������
		webtest.runJs("arguments[0]. click();", "xpath=//a[@href='edit-comments.php']");
		Thread.sleep(3000);

		webtest.click("xpath=//tbody[@id='the-comment-list']/tr/th/input");
		// ѡ����׼������
		webtest.click("xpath=//select[@id='bulk-action-selector-top']");
		webtest.selectByValue("xpath=//select[@id='bulk-action-selector-top']", "approve");
		webtest.click("xpath=//input[@id='doaction']");
	}

	// ɾ�����۹���
	// ��ɾ������ʱ����������ƶ����������ϣ��������ȵ��������Ч����ͬ��
	
	
	@Test(priority = '4')
	public void Delete_comment() throws Exception {
		webtest.runJs("arguments[0].click();", "xpath=//div[contains(text(),'����')]");
		Thread.sleep(3000);
		webtest.mouseoverElement("xpath=//p[contains(.,'�Ȿ��ܺ�')]");

		webtest.runJs("arguments[0].click();", "xpath=//a[contains(text(),'��������վ')]");
		Thread.sleep(3000);

	}

	// �ܷ�����۽���ɸѡ
	@Test(priority = '5')
	public void Select() throws InterruptedException {

		webtest.runJs("arguments[0].click();", "xpath=//a[@href='edit-comments.php']");
		Thread.sleep(3000);
		webtest.click("xpath=//select[@id='filter-by-comment-type']");
		webtest.selectByVisibleText("xpath=//select[@id='filter-by-comment-type']", "����");
		webtest.click("xpath=//input[@id='post-query-submit']");
	}

	// �ܷ��޸�����
	@Test(priority = '6')
	public void change_commit() {		

		webtest.open("http://localhost:8032/wordpress/");
		// ����DOWN��
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("link=���磬���ã�");
		for (int i = 0; i < 10; i++) {
			webtest.KeyDown();
		}
		webtest.click("xpath=//a[@href='http://localhost:8032/wordpress/wp-admin/comment.php?action=editcomment&c=1']");
		webtest.click("xpath=//label[text()='����']");
		webtest.click("xpath=//input[@id='save']");

	}

}
