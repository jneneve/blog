package com.example.blog;

import java.time.LocalDateTime;

public record InputPostModel(String title, String content, LocalDateTime timestamp) {
}