package com.zhangying.oa.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangying.oa.dao.PostDao;
import com.zhangying.oa.domain.Post;
import com.zhangying.oa.service.PostService;

@Service("postService")
public class PostServiceImpl implements PostService{
	@Resource(name="postDao")
	private PostDao postDao;
	@Override
	public Collection<Post> getAllPost() {
		// TODO Auto-generated method stub
		return this.postDao.getAllEntry();
	}

	@Override
	@Transactional(readOnly=false)
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		this.postDao.updateEntry(post);
	}

	@Override
	@Transactional(readOnly=false)
	public void deletePost(Serializable id) {
		// TODO Auto-generated method stub
		//Post post = (Post) this.postDao.getEntryById(id);
		this.postDao.deleteEntryById(id);
	}

	@Override
	public Post getPostById(Serializable id) {
		// TODO Auto-generated method stub
		return (Post) this.postDao.getEntryById(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void savePost(Post post) {
		// TODO Auto-generated method stub
		this.postDao.saveEntry(post);
	}

	@Override
	public Set<Post> getPostsByIds(Long[] pids) {
		// TODO Auto-generated method stub
		return this.postDao.getPostsByIds(pids);
	}

}
