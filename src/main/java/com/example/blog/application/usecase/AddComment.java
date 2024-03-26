package com.example.blog.application.usecase;

import com.example.blog.application.domain.Comment;
import com.example.blog.application.domain.Post;
import com.example.blog.application.port.in.AddCommentUseCase;
import com.example.blog.application.port.out.CommentRepository;
import com.example.blog.application.port.out.PostRepository;
import com.example.blog.application.usecase.dto.CommentInputDTO;

public class AddComment implements AddCommentUseCase {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	public AddComment(CommentRepository commentRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	@Override
	public void execute(CommentInputDTO input) {
		Post post = this.postRepository.getById(input.postId());
		if (post == null) {
			throw new IllegalStateException("Post not found!");
		}
		Comment comment = Comment.create(input.author(), input.comment(), input.timestamp(), input.postId());
		this.commentRepository.save(comment);
	}
}
