package com.zhangying.oa.dao;

import com.zhangying.oa.domain.User;

public interface LoginDao {
	public User getUserByUsernameAndPassword(String username, String password);
}
