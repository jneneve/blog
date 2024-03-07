package com.example.blog;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

public class AddComentTest {

	@Test
	@Description("It should add a comment to an already created post")
	public void addComentToAnAlreadyCreatedPost() {
		PostRepository postRepository = new PostRepositoryMemory();
		CreatePostUseCase createPostUseCase = new CreatePost(postRepository);
		PostInputModel postInputModel = new PostInputModel("The Enigmatic Journey of Cosmic Whispers",
				"Embark on a mysterious exploration through the celestial realms where whispers from the cosmos reveal secrets of the unknown. Join this enigmatic journey of discovery and transcendence",
				LocalDateTime.parse("2024-02-02T17:06:30"));
		String postId = createPostUseCase.execute(postInputModel);
		CommentRepository commentRepository = new CommentRepositoryMemory();
		AddCommentUseCase addCommentUseCase = new AddComment(commentRepository);
		GetCommentsUseCase getCommentsUseCase = new GetComments(commentRepository);
		CommentInputModel commentInputModel = new CommentInputModel("John Doe",
				"Excelent post, I agree with you about this subject!", LocalDateTime.parse("2024-03-07T17:06:30"), postId);
		addCommentUseCase.execute(commentInputModel);
		List<Comment> outputForGetComments = getCommentsUseCase.execute(postId);
		assertThat(outputForGetComments.size()).isEqualTo(1);
	}
}
