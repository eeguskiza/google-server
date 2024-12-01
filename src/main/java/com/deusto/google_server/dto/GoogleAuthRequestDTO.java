package com.deusto.google_server.dto;

public class GoogleAuthRequestDTO {
    private String email;
    private String password;

    public GoogleAuthRequestDTO() {
    }

    public GoogleAuthRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

