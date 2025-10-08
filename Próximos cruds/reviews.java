package com.itb.inf2fm.innova.model.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "reviews")
public class reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long users_id;
    @Column(nullable = false)
    private Long store_id;
    private int rating;
    private String comment;
    private LocalDateTime created_at;


}
