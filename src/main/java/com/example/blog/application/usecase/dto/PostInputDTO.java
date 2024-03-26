package com.example.blog.application.usecase.dto;

import java.time.LocalDateTime;

public record PostInputDTO(String title, String content, LocalDateTime timestamp) {
}
