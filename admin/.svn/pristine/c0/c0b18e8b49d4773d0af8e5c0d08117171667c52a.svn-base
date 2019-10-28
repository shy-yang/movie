package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.pojo.Coupon;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.ICouponService;
import com.woniu.movie.vo.CouponQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 优惠券管理
 *
 * @author 范崇文
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private ICouponService couponService;

    /**
     * 根据条件分页查询优惠券
     *
     * @param couponQueryVo 优惠券查询条件
     */
    @GetMapping("/list")
    @ResponseBody
    public ResponseResult getCouponList(CouponQueryVo couponQueryVo) {
        //从queryVo中获取页数和单页显示量
        Integer page = couponQueryVo.getPage();
        Integer pageSize = couponQueryVo.getPageSize();
        //如果没有获取到页数相关参数或者页数不合法 就设置为默认值
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<Coupon> coupons = couponService.findAllCouponByCouponQueryVo(couponQueryVo);
        return new ResponseResult("200", "操作成功").add("coupons", new PageInfo<>(coupons));
    }

    /**
     * 添加优惠券
     *
     * @param coupon 从前端接收到的优惠券对象
     * @param errors 数据验证后的错误结果
     */
    @PostMapping("/add")
    @ResponseBody
    public ResponseResult addCoupon(@Validated Coupon coupon, BindingResult errors) {
        if (errors.getErrorCount() > 0) {
            return new ResponseResult("500", "数据有误！");
        }
        couponService.add(coupon);
        return new ResponseResult("200", "添加成功！");
    }

    /**
     * 设置单个优惠券的状态
     *
     * @param couponState 优惠券的状态
     * @param couponId    优惠券的id
     */
    @PostMapping("/setCouponState")
    @ResponseBody
    public ResponseResult setCouponState(String couponState, Integer couponId) {
        Coupon coupon = new Coupon();
        coupon.setCouponId(couponId);
        coupon.setCouponState(couponState);
        int success = couponService.modifyCouponByCouponIdSelective(coupon);
        if (success == 0) {
            return new ResponseResult("400", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }

    /**
     * 批量修改优惠券状态
     *
     * @param couponState 优惠券的状态
     * @param couponIds   优惠券的id
     */
    @PostMapping("/batchSetCouponState")
    @ResponseBody
    public ResponseResult batchSetCouponState(String couponIds, String couponState) {
        int success = couponService.batchModifyCouponStateByCouponIds(couponIds.split(","), couponState);
        if (success == 0) {
            return new ResponseResult("400", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }

    /**
     * 根据id查询优惠券
     *
     * @param couponId 优惠券id
     */
    @GetMapping("/queryByCouponId")
    @ResponseBody
    public ResponseResult queryByCouponId(Integer couponId) {
        Coupon coupon = couponService.findCouponByCouponId(couponId);
        if (coupon == null) {
            return new ResponseResult("404", "未查询到优惠券！");
        }
        return new ResponseResult("200", "查询成功！").add("coupon", coupon);
    }

    /**
     * 根据优惠券id修改整个优惠券
     *
     * @param coupon 接收到的优惠券对象
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseResult updateCouponByCouponBy(Coupon coupon) {
        int success = couponService.modifyCouponByCouponIdSelective(coupon);
        if (success == 0) {
            return new ResponseResult("404", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }

}
