package com.project.FeastFreedom.config;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class SESMailer {
	final static String FROM = "feastfreedommailer@gmail.com";
    final static String FROMNAME = "Feast Freedom";
    final static String SMTP_USERNAME = "AKIAUCNBSXUSX3XEUHSM";
    final static String SMTP_PASSWORD = "BKZESCl8fVGZqrUTZp4XP9gcog4nM2i2A+erde/qs50v";
    final static String HOST = "email-smtp.us-east-1.amazonaws.com";
    final static int PORT = 587;
	
	public static void send(String recipient, String subject, String bodyHTML) throws MessagingException {
	    String TO = recipient;
	    String SUBJECT = subject;
	    String BODY =  bodyHTML;
	    
	    Properties props = System.getProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.port", PORT);
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    
	    
	    Session session = Session.getDefaultInstance(props);
	    
	    MimeMessage msg = new MimeMessage(session);
	    
	    try {
	    	msg.setFrom(new InternetAddress(FROM,FROMNAME));
	    } catch (UnsupportedEncodingException ex) {
	    	System.out.println("Error in sending email: " + ex.getMessage());
	    }
	    
	    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
    	msg.setSubject(SUBJECT);
    	msg.setContent(BODY,"text/html");
    	
    	Transport transport = session.getTransport();
    	
    	try {
    	    transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent to " + msg.getAllRecipients().toString());
    	} catch (Exception ex) {
    		System.out.println("Error in sending email: " + ex.getMessage());
    	} finally {
    		transport.close();
    	}
	    
	}
}