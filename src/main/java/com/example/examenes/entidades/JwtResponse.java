package com.example.examenes.entidades;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = token;
    }
}
