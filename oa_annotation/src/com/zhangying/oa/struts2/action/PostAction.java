package com.zhangying.oa.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhangying.oa.domain.Post;
import com.zhangying.oa.service.PostService;
import com.zhangying.oa.struts2.action.base.BaseAction;

@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post> {
	@Resource(name="postService")
	private PostService postService;
	
	public String getAllPost() {
		Collection posts = this.postService.getAllPost();
		ActionContext.getContext().put("post", posts);
		return listAction;
	}
	//addUI
	public String addUI() {
		return addUI;
	}
	//增加
	public String add() {
		Post post = new Post();
		BeanUtils.copyProperties(this.getModel(), post);
		this.postService.savePost(post);
		return action2action;
	}
	//删除
	public String delete() {
		this.postService.deletePost(this.getModel().getPid());
		return action2action;
	}
	//updateUI
	public String updateUI() {
		Post post = this.postService.getPostById(this.getModel().getPid());
		ActionContext.getContext().getValueStack().pop();
		ActionContext.getContext().getValueStack().push(post);
		return updateUI;
	}
	//修改
	public String update() {
		Post post = this.postService.getPostById(this.getModel().getPid());
		BeanUtils.copyProperties(this.getModel(), post);
		this.postService.updatePost(post);
		return action2action;
	}
}
