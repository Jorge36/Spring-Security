package com.springsecurity.demo.springsecurity.dao;

import com.springsecurity.demo.springsecurity.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String roleName);
	
}
