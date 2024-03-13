package com.example.blog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class AddComentTest {

	@Test
	@Description("It should add a comment to an already created post")
	public void addComentToAnAlreadyCreatedPost() {
		PostRepository postRepository = new PostRepositoryMemory();
		CreatePostUseCase createPostUseCase = new CreatePost(postRepository);
		PostInputDTO inputForCreatePost = new PostInputDTO("The Enigmatic Journey of Cosmic Whispers",
				"Embark on a mysterious exploration through the celestial realms where whispers from the cosmos reveal secrets of the unknown. Join this enigmatic journey of discovery and transcendence",
				LocalDateTime.parse("2024-02-02T17:06:30"));
		String postId = createPostUseCase.execute(inputForCreatePost);
		CommentRepository commentRepository = new CommentRepositoryMemory();
		AddCommentUseCase addCommentUseCase = new AddComment(commentRepository, postRepository);
		GetCommentsUseCase getCommentsUseCase = new GetComments(commentRepository, postRepository);
		CommentInputDTO inputForAddComment = new CommentInputDTO("John Doe",
				"Excelent post, I agree with you about this subject!", LocalDateTime.parse("2024-03-07T17:06:30"),
				postId);
		addCommentUseCase.execute(inputForAddComment);
		List<CommentOutputDTO> outputForGetComments = getCommentsUseCase.execute(postId);
		assertThat(outputForGetComments.size()).isEqualTo(1);
	}

	@Test
	@Description("It should thrown an exception if the post not exist")
	public void thrownAnExceptionIfThePostNotExist() {
		PostRepository postRepository = new PostRepositoryMemory();
		CommentRepository commentRepository = new CommentRepositoryMemory();
		AddCommentUseCase addCommentUseCase = new AddComment(commentRepository, postRepository);
		UUID postId = UUID.randomUUID();
		CommentInputDTO inputForAddComment = new CommentInputDTO("John Doe",
				"Excelent post, I agree with you about this subject!", LocalDateTime.parse("2024-03-07T17:06:30"),
				postId.toString());
		assertThatThrownBy(() -> addCommentUseCase.execute(inputForAddComment))
				.isInstanceOf(IllegalStateException.class).hasMessageContaining("Post not found!");
	}
}
