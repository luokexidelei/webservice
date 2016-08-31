package com.zhangying.oa.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangying.oa.service.DepartmentService;

public class DepartmentTest  {
	@Test
	public void testQuery() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
		departmentService.getAllDepartment();
	}
}
