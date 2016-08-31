package com.zhangying.oa.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zhangying.oa.dao.base.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private Class classt;
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	/**
	 * ParameterizedType 泛型
	 */
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classt = (Class) type.getActualTypeArguments()[0];//<T>
		System.out.println(type.getRawType());//BaseDaoImpl
	}
	
	
	@Override
	public Collection<T> getAllEntry() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from " + this.classt.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.hibernateTemplate.get(this.classt, id);
	}

	@Override
	public void saveEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntryById(Serializable id) {
		// TODO Auto-generated method stub
		
		T t = (T) this.hibernateTemplate.get(this.classt, id);
		this.hibernateTemplate.delete(t);
	}

	
	
	
}
