package com.zhangying.oa.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.UserDao;
import com.zhangying.oa.dao.base.impl.BaseDaoImpl;
import com.zhangying.oa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao<User>{

	@Override
	public Collection<User> getUsers() {
		// TODO Auto-generated method stub
		//								    from User u left join fetch u.department d left join fetch u.posts p
		//return this.hibernateTemplate.find("from User u left join fetch u.department d left join fetch u.posts p");
		//去重
		List<User> list = this.hibernateTemplate.find("from User u left join fetch u.department d left join fetch u.posts p");
		return new HashSet<User>(list);
	}

	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		List<User> user = this.hibernateTemplate.find("from User where username=?",username);
		if(user.size()>0) {
			return user.get(0);
		}
		return null;
	}

	

}
