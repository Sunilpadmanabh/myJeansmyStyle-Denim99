package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		// List<Product> products = session.createQuery("from Product").list();
		List<User> users = session.createCriteria(User.class).list();
		System.out.println(users);
		session.close();
		return users;
	}

	public void deleteUser(String userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.saveOrUpdate(user);
		session.flush();
		session.close();// close the session
	}

	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

	public User getUserById(String userId) {
		// Reading the records from the table
		Session session = sessionFactory.openSession();
		// select * from Product where isbn=i
		// if we call get method,Record doesnot exist it will return null
		// if we call load, if the record doesnt exist it will throw exception
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from User as o where o.emailId= :code");
		query.setParameter("code", email);
		List<User> userList = query.list();
		if (userList != null && userList.size()>0)
			return userList.get(0);
		else
			return null;
	}

	public int updateUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			session.update(user);
			tx.commit();
			session.close();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
}
