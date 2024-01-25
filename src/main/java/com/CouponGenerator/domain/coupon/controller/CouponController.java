package com.CouponGenerator.domain.coupon.controller;

import com.CouponGenerator.domain.coupon.entity.Coupon;
import com.CouponGenerator.domain.phone.entity.Phone;
import com.CouponGenerator.domain.coupon.service.CouponService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Coupon> generateCoupon(@Valid @RequestBody String phoneNumber, BindingResult result){
        if(result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Coupon coupon = couponService.generateCoupon(phoneNumber);
        if (coupon == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(coupon);
    }
}
