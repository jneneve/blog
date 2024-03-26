package com.example.blog.application.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;

public class Post {

	@Getter
	private UUID postId;

	@Getter
	private String title;

	@Getter
	private String content;

	@Getter
	private LocalDateTime timestamp;

	private Post(UUID postId, String title, String content, LocalDateTime timestamp) {
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.timestamp = timestamp;
	}

	public static Post create(String title, String content, LocalDateTime timestamp) {
		UUID postId = UUID.randomUUID();
		return new Post(postId, title, content, timestamp);
	}

	public static Post restore(UUID postId, String title, String content, LocalDateTime timestamp) {
		return new Post(postId, title, content, timestamp);
	}
}
