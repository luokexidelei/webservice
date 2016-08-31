package com.zhangying.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangying.oa.dao.LoginDao;
import com.zhangying.oa.domain.User;
import com.zhangying.oa.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name="loginDao")
	private LoginDao loginDao;
	@Override
	public User getUserByUsernameAndPassword(String username,String password) {
		// TODO Auto-generated method stub
		return this.loginDao.getUserByUsernameAndPassword(username, password);
	}

}
