package com.example.blog.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.application.port.in.CreatePostUseCase;
import com.example.blog.application.usecase.dto.PostInputDTO;

@RestController
@RequestMapping("/api/v1/post")
public class CreatePostController {
	
	private final CreatePostUseCase createPostUseCase;
	
	public CreatePostController(CreatePostUseCase createPostUseCase) {
		this.createPostUseCase = createPostUseCase;
	}
	
	@PostMapping("/createPost")
	public ResponseEntity<String> createPost(@RequestBody PostInputDTO input) {
		String output = this.createPostUseCase.execute(input);
		return ResponseEntity.ok().body(output);
	}
}
