package com.example.blog;

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
