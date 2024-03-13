package com.example.blog;

public class CreatePost implements CreatePostUseCase {

	private final PostRepository postRepository;

	public CreatePost(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public String execute(PostInputDTO input) {
		Post post = Post.create(input.title(), input.content(), input.timestamp());
		this.postRepository.save(post);
		return post.getPostId().toString();
	}
}
