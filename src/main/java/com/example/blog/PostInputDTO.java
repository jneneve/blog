package com.example.blog;

import java.time.LocalDateTime;

public record PostInputDTO(String title, String content, LocalDateTime timestamp) {
}
