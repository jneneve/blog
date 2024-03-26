package com.example.blog.application.usecase.dto;

import java.time.LocalDateTime;

public record CommentOutputDTO(String commentId, String author, String comment, LocalDateTime timestamp, String postId) {

}
