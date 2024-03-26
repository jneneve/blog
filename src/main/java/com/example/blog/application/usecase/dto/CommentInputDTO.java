package com.example.blog.application.usecase.dto;

import java.time.LocalDateTime;

public record CommentInputDTO(String author, String comment, LocalDateTime timestamp, String postId) {
}
