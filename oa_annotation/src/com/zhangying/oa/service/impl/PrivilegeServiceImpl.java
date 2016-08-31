package com.zhangying.oa.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangying.oa.dao.PrivilegeDao;
import com.zhangying.oa.domain.MenuItem;
import com.zhangying.oa.service.PrivilegeService;


@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService{
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Override
	public Collection<MenuItem> getAllPrivilege(Long uid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getMenuItemByUID(uid);
	}

}
