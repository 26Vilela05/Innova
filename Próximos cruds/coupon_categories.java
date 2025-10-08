package com.itb.inf2fm.innova.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coupon_categories")
public class coupon_categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long coupon_id;
    @Column(nullable = false)
    private Long category_id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoupon_id() {
        return coupon_id;
    }
    public void setCoupon_id(Long coupon_id) {
        this.coupon_id = coupon_id;
    }
    
    public Long getCategory_id() {
        return category_id;
    }
    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }


}
