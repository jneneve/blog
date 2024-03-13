package com.example.blog;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class GetPostTest {

	@Test
	@Description("It should thrown an exception if the post not exist")
	public void thrownAnExceptionIfThePostNotExist() {
		PostRepository postRepository = new PostRepositoryMemory();
		GetPostUseCase getPostUseCase = new GetPost(postRepository);
		UUID postId = UUID.randomUUID();
		assertThatThrownBy(() -> getPostUseCase.execute(postId.toString())).isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("Post not found!");
	}
}
