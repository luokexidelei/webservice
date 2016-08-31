package com.zhangying.oa.service;

import java.util.Collection;

import com.zhangying.oa.domain.MenuItem;

public interface PrivilegeService  {
	public Collection<MenuItem> getAllPrivilege(Long uid);
}
