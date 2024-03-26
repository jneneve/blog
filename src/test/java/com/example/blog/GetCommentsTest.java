package com.example.blog;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import com.example.blog.adapter.out.persistence.memory.CommentRepositoryMemory;
import com.example.blog.adapter.out.persistence.memory.PostRepositoryMemory;
import com.example.blog.application.port.in.GetCommentsUseCase;
import com.example.blog.application.port.out.CommentRepository;
import com.example.blog.application.port.out.PostRepository;
import com.example.blog.application.usecase.GetComments;

public class GetCommentsTest {

	@Test
	@Description("It should thrown an exception if the post not exist")
	public void thrownAnExceptionIfThePostNotExist() {
		PostRepository postRepository = new PostRepositoryMemory();
		CommentRepository commentRepository = new CommentRepositoryMemory();
		GetCommentsUseCase getCommentsUseCase = new GetComments(commentRepository, postRepository);
		UUID postId = UUID.randomUUID();
		assertThatThrownBy(() -> getCommentsUseCase.execute(postId.toString()))
				.isInstanceOf(IllegalStateException.class).hasMessageContaining("Post not found!");
	}
}
