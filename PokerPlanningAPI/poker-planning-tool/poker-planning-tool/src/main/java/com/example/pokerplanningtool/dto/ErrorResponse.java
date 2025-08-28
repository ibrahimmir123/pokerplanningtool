package com.example.pokerplanningtool.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ErrorResponse {
    private UUID errorId;
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(UUID errorId, LocalDateTime timestamp, int status, String error, String message) {
        this.errorId = errorId;
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public UUID getErrorId() {
        return errorId;
    }

    public void setErrorId(UUID errorId) {
        this.errorId = errorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
