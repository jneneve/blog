package com.example.blog;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {

	private UUID postId;
	private String title;
	private String content;
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

	public UUID getPostId() {
		return postId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
