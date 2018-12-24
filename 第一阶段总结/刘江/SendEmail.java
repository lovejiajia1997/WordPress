package com.webtest.javamail;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendEmail {
	public static void send(String email, String subject, String body) throws UnsupportedEncodingException {
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
					return new PasswordAuthentication("2572707156@qq.com", "nhhymutnflkwebia");
					}
				});
				try {

					// ����һ��MimeMessage���ʵ������
					Message message = new MimeMessage(session);

					// ���÷����������ַ
					message.setFrom(new InternetAddress("2572707156@qq.com"));		 
			        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		            // �����ʼ�����
			        message.setSubject(subject);
					// ����һ��MimeBodyPart�Ķ����Ա��������
					BodyPart messageBodyPart = new MimeBodyPart();
					// �����ʼ���������
		            messageBodyPart.setContent(body,"text/html;charset=utf-8");
					// �����ʼ��и����ļ���·��
					String filename = "D:\\ѧϰ����\\�����\\Java\\auto2018\\ftl\\test.html";
					// ����һ��datasource���󣬲������ļ�
					DataSource source = new FileDataSource(filename);
					// ����һ��MimeMultipart���ʵ������
					Multipart multipart = new MimeMultipart();
					// �����������
					multipart.addBodyPart(messageBodyPart);
					// ��������
					message.setContent(multipart);
					// ���շ����ʼ�
					Transport.send(message);
					System.out.println("=====�ʼ��Ѿ�����=====");
				} catch (NoSuchProviderException e) {
		            e.printStackTrace();
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }

			}
		 public static void main(String[] args) throws UnsupportedEncodingException {
			SendEmail.send("2572707156@qq.com", "��������", "��������");
	}
}
