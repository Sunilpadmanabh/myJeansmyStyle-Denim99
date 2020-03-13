package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Authorities;

@Repository
public class AuthoritiesDaoImpl implements AuthoritiesDao{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	public List<Authorities> getAuthoritiesByEmail(String emailId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Authorities where emailId=?");
		query.setString(0, emailId);
		List<Authorities> authorities = query.list();
		return authorities;
	}

}
