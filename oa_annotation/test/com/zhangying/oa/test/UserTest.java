package com.zhangying.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangying.oa.dao.UserDao;

public class UserTest {
    @Test
    public void testGetUser(){
    	ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    	UserDao userDao = (UserDao) context.getBean("userDao");
    	String name = userDao.getUserByUserName("啊啊").getUsername();
    	System.out.println(name);
    }
}
