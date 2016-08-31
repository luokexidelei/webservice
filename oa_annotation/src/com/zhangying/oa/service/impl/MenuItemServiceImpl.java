package com.zhangying.oa.service.impl;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangying.oa.dao.MenuItemDao;
import com.zhangying.oa.domain.MenuItem;
import com.zhangying.oa.service.MenuItemService;

@Service("menuItemService")
public class MenuItemServiceImpl implements MenuItemService{
	@Resource(name="menuItemDao")
	private MenuItemDao menuItemDao;
	@Override
	public Collection<MenuItem> getAllMenuItem() {
		// TODO Auto-generated method stub
		return this.menuItemDao.getAllEntry();
	}
	@Override
	public Collection<MenuItem> getMenuItemById(Long pid) {
		// TODO Auto-generated method stub
		return this.menuItemDao.getMenuItemById(pid);
	}
	@Override
	public Set<MenuItem> getMenuItemByIds(Long[] pid) {
		// TODO Auto-generated method stub
		return this.menuItemDao.getMenuItemsByIds(pid);
	}
	@Override
	public Collection<MenuItem> getMenuItemByUser() {
		// TODO Auto-generated method stub
		return this.menuItemDao.getMenuItemByUser();
	}

}
