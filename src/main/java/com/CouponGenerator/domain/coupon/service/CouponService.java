package com.CouponGenerator.domain.coupon.service;

import com.CouponGenerator.domain.coupon.entity.Coupon;

public interface CouponService {
    Coupon generateCoupon(String phoneNumber);
}
