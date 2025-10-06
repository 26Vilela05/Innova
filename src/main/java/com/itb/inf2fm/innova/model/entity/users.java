package com.itb.inf2fm.innova.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (length = 100, nullable = false )
    private String nome;
    @Column (length = 255, nullable = false)
    private String email;
    @Column (length = 255, nullable = false)
    private String passaword_hash;
    @Column (nullable = false)
    private LocalDateTime created_at;
    @Column (nullable = true)
    private LocalDateTime updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassaword_hash() {
        return passaword_hash;
    }

    public void setPassaword_hash(String passaword_hash) {
        this.passaword_hash = passaword_hash;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
