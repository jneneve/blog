package com.example.blog.application.port.in;

import java.util.List;

import com.example.blog.application.usecase.dto.CommentOutputDTO;

public interface GetCommentsUseCase {

	public List<CommentOutputDTO> execute(String postId);
}
