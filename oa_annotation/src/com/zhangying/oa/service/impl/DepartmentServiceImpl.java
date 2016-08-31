package com.zhangying.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangying.oa.dao.DepartmentDao;
import com.zhangying.oa.domain.Department;
import com.zhangying.oa.service.DepartmentService;
import com.zhangying.oa.utils.DeleteMode;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	@Override
	@Transactional(readOnly=false)
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.saveEntry(department);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.updateEntry(department);;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteDepartment(Serializable id,String deleteMode) {
		// TODO Auto-generated method stub
		this.departmentDao.deleteEntryById(id);;
	}

	@Override
	public Collection<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.departmentDao.getAllEntry();
	}

	@Override
	public Department getDepartmentById(Serializable id) {
		// TODO Auto-generated method stub
		return this.departmentDao.getEntryById(id);
	}

	
	

}
