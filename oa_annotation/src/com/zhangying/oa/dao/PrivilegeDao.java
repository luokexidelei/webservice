package com.zhangying.oa.dao;

import java.util.Collection;

import com.zhangying.oa.dao.base.BaseDao;
import com.zhangying.oa.domain.MenuItem;

public interface PrivilegeDao<T> extends BaseDao<T> {
	public Collection<MenuItem> getMenuItemByUID(Long uid);
}
