package com.example.blog;

import java.time.LocalDateTime;

public record PostInputModel(String title, String content, LocalDateTime timestamp) {
}
