package com.example.blog;

import java.util.List;

public interface CommentRepository {

	public void save(Comment comment);
	
	public List<Comment> getById(String postId);
}
