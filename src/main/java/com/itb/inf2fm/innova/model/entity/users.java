package com.itb.inf2fm.innova.model.entity;

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
    @Column (LocalDateTime = )
    private LocalDateTime created_at;
    private DateTime updated_at;


}
