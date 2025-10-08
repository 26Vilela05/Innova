package com.itb.inf2fm.innova.model.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "coupons")
public class coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long store_id;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private Double discount;

    @Column(length = 255, nullable = true)
    private String affiliate_link;

    @Column(length = 255, nullable = true)
    private String image_url;

    @Column(nullable = false)
    private LocalDateTime valid_from;

    @Column(nullable = false)
    private LocalDateTime valid_until;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = true)
    private LocalDateTime updated_at;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getAffiliate_link() {
        return affiliate_link;
    }

    public void setAffiliate_link(String affiliate_link) {
        this.affiliate_link = affiliate_link;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public LocalDateTime getValid_from() {
        return valid_from;
    }

    public void setValid_from(LocalDateTime valid_from) {
        this.valid_from = valid_from;
    }

    public LocalDateTime getValid_until() {
        return valid_until;
    }

    public void setValid_until(LocalDateTime valid_until) {
        this.valid_until = valid_until;
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