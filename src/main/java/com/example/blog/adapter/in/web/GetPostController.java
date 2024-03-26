package com.example.blog.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.application.port.in.GetPostUseCase;
import com.example.blog.application.usecase.dto.PostOutputDTO;

@RestController
@RequestMapping("/api/v1/post")
public class GetPostController {

	private final GetPostUseCase getPostUseCase;

	public GetPostController(GetPostUseCase getPostUseCase) {
		this.getPostUseCase = getPostUseCase;
	}
	
	@GetMapping("/getPost/{postId}")
	public ResponseEntity<PostOutputDTO> getPost(@PathVariable("postId") String postId) {
		PostOutputDTO output = this.getPostUseCase.execute(postId);
		return ResponseEntity.ok().body(output);
	}
}
