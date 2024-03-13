package com.example.blog;

import java.time.LocalDateTime;

public record CommentInputDTO(String author, String comment, LocalDateTime timestamp, String postId) {
}
