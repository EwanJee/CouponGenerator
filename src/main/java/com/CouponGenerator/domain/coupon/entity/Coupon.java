package com.CouponGenerator.domain.coupon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "COUPON")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {

    @Column(name = "COUPON_NUMBER")
    @Pattern(regexp = "^[0-9A-Za-z]{4}-[0-9A-Za-z]{4}-[0-9A-Za-z]{4}$")
    @Id
    private String couponNumber;

    @Column(name = "EXPIRATION_DATE")
    private LocalDateTime expirationDate;
    @CreatedDate
    @Column(name = "CREATED_DATE", updatable = false)
    private LocalDateTime createdDate;
    @Column(name = "USED")
    private boolean isUsed;

}
