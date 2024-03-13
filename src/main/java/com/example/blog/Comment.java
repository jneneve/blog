package com.example.blog;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;

public class Comment {

	@Getter
	private UUID commentId;

	@Getter
	private String author;

	@Getter
	private String comment;

	@Getter
	private LocalDateTime timestamp;

	@Getter
	private String postId;

	private Comment(UUID commentId, String author, String comment, LocalDateTime timestamp, String postId) {
		this.commentId = commentId;
		this.author = author;
		this.comment = comment;
		this.timestamp = timestamp;
		this.postId = postId;
	}

	public static Comment create(String author, String comment, LocalDateTime timestamp, String postId) {
		UUID commentId = UUID.randomUUID();
		return new Comment(commentId, author, comment, timestamp, postId);
	}

	public static Comment restore(UUID commentId, String author, String comment, LocalDateTime timestamp,
			String postId) {
		return new Comment(commentId, author, comment, timestamp, postId);
	}
}
