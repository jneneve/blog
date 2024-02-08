package com.example.blog;

import org.springframework.stereotype.Service;

@Service
public class CreatePostService implements CreatePostUseCase {

	private final PostRepository postRepository;

	public CreatePostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public String execute(InputPostModel inputModel) {
		Post post = Post.create(inputModel.title(), inputModel.content(), inputModel.timestamp());
		this.postRepository.save(post);
		return post.getPostId().toString();
	}
}
