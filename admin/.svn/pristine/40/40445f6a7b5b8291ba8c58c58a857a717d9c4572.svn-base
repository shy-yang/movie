package com.woniu.movie.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CouponQueryVo {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date couponStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date couponEndTime;
    private Integer couponId;
    private BigDecimal couponBenefitPrice;
    private String couponState;
    private Integer page;
    private Integer pageSize;
}
