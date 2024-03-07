package com.example.blog;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class CreatePostTest {

	@Test
	@Description("It should create a post") 
	public void createPost() {
		PostRepository postRepository = new PostRepositoryMemory();
		CreatePostUseCase createPostUseCase = new CreatePost(postRepository);
		GetPostUseCase getPostUseCase = new GetPost(postRepository);
		PostInputModel postInputModel = new PostInputModel(
				"The Enigmatic Journey of Cosmic Whispers", 
				"Embark on a mysterious exploration through the celestial realms where whispers from the cosmos reveal secrets of the unknown. Join this enigmatic journey of discovery and transcendence",
				LocalDateTime.parse("2024-02-02T17:06:30"));
		String postId = createPostUseCase.execute(postInputModel);
		Post outputForGetPost = getPostUseCase.execute(postId);
		assertThat(outputForGetPost.getTitle()).isEqualTo(postInputModel.title());
		assertThat(outputForGetPost.getContent()).isEqualTo(postInputModel.content());
	}
}
