package com.example.blog.application.port.in;

import com.example.blog.application.usecase.dto.CommentInputDTO;

public interface AddCommentUseCase {

	public void execute(CommentInputDTO input);
}
