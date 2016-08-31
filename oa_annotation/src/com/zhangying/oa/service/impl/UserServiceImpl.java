package com.zhangying.oa.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangying.oa.dao.UserDao;
import com.zhangying.oa.domain.User;
import com.zhangying.oa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public Collection<User> getAllUser() {
		// TODO Auto-generated method stub
		return this.userDao.getUsers();
	}
	@Override
	
	@Transactional(readOnly=false)
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.saveEntry(user);
	}
	@Override
	public User getUserByUserName(String name) {
		// TODO Auto-generated method stub
		return this.userDao.getUserByUserName(name);
	}
	@Override
	public User getUserByUid(Long uid) {
		// TODO Auto-generated method stub
		return (User) this.userDao.getEntryById(uid);
	}
	@Override
	@Transactional(readOnly=false)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.updateEntry(user);
	}
	@Override
	@Transactional(readOnly=false)
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		this.userDao.deleteEntryById(id);
	}

}
