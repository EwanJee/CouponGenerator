package com.CouponGenerator.domain.coupon.service.impl;

import com.CouponGenerator.domain.coupon.entity.Coupon;
import com.CouponGenerator.domain.phone.entity.Phone;
import com.CouponGenerator.domain.coupon.repository.CouponRepository;
import com.CouponGenerator.domain.coupon.repository.PhoneRepository;
import com.CouponGenerator.domain.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Transactional(readOnly = true)
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final PhoneRepository phoneNumberRepository;
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository, PhoneRepository phoneNumberRepository){
        this.couponRepository = couponRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    @Transactional
    public Coupon generateCoupon(String phoneNumber) {

        if (phoneNumberRepository.findById(phoneNumber).isPresent()) {
            return null;
        }

        StringBuilder couponNumber = new StringBuilder();
        Random random = new Random();

        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        couponNumber.append("-");

        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        couponNumber.append("-");

        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        couponNumber.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        phoneNumberRepository.save(Phone.builder()
                    .number(phoneNumber)
                    .build());
        return couponRepository.save(Coupon.builder()
                    .couponNumber(couponNumber.toString())
                    .isUsed(false)
                    .createdDate(LocalDateTime.now())
                    .expirationDate(LocalDateTime.now().plusDays(30))
                    .build());
    }
}
