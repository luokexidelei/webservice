package com.zhangying.oa.service;

import java.util.Collection;
import java.util.Set;

import com.zhangying.oa.domain.MenuItem;

public interface MenuItemService {
	public Collection<MenuItem> getAllMenuItem();
	
	public Collection<MenuItem> getMenuItemById(Long pid);
	
	public Set<MenuItem> getMenuItemByIds(Long[] pid);
	
	public Collection<MenuItem> getMenuItemByUser();
}
