package com.zhangying.oa.service;

import com.zhangying.oa.domain.User;

public interface LoginService {
	public User getUserByUsernameAndPassword(String username,String password);
}
