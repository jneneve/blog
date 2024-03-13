package com.example.blog;

import java.time.LocalDateTime;

public record PostOutputDTO(String postId, String title, String content, LocalDateTime timestamp) {
}
