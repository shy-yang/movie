package com.woniu.movie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.woniu.movie.vo.MovieTicketVo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
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
    private BigDecimal totalPrice;

    /**
     * 订单座位集合
     */
    private List<Seat> seats;
    /**
     * 订单影票电影信息
     */
    private Movie movie;

    /**
     * 订单影票数量
     */
    private Integer ticketNum;

    /**
     * 订单影院地址
     */
    private String showSite;

    /**
     * 订单的影厅名
     */

    private String showHall;
    public Order(Integer userId, String orderNumber, Date orderCreateTime, BigDecimal totalPrice) {
        this.userId = userId;
        this.orderNumber = orderNumber;
        this.orderCreateTime = orderCreateTime;
        this.totalPrice = totalPrice;
    }

    private static final long serialVersionUID = 1L;
}
