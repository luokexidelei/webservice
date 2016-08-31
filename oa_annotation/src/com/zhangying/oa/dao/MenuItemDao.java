package com.zhangying.oa.dao;

import java.util.Collection;
import java.util.Set;

import com.zhangying.oa.dao.base.BaseDao;
import com.zhangying.oa.domain.MenuItem;

public interface MenuItemDao<T> extends BaseDao<T> {
	public Collection<MenuItem> getMenuItemById(Long pid);
	
	public Set<MenuItem> getMenuItemsByIds(Long ids[]);
	
	public Collection<MenuItem> getMenuItemByUser();
}
