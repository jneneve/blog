package com.example.blog.application.usecase;

import java.util.ArrayList;
import java.util.List;

import com.example.blog.application.domain.Comment;
import com.example.blog.application.domain.Post;
import com.example.blog.application.port.in.GetCommentsUseCase;
import com.example.blog.application.port.out.CommentRepository;
import com.example.blog.application.port.out.PostRepository;
import com.example.blog.application.usecase.dto.CommentOutputDTO;

public class GetComments implements GetCommentsUseCase {

	private final CommentRepository commentRepository;
	private final PostRepository postRepository;

	public GetComments(CommentRepository commentRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}

	@Override
	public List<CommentOutputDTO> execute(String postId) {
		Post post = this.postRepository.getById(postId);
		if (post == null) {
			throw new IllegalStateException("Post not found!");
		}
		List<Comment> comments = this.commentRepository.getById(postId);
		List<CommentOutputDTO> output = new ArrayList<CommentOutputDTO>();
		for (Comment comment : comments) {
			output.add(new CommentOutputDTO(comment.getCommentId().toString(), comment.getAuthor(),
					comment.getComment(), comment.getTimestamp(), comment.getPostId()));
		}
		return output;
	}
}
