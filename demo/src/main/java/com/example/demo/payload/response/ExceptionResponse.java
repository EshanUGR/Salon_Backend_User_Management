package com.example.demo.payload.response;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    // Add this constructor
    public ExceptionResponse(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    // Getters (required for JSON serialization)
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}