package com.example.blog.application.usecase.dto;

import java.time.LocalDateTime;

public record PostOutputDTO(String postId, String title, String content, LocalDateTime timestamp) {
}
