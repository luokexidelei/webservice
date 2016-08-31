package com.zhangying.oa.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zhangying.oa.dao.PersonDao;
import com.zhangying.oa.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}


}
