package com.springsecurity.demo.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springsecurity.demo.springsecurity.entity.User;
import com.springsecurity.demo.springsecurity.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
	
}
