package com.airbooking.ui.models.response;

public class ErrorMessage {
    private String error;
    private String message;
    private String details;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ErrorMessage(String error, String message, String details, String path) {
        this.error = error;
        this.message = message;
        this.details = details;
        this.path = path;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
