package com.example.blog;

import org.springframework.stereotype.Service;

@Service
public class GetPost implements GetPostUseCase {

	private final PostRepository postRepository;
	
	public GetPost(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public Post execute(String postId) {
		return this.postRepository.getById(postId);
	}
}
