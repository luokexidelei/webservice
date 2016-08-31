package com.zhangying.oa.service;


import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.zhangying.oa.domain.Post;

public interface PostService  {
	public Collection<Post> getAllPost();
	
	public void updatePost(Post post);
	
	public void deletePost(Serializable id);
	
	public Post getPostById(Serializable id);
	
	public void savePost(Post post);
	
	public Set<Post> getPostsByIds(Long[] pids);
}
