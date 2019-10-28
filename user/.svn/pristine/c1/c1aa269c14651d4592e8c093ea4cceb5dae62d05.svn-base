package com.woniu.movie.service;

import com.woniu.movie.pojo.Coupon;
import com.woniu.movie.vo.CouponQueryVo;

import java.util.List;

public interface ICouponService {


    int removeCouponByCouponId(Integer couponId);

    int add(Coupon record);

    int addSelective(Coupon record);

    Coupon findCouponByCouponId(Integer couponId);

    int modifyCouponByCouponIdSelective(Coupon record);

    int modifyCouponByCouponId(Coupon record);

    List<Coupon> findAllCouponByCouponQueryVo(CouponQueryVo couponQueryVo);

    int batchModifyCouponStateByCouponIds(String[] couponIds, String couponState);

}
