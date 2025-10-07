package com.mycompany.academiaapi.exception;

import java.time.LocalDateTime;

/**
 * Modelo de erro para API.
 * @author wesia
 */
public class ApiError {
    private int status;
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ApiError() {}
    public ApiError(int status, String message) { this.status = status; this.message = message; }

    // getters/setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
