package com.woniu.movie.service.impl;

import com.woniu.movie.vo.CouponQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.CouponMapper;
import com.woniu.movie.pojo.Coupon;
import com.woniu.movie.service.ICouponService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CouponServiceImpl implements ICouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public int removeCouponByCouponId(Integer couponId) {
        return couponMapper.deleteByPrimaryKey(couponId);
    }

    @Override
    public int add(Coupon record) {
        return couponMapper.insert(record);
    }

    @Override
    public int addSelective(Coupon record) {
        return couponMapper.insertSelective(record);
    }

    @Override
    public Coupon findCouponByCouponId(Integer couponId) {
        return couponMapper.selectByPrimaryKey(couponId);
    }

    @Override
    public int modifyCouponByCouponIdSelective(Coupon record) {
        return couponMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyCouponByCouponId(Coupon record) {
        return couponMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据条件查询优惠券
     *
     * @param couponQueryVo 优惠券的查询条件
     */
    @Override
    public List<Coupon> findAllCouponByCouponQueryVo(CouponQueryVo couponQueryVo) {
        return couponMapper.selectAllCouponByCouponQueryVo(couponQueryVo);
    }

    /**
     * 批量设置优惠券状态
     *
     * @param couponState 优惠券状态
     * @param couponIds   优惠券id
     */
    @Override
    public int batchModifyCouponStateByCouponIds(String[] couponIds, String couponState) {
        return couponMapper.batchUpdateCouponStateByCouponIds(couponIds, couponState);
    }

}
