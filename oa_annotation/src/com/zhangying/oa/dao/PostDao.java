package com.zhangying.oa.dao;

import java.util.Set;

import com.zhangying.oa.dao.base.BaseDao;
import com.zhangying.oa.domain.Post;

public interface PostDao<T> extends BaseDao<T> {
	public Set<Post> getPostsByIds(Long[] pids);
}
