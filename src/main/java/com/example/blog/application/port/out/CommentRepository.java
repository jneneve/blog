package com.example.blog.application.port.out;

import java.util.List;

import com.example.blog.application.domain.Comment;

public interface CommentRepository {

	public void save(Comment comment);
	
	public List<Comment> getById(String postId);
}
