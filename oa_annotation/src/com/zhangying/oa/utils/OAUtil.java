package com.zhangying.oa.utils;

import org.apache.struts2.ServletActionContext;

import com.zhangying.oa.domain.User;

public class OAUtil {
	public static Long[] StringToLong(String ids) {
			String[] s = ids.split(",");
			Long[] aa = new Long[s.length];
			int index = 0;
			for (String str : s) {
				aa[index] = Long.valueOf(str);
				index++;
			}
			return aa;
	}
	
	public static User fromSession() {
		return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
	}
	
	public static void  putUser2Session(User user) {
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
	}
}
