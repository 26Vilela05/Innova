package com.itb.inf2fm.innova.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "coupon_redemptions")
public class coupon_redemptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long coupon_id;
    @Column(nullable = false)
    private Long users_id;
    @Column(nullable = false)
    private LocalDateTime redeemed_at;

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

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

    public LocalDateTime getRedeemed_at() {
        return redeemed_at;
    }

    public void setRedeemed_at(LocalDateTime redeemed_at) {
        this.redeemed_at = redeemed_at;
    }
}
