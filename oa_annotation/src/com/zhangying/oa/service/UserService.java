package com.zhangying.oa.service;

import java.util.Collection;

import com.zhangying.oa.domain.User;

public interface UserService {
	public Collection<User> getAllUser();
	
	public void saveUser(User user);
	
	public User getUserByUserName(String name);
	
	public User getUserByUid(Long uid);
	public void updateUser(User user);
	
	public void deleteUserById(Long id);
}
