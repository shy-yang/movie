package com.woniu.movie.service;

import com.woniu.movie.pojo.UserCoupon;

public interface IUserCouponService {


    int removeUserCouponByUserCouponId(Integer userCouponId);

    int add(UserCoupon record);

    int addSelective(UserCoupon record);

    UserCoupon findUserCouponByUserCouponId(Integer userCouponId);

    int modifyUserCouponByUserCouponIdSelective(UserCoupon record);

    int modifyUserCouponByUserCouponId(UserCoupon record);

}
