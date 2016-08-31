package com.zhangying.oa.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhangying.oa.domain.User;
import com.zhangying.oa.service.LoginService;
import com.zhangying.oa.struts2.action.base.BaseAction;
import com.zhangying.oa.utils.OAUtil;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User> {
	@Resource(name="loginService")
	private LoginService loginService;
	
	public String login() {
		//System.out.println(this.getModel().getUsername()+","+this.getModel().getPassword());
		User user = this.loginService.getUserByUsernameAndPassword(this.getModel().getUsername(),this.getModel().getPassword());
		if(user != null) {//成功
			//System.out.println("有人");
			OAUtil.putUser2Session(user);
			return "index";
		}else {//失败
			return null;
		}
	}
}
