package com.salah.monapp.entity;

public class Identifiant {
    private String username;
    private String password;

    public Identifiant(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Vérification des identifiants
    public boolean verifier(String inputUsername, String inputPassword) {
        return username.equalsIgnoreCase(inputUsername) && password.equals(inputPassword);
    }
}
