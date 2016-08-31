package com.zhangying.oa.struts2.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhangying.oa.domain.Department;
import com.zhangying.oa.domain.Post;
import com.zhangying.oa.domain.User;
import com.zhangying.oa.service.DepartmentService;
import com.zhangying.oa.service.PostService;
import com.zhangying.oa.service.UserService;
import com.zhangying.oa.struts2.action.base.BaseAction;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@Resource(name="postService")
	private PostService postService;
	
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long[] getPids() {
		return pids;
	}

	public void setPids(Long[] pids) {
		this.pids = pids;
	}

	private Long did;
	private Long pids[];
	
	public String getAllUser() {
		Collection<User> users = this.userService.getAllUser();
		ActionContext.getContext().getValueStack().push(users);
		return listAction;
	}
	
	public String addUI() {
		/**
		 * 1.把部门表所有数据查出来
		 * 2.把岗位表所有数据查出来
		 * 3.跳转到增加页面 
		 */
		Collection<Department> departments = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departments", departments);
		Collection<Post> posts = this.postService.getAllPost();
		ActionContext.getContext().put("posts", posts);
		return addUI;
	}
	//增加
	public String add() {
		User user = new User();
		//保存一般属性
		BeanUtils.copyProperties(this.getModel(), user);
		Department department = this.departmentService.getDepartmentById(did);
		user.setDepartment(department);
		Set<Post> posts = this.postService.getPostsByIds(pids);
		user.setPosts(posts);
		this.userService.saveUser(user);
		return action2action;
	}
	//
	public String checkUser() {
		User user = this.userService.getUserByUserName(this.getModel().getUsername());
		if(user == null) {
			this.msg = "该用户名可以使用";
		}else {
			this.msg = "该用户名已被注册";
		}
		return SUCCESS;
	}
}
