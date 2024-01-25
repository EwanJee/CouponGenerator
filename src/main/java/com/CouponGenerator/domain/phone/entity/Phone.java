package com.CouponGenerator.domain.phone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "PHONE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Phone {

    @Id
    @Column(name = "PHONE_NUMBER")
    @Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$")
    private String number;
}
