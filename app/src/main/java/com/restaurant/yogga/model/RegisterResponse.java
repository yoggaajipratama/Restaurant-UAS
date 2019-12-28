package com.restaurant.yogga.model;

import com.google.gson.annotations.Expose;

public class RegisterResponse {
    @Expose
    private String data;
    @Expose
    private String message;
    @Expose
    private String status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}