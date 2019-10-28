package com.woniu.movie.service;

import com.woniu.movie.pojo.Order;

public interface IOrderService {


    int removeOrderByOrderId(Integer orderId);

    int add(Order record);

    int addSelective(Order record);

    Order findOrderByOrderId(Integer orderId);

    int modifyOrderByOrderIdSelective(Order record);

    int modifyOrderByOrderId(Order record);

    //每一张电影票对应一个订单id,所以查询订单票数，在tickect表上查询！
    int findTicketsByOrderId(Integer orderId);

}
