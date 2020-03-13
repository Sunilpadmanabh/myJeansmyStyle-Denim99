package com.dao;

import com.model.EmailAndPasswordToken;
import com.model.User;

public interface PasswordResetDao {

	int saveUserToken(EmailAndPasswordToken token);
	EmailAndPasswordToken getUserByEmail(String email);
	EmailAndPasswordToken getUserByToken(String token);
	int deletePasswordResetToken(EmailAndPasswordToken token);
}
