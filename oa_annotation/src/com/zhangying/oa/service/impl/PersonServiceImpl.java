package com.zhangying.oa.service.impl;

import com.zhangying.oa.dao.PersonDao;
import com.zhangying.oa.domain.Person;
import com.zhangying.oa.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;
	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.personDao.savePerson(person);
	}
	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	
}
