package com.example.blog.application.port.out;

import com.example.blog.application.domain.Post;

public interface PostRepository {

	public void save(Post post);
	
	public Post getById(String postId);
}
