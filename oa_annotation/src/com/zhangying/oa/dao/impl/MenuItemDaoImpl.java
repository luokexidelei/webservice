package com.zhangying.oa.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.MenuItemDao;
import com.zhangying.oa.dao.base.impl.BaseDaoImpl;
import com.zhangying.oa.domain.MenuItem;
import com.zhangying.oa.domain.User;
import com.zhangying.oa.utils.OAUtil;

@Repository("menuItemDao")
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements
		MenuItemDao<MenuItem> {

	@Override
	public Collection<MenuItem> getMenuItemById(Long pid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from MenuItem where pid=?", pid);
	}

	@Override
	public Set<MenuItem> getMenuItemsByIds(Long[] ids) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("from MenuItem ");
		sb.append("where mid in (");
		for (int i = 0; i < ids.length; i++) {
			if (i < ids.length - 1) {
				sb.append(ids[i] + ",");
			} else {
				sb.append(ids[i]);
			}
		}
		sb.append(" )");
		List<MenuItem> menuItems = this.hibernateTemplate.find(sb.toString());
		return new HashSet<MenuItem>(menuItems);
	}

	@Override
	public Collection<MenuItem> getMenuItemByUser() {
		// TODO Auto-generated method stub
		User user = OAUtil.fromSession();
		if ("admin".equals(user.getUsername())) {
			return this.getAllEntry();
		} else {
			return this.hibernateTemplate
					.find("from MenuItem m inner join fetch m.users u where u.uid=?",
							user.getUid());
		}
	}

}
