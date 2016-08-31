package com.zhangying.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangying.oa.domain.Person;
import com.zhangying.oa.service.PersonService;

public class PersonTest {
	@Test
	public void testPerson() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		PersonService personService = (PersonService) context.getBean("personService");
		System.out.println(personService);
	}
	@Test
	public void testSavePerson() {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		PersonService personService = (PersonService) context.getBean("personService");
		Person person = new Person();
		person.setPname("aa");
		personService.savePerson(person);
	}
}
