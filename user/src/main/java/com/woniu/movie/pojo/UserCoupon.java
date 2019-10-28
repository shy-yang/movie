package com.woniu.movie.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserCoupon implements Serializable {
    /**
     * 用户优惠券id
     */
    private Integer userCouponId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 优惠券领取时间
     */
    private Date couponGetTime;

    /**
     * 优惠券状态
     */
    private String couponState;

    private static final long serialVersionUID = 1L;
}