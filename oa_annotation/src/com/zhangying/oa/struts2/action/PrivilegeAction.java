package com.zhangying.oa.struts2.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhangying.oa.domain.MenuItem;
import com.zhangying.oa.domain.User;
import com.zhangying.oa.service.MenuItemService;
import com.zhangying.oa.service.PrivilegeService;
import com.zhangying.oa.service.UserService;
import com.zhangying.oa.struts2.action.base.BaseAction;
import com.zhangying.oa.utils.OAUtil;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<MenuItem> {
	@Resource(name = "privilegeService")
	private PrivilegeService privilegeService;

	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name="menuItemService")
	private MenuItemService menuItemService;

	private Collection<MenuItem> menuItems;
	private Long uid;
	private String mids;

	public Collection<MenuItem> getMenuItems() {
		return menuItems;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getMids() {
		return mids;
	}

	public void setMids(String mids) {
		this.mids = mids;
	}

	public String showPrivilege() {
		this.menuItems = this.privilegeService.getAllPrivilege(this.uid);
		return SUCCESS;
	}

	/**
	 * 保存某一个用户的权限
	 */
	public String savePrivilege() {
		User user = this.userService.getUserByUid(this.getUid());
		//System.out.println(user.getMenuItems());
		Set<MenuItem> items  = this.menuItemService.getMenuItemByIds(OAUtil.StringToLong(this.mids));
		user.setMenuItems(items);
		//System.out.println(user.getMenuItems());
		this.userService.updateUser(user);
		
		return SUCCESS;
	}
}
