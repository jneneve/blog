package com.example.blog.adapter.out.persistence.memory;

import java.util.ArrayList;
import java.util.List;

import com.example.blog.application.domain.Comment;
import com.example.blog.application.port.out.CommentRepository;

public class CommentRepositoryMemory implements CommentRepository {

	List<Comment> comments = new ArrayList<Comment>();

	@Override
	public void save(Comment comment) {
		this.comments.add(comment);
	}

	@Override
	public List<Comment> getById(String postId) {
		List<Comment> commentsById = new ArrayList<Comment>();
		for (Comment comment : comments) {
			if (comment.getPostId().equals(postId)) {
				commentsById.add(Comment.restore(comment.getCommentId(), comment.getAuthor(), comment.getComment(),
						comment.getTimestamp(), comment.getPostId()));
			}
		}
		return commentsById;
	}
}
