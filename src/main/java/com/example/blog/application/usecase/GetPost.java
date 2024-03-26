package com.example.blog.application.usecase;

import org.springframework.stereotype.Service;

import com.example.blog.application.domain.Post;
import com.example.blog.application.port.in.GetPostUseCase;
import com.example.blog.application.port.out.PostRepository;
import com.example.blog.application.usecase.dto.PostOutputDTO;

@Service
public class GetPost implements GetPostUseCase {

	private final PostRepository postRepository;

	public GetPost(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public PostOutputDTO execute(String postId) {
		Post post = this.postRepository.getById(postId);
		if (post == null) {
			throw new IllegalStateException("Post not found!");
		}
		return new PostOutputDTO(post.getPostId().toString(), post.getTitle(), post.getContent(), post.getTimestamp());
	}
}
