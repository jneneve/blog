package com.example.blog;

import org.springframework.stereotype.Service;

@Service
public class CreatePost implements CreatePostUseCase {

	private final PostRepository postRepository;

	public CreatePost(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public String execute(PostInputModel postInputModel) {
		Post post = Post.create(postInputModel.title(), postInputModel.content(), postInputModel.timestamp());
		this.postRepository.save(post);
		return post.getPostId().toString();
	}
}
