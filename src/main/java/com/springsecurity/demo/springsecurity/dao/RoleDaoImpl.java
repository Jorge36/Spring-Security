package com.springsecurity.demo.springsecurity.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springsecurity.demo.springsecurity.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Role findRoleByName(String roleName) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// now retrieve/read from database using name
		Query<Role> query = currentSession.createQuery("from Role where name=:roleName", Role.class);
		query.setParameter("roleName", roleName);
		
		Role role = null;
		
		try {
			
			role = query.getSingleResult();
			
		} catch(Exception ex) {			
		}
		
		return role;
	}

}
