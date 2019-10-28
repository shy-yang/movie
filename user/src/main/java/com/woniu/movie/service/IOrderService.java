package com.woniu.movie.service;

import com.woniu.movie.pojo.Order;

import java.util.Date;
import java.util.List;

public interface IOrderService {


    int removeOrderByOrderId(Integer orderId);

    int add(Order record);

    int addSelective(Order record);

    Order findOrderByOrderId(Integer orderId);

    int modifyOrderByOrderIdSelective(Order record);

    int modifyOrderByOrderId(Order record);

    int createOrderByTicketsAndUserId(List<Integer> tickets, Integer userId, Date createTime);

    //每一张电影票对应一个订单id,所以查询订单票数，在ticket表上查询！
    int findTicketsByOrderId(Integer orderId);

    int modifyOrderByOrderNumberSelective(Order order);

    List<Order> findOrderByUserId(Integer userId);
}
