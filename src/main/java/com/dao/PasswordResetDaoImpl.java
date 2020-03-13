package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.EmailAndPasswordToken;

@Repository
public class PasswordResetDaoImpl implements PasswordResetDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("finally")
	public int saveUserToken(EmailAndPasswordToken token) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(token);
			tx.commit();

			return 1;
		} catch (Exception e) {

		} finally {
			session.close();
			return 0;
		}
	}

	public EmailAndPasswordToken getUserByToken(String token) {
		Session session = sessionFactory.openSession();
		// select * from Product where isbn=i
		// if we call get method,Record doesnot exist it will return null
		// if we call load, if the record doesnt exist it will throw exception
		EmailAndPasswordToken user = (EmailAndPasswordToken) session.get(EmailAndPasswordToken.class, token);
		session.close();
		return user;
	}

	public EmailAndPasswordToken getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from EmailAndPasswordToken as o where o.email= :code");
		query.setParameter("code", email);
		List<EmailAndPasswordToken> userList = query.list();
		if (userList != null && userList.size()>0)
			return userList.get(0);
		else
			return null;
	}

	public int deletePasswordResetToken(EmailAndPasswordToken token) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(token);
			tx.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
