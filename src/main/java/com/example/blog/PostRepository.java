package com.example.blog;

public interface PostRepository {

	public void save(Post post);
	
	public Post getById(String postId);
}
