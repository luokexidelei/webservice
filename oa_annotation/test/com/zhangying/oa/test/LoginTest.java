package com.zhangying.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangying.oa.dao.LoginDao;

public class LoginTest {
	@Test
	public void testLoginDao() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		LoginDao login = (LoginDao) applicationContext.getBean("loginDao");
		login.getUserByUsernameAndPassword("美女", "aaa");
	}
}
