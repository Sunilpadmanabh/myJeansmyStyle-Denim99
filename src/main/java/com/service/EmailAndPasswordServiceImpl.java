package com.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PasswordResetDao;
import com.model.EmailAndPasswordToken;

@Service
public class EmailAndPasswordServiceImpl implements EmailAndPasswordService{

	@Autowired
	private PasswordResetDao passwordResetDao;
	
	@Transactional
	public int saveUserToken(EmailAndPasswordToken token) {
		// TODO Auto-generated method stub
		return passwordResetDao.saveUserToken(token);
	}

	@Transactional
	public EmailAndPasswordToken getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return passwordResetDao.getUserByEmail(email);
	}

	public EmailAndPasswordToken getUserByToken(String token) {
		// TODO Auto-generated method stub
		return passwordResetDao.getUserByToken(token);
	}

	public int deletePasswordResetToken(EmailAndPasswordToken token) {
		// TODO Auto-generated method stub
		return passwordResetDao.deletePasswordResetToken(token);
	}
	public void sendMail2(final SimpleMailMessage passwordResetEmail) {
		try {
//			String to = "trilokksinha@gmail.com";
//			String from = "trilok.sinha@hotmail.com";

			Properties props = new Properties();
			// props.put("mail.smtp.socketFactory.port", "587");
			// props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			// props.put("mail.smtp.socketFactory.fallback", "true");
			props.put("mail.smtp.host", "smtp-mail.outlook.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(passwordResetEmail.getFrom(), "My987654321");
				}
			});

			// Session emailSession = Session.getDefaultInstance(props, null);

//			String msgBody = "Sending email using JavaMail API...";

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(passwordResetEmail.getFrom(), "NoReply"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(passwordResetEmail.getTo()[0], "Mr. Recipient"));
			msg.setSubject(passwordResetEmail.getSubject());
			msg.setText(passwordResetEmail.getText());
			Transport.send(msg);
			System.out.println("Email sent successfully...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
