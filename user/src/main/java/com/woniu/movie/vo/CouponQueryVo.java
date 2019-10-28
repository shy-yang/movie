package com.woniu.movie.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CouponQueryVo {
    private Integer couponId;
    private BigDecimal couponBenefitPrice;
    private String couponState;
    private Integer page;
    private Integer pageSize;
}
