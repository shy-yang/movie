package com.woniu.movie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;

@Data
public class Coupon implements Serializable {
    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 优惠金额
     */
    @DecimalMin("0.01")
    private BigDecimal couponBenefitPrice;

    /**
     * 优惠券开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date couponStartTime;

    /**
     * 优惠券过期时间
     */
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date couponEndTime;

    /**
     * 优惠券状态
     */
    private String couponState;

    private static final long serialVersionUID = 1L;
}