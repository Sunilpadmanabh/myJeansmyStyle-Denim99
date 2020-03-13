package com.service;

import org.springframework.mail.SimpleMailMessage;

import com.model.EmailAndPasswordToken;

public interface EmailAndPasswordService {
	int saveUserToken(EmailAndPasswordToken token);
	EmailAndPasswordToken getUserByEmail(String email);
	EmailAndPasswordToken getUserByToken(String token);
	int deletePasswordResetToken(EmailAndPasswordToken token);
	void sendMail2(SimpleMailMessage passwordResetEmail);
}
