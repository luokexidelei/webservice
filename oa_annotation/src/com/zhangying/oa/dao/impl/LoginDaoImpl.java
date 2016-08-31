package com.zhangying.oa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.LoginDao;
import com.zhangying.oa.domain.User;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		List<User> user = this.hibernateTemplate.find(
				"from User where username=? and password=?", new Object[] {
						username, password });
		// System.out.println(user.size());
		if (user.size() != 0) {
			return user.get(0);
		} else {
			return null;
		}
	}

}
