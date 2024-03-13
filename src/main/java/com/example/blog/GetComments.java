package com.example.blog;

import java.util.ArrayList;
import java.util.List;

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
