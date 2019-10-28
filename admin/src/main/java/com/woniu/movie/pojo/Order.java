package com.woniu.movie.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态
     */
    private String orderState;

    /**
     * 订单创建时间
     */
    private Date orderCreateTime;

    /**
     * 订单金额
     */
    private Long totalPrice;

    private static final long serialVersionUID = 1L;
}