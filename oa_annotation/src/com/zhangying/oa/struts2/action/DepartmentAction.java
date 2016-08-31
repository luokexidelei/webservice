package com.zhangying.oa.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.zhangying.oa.domain.Department;
import com.zhangying.oa.service.DepartmentService;
import com.zhangying.oa.struts2.action.base.BaseAction;
import com.zhangying.oa.utils.DeleteMode;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	//private Department model = new Department();
	@Resource(name="departmentService")
	private DepartmentService departmentService;

	
	
	
	public String getAllDepartment() {
		Collection<Department> departments = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	
	public String deleteDepartmentById() {
		this.departmentService.deleteDepartment(this.getModel().getDid(), DeleteMode.DEL_PRE_RELEASE);
		return action2action;
	}
	
	public String addUI() {
		return addUI;
	}
	public String add() {
		/**
		 * modelDriven中的model最好不要与service，dao相关联
		 * 1.新建一个department
		 * 2.把模型驱动中的值赋值到department
		 * 3.执行save
		 */
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveDepartment(department);
		return action2action;
	}
	/**
	 * 一般情况下，如果数据进行回显，则把数据放入到对象栈中，页面上可以根据name属性的值进行回显
	 * 如果把数据放入到了map栈，则页面根据value的值进行回显，而且value="%{ognl表达式}"
	 * @return
	 */
	public String updateUI() {
		Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
		//System.out.println(department.getDname());
		ActionContext.getContext().getValueStack().push(department);;
		return updateUI;
	}
	/**
	 * 1、先根据id把该数据从数据库中提取出来(或者从session的缓存中)
	 * 2、把修改以后的数据赋值到该对象中
	 * 3、针对该对象进行update操作
	 */
	public String update() {
		Department department = this.departmentService.getDepartmentById(this.getModel().getDid());
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateDepartment(department);
		return action2action;
	}

	/*@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return this.model;
	}*/
}
