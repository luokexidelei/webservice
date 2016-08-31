package com.zhangying.oa.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.PostDao;
import com.zhangying.oa.dao.base.impl.BaseDaoImpl;
import com.zhangying.oa.domain.Post;

@Repository("postDao")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao<Post> {

	@Override
	public Set<Post> getPostsByIds(Long[] pids) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("from Post");
		sb.append(" where pid in(");
		for(int i=0;i<pids.length;i++) {
			//不是最后一个
			if(i<pids.length-1) {
				sb.append(pids[i]+",");
			}else{
				sb.append(pids[i]);
			}
		}
		sb.append(")");
		List<Post> posts = this.hibernateTemplate.find(sb.toString());
		return new HashSet<Post>(posts);
	}

}
