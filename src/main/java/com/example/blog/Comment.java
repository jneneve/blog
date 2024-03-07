package com.example.blog;

import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {

	private UUID commentId;
	private String author;
	private String comment;
	private LocalDateTime timestamp;
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

	public UUID getCommentId() {
		return commentId;
	}

	public String getAuthor() {
		return author;
	}

	public String getComment() {
		return comment;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getPostId() {
		return postId;
	}
}
