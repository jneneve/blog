package com.example.blog.application.port.in;

import com.example.blog.application.usecase.dto.PostOutputDTO;

public interface GetPostUseCase {

	public PostOutputDTO execute(String postId);
}
