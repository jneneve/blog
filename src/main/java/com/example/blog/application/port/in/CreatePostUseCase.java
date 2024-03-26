package com.example.blog.application.port.in;

import com.example.blog.application.usecase.dto.PostInputDTO;

public interface CreatePostUseCase {

	public String execute(PostInputDTO input);
}
