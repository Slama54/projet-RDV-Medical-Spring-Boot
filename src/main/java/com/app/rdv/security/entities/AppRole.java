package com.app.rdv.security.entities;

import jakarta.persistence.*;

@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String role;

    // Constructeur par défaut (nécessaire pour JPA)
    public AppRole() {}

    // Constructeur avec paramètres
    public AppRole(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}