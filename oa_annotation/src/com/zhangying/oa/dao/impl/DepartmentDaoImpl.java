package com.zhangying.oa.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.DepartmentDao;
import com.zhangying.oa.dao.base.impl.BaseDaoImpl;
import com.zhangying.oa.domain.Department;
import com.zhangying.oa.domain.User;
import com.zhangying.oa.utils.DeleteMode;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

	
}
