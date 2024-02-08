package com.example.blog;

import org.springframework.stereotype.Service;

@Service
public class GetPostService implements GetPostUseCase {

	private final PostRepository postRepository;
	
	public GetPostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public OutputPostModel execute(String postId) {
		Post post = this.postRepository.getById(postId);
		return new OutputPostModel(post.getTitle(), post.getContent(), post.getTimestamp());
	}
}
