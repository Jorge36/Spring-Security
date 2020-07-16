package com.springsecurity.demo.springsecurity.dao;

import com.springsecurity.demo.springsecurity.entity.User;

public interface UserDao {
	
    public User findByUserName(String userName);
    
    public void save(User user);

}
