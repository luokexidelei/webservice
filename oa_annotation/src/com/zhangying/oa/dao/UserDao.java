package com.zhangying.oa.dao;

import java.util.Collection;

import com.zhangying.oa.dao.base.BaseDao;
import com.zhangying.oa.domain.User;



public interface UserDao<T> extends BaseDao<T>{
	public Collection<User> getUsers();
	
	public User getUserByUserName(String username);
	
	
	
	
}
