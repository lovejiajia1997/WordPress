
package com.webtest.core;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Javamail {

	public static  void send(String toAddress, String subject, String txt) {
		
		// ����һ��Property�ļ�����
		Properties props = new Properties();

		// �����ʼ�����������Ϣ����������smtp��������
		props.put("mail.smtp.host", "smtp.qq.com");

		// ����socket factory �Ķ˿�
		props.put("mail.smtp.socketFactory.port", "465");

		// ����socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// ������Ҫ�����֤
		props.put("mail.smtp.auth", "true");

		// ����SMTP�Ķ˿ڣ�QQ��smtp�˿���25
		props.put("mail.smtp.port", "25");

		// �����֤ʵ��
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
                       // �ڶ���������������QQ����smtp����Ȩ��
			return new PasswordAuthentication("1084170857@qq.com", "minmvgbuqfwshdgd");

			}

		});

		try {

			// ����һ��MimeMessage���ʵ������
			Message message = new MimeMessage(session);

			// ���÷����������ַ
			message.setFrom(new InternetAddress("1084170857@qq.com"));

			// �����ռ��������ַ
//			  String emailList[]=email.split("");
//	            InternetAddress[] toAddress = new InternetAddress[emailList.length];			
//	            for(int i=0;i<emailList.length;i++)
//	            {
//	            	toAddress[i]=new InternetAddress(emailList[i]);
//	            }			 
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
           // �����ʼ�����
	            message.setSubject(subject);

			// ����һ��MimeBodyPart�Ķ����Ա��������
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// �����ʼ���������
			messageBodyPart1.setText("txt");
            messageBodyPart1.setContent(txt,"text/html;charset=utf-8");
			// ��������һ��MimeBodyPart�����Ա������������
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// �����ʼ��и����ļ���·��
			String filename = "D:\\demo\\auto2018\\auto2018\\ftl\\test.html";

			// ����һ��datasource���󣬲������ļ�
			DataSource source = new FileDataSource(filename);

			// ����handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// �����ļ�
			messageBodyPart2.setFileName(filename);

			// ����һ��MimeMultipart���ʵ������
			Multipart multipart = new MimeMultipart();

			// �������1����
			multipart.addBodyPart(messageBodyPart1);

			// �������2����
			multipart.addBodyPart(messageBodyPart2);

			// ��������
			message.setContent(multipart);

			// ���շ����ʼ�
			Transport.send(message);
 
			System.out.println("=====�ʼ��Ѿ�����=====");

		} catch (MessagingException e) {

			   throw new RuntimeException(e);

		}

	}
 public static void main(String[] args) {
	Javamail.send("541520730@qq.com", "��������", "��������");
}
}
