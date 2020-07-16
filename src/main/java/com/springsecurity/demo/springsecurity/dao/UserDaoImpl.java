package com.springsecurity.demo.springsecurity.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springsecurity.demo.springsecurity.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public User findByUserName(String userName) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// now retrieve/read from database using name
		Query<User> query = currentSession.createQuery("from User where userName=:uName", User.class);
		query.setParameter("uName", userName);
		
		User user = null;
		
		try {
			
			user = query.getSingleResult();
			
		} catch (Exception e) {
		}
		
		
		return user;
	}

	@Override
	public void save(User user) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create the user
		currentSession.saveOrUpdate(user);
		
	}
	
	
}
