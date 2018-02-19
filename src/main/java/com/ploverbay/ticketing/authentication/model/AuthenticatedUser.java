package com.ploverbay.ticketing.authentication.model;

public class AuthenticatedUser {

    private String email;
    private String token;


    public AuthenticatedUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}