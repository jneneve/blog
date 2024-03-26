package com.example.blog.application.usecase;

import org.springframework.stereotype.Service;

import com.example.blog.application.domain.Post;
import com.example.blog.application.port.in.CreatePostUseCase;
import com.example.blog.application.port.out.PostRepository;
import com.example.blog.application.usecase.dto.PostInputDTO;

@Service
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
