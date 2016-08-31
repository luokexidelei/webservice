package com.zhangying.oa.service;

import java.io.Serializable;
import java.util.Collection;

import com.zhangying.oa.domain.Department;
import com.zhangying.oa.utils.DeleteMode;

public interface DepartmentService {
	public void saveDepartment(Department department);
	public void updateDepartment(Department department);
	public void deleteDepartment(Serializable id,String deleteMode);
	public Collection<Department> getAllDepartment();
	public Department getDepartmentById(Serializable id);
}
