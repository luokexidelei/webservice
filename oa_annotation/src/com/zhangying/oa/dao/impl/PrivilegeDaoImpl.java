package com.zhangying.oa.dao.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.PrivilegeDao;
import com.zhangying.oa.dao.UserDao;
import com.zhangying.oa.dao.base.impl.BaseDaoImpl;
import com.zhangying.oa.domain.MenuItem;
import com.zhangying.oa.domain.User;

@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<MenuItem> implements PrivilegeDao<MenuItem> {
	
	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	public Collection<MenuItem> getMenuItemByUID(Long uid) {
		/**
		 * 如果是admin则把所有的菜单的checked设置为true
		 * 如果不是amdin,则先遍历所有的菜单项，再遍历用户能访问到的菜单项，然后把所有的菜单项中，用户能够访问到的checked设置为true
		 */
		/**
		 * 当user被提取出来以后，session已经关闭了
		 */
		User user = (User) this.userDao.getEntryById(uid);
		Collection<MenuItem> menuItems = this.getAllEntry();
		Collection<MenuItem> items = this.hibernateTemplate.find("from MenuItem m inner join fetch m.users u where u.uid=?",uid);
		if("admin".equals(user.getUsername())) {
			for (MenuItem menuItem : menuItems) {
				menuItem.setChecked(true);
			}
		}else{
			for (MenuItem menuItem : menuItems) {
				for (MenuItem menuItem2 : items) {
					if(menuItem.getMid().longValue() == menuItem2.getMid().longValue()) {
						menuItem.setChecked(true);
					}
				}
			}
		}
		return menuItems;
	}
}
