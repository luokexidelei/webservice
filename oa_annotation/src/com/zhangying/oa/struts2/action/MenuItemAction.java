package com.zhangying.oa.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhangying.oa.domain.MenuItem;
import com.zhangying.oa.service.MenuItemService;
import com.zhangying.oa.struts2.action.base.BaseAction;

@Controller("menuItemAction")
@Scope("prototype")
public class MenuItemAction extends BaseAction<MenuItem> {
	@Resource(name="menuItemService")
	private MenuItemService menuItemService;
	
	private Collection<MenuItem> menuList;
	
	@JSON(serialize=false)
	//表示使用ajax不会将这个方法返回到前台
	public String getAllMenuItem() {
		this.menuList = this.menuItemService.getAllMenuItem();
		return SUCCESS;
	}

	public Collection<MenuItem> getMenuList() {
		return menuList;
	}
	
	public String showMenuItem() {
		this.menuList = this.menuItemService.getMenuItemById(this.getModel().getPid());
		return SUCCESS;
	}
	
	public String showMenuItemByUser() {
		this.menuList = this.menuItemService.getMenuItemByUser();
		
		return SUCCESS;
	}
	
}
