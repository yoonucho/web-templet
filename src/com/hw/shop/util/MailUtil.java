package com.hw.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
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
import javax.mail.internet.MimeUtility;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class MailUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String[] emailList = { "chejug@gmail.com" };// 메일 보낼사람 리스트 
			String emailFromAddress = "chejug@gmail.com";// 메일 보내는 사람
			String emailMsgTxt = "메일 테스트 내용 "; // 내용
			String emailSubjectTxt = "잘가는지 테스트 중~~~~~~~~~~";// 제목
//			
//			
//			List list = new ArrayList();
//			
//			String[] titles = (String[]) model.get("titles");
//			String[] order = (String[]) model.get("order");
//			String sheetName = (String) model.get("sheetName");
//			
//			
//			Map map = new HashMap();
//			map.put("a", "a");
//			map.put("a", "a");
//			map.put("a", "a");
//			map.put("a", "a");
//			list.add(map);
//			
//			ExcelUtil eUtil = new ExcelUtil();
//			
//			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("c:\\1.xls"));
//			   HSSFWorkbook wb = new HSSFWorkbook(fs);
//
//			
//			eUtil.buildExcelDocument(model, wb, request, response)
//			
			
			// 메일보내기 
			postMail(emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
			System.out.println("모든 사용자에게 메일이 성공적으로 보내졌음~~");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	private static void postMail(String recipients[], String subject, String message, String from,File file) throws MessagingException {
		boolean debug = false;
		java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
 
		String SMTP_HOST_NAME = "gmail-smtp.l.google.com";
		
		// Properties 설정
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
 
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props, auth);
 
		session.setDebug(debug);
 
		// create a message
		Message msg = new MimeMessage(session);
 
		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
 
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);
 
		// Setting the Subject and Content Type
		msg.setSubject(subject);
//		msg.setContent(message, "text/plain");
		msg.setContent(message, "text/html;charset=UTF-8");

		if(file!=null){
			// 파일첨부
			Multipart mp = new MimeMultipart();
			// mp.addBodyPart(mbp01);
			MimeBodyPart mbp02 = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(file);
			mbp02.setDataHandler(new DataHandler(fds));
			try {
				mbp02.setFileName(MimeUtility.encodeText(fds.getName(), "KSC5601", "B"));
			} catch (UnsupportedEncodingException e) {
				mbp02.setFileName(fds.getName());
			}
			// String fileName = fds.getName(); //임시파일 삭제를 위해 파일이름을 설정
			mp.addBodyPart(mbp02);
			msg.setContent(mp);

			// 파일첨부
		}

		Transport.send(msg);
	}

	private static void postMail(String recipients[], String subject, String message, String from) throws MessagingException {
		postMail(recipients,subject,message,from,null);
	}
 
	/**
	 * 구글 사용자 메일 계정 아이디/패스 정보
	 */
	private static class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username =  "chejug@gmail.com"; // gmail 사용자;
			String password = "kk460517"; // 패스워드;
			return new PasswordAuthentication(username, password);
		}
	}
}
