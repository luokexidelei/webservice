package com.zhangying.oa.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangying.oa.domain.Person;
import com.zhangying.oa.service.PersonService;

public class PersonAction extends ActionSupport{
	private PersonService personService;
	
	
	public String savePerson() {
		Person person = new Person();
		person.setPname("bb");
		this.personService.savePerson(person);
		return null;
	}
	
	
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	 
}
