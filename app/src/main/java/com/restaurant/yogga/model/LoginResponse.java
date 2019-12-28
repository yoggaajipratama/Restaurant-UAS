package com.restaurant.yogga.model;

import com.google.gson.annotations.Expose;

public class LoginResponse {
    @Expose
    private Login login;
    @Expose
    private String message;
    @Expose
    private String status;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
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