package com.woniu.movie.service.impl;

import com.woniu.movie.mapper.MovieScheduleMapper;
import com.woniu.movie.mapper.MovieTicketMapper;
import com.woniu.movie.mapper.UserMapper;
import com.woniu.movie.pojo.MovieTicket;
import com.woniu.movie.pojo.User;
import com.woniu.movie.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.movie.pojo.Order;
import com.woniu.movie.mapper.OrderMapper;
import com.woniu.movie.service.IOrderService;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MovieTicketMapper movieTicketMapper;
    @Autowired
    private MovieScheduleMapper movieScheduleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public int removeOrderByOrderId(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int add(Order record) {
        return orderMapper.insert(record);
    }

    @Override
    public int addSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order findOrderByOrderId(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int modifyOrderByOrderIdSelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyOrderByOrderId(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    @Override
    public int createOrderByTicketsAndUserId(List<Integer> tickets, Integer userId, Date createTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNumber = sdf.format(createTime) + userId + "T" + tickets.get(0);
        BigDecimal totalPrice = movieTicketMapper.selectTotalPriceByMovieTicketIds(tickets);
        //插入订单
        Order order = new Order(userId, orderNumber, createTime, totalPrice);
        orderMapper.insertSelective(order);
        Integer orderId = order.getOrderId();
        //设置座位状态为不可选以及所属订单id、用户id
        movieTicketMapper.updateByMovieTicketIdsSelective(tickets, new MovieTicket(userId, orderId, "0"));
        return orderId;
    }

    @Override
    public int findTicketsByOrderId(Integer orderId) {
        return orderMapper.findByPrimaryKeyT(orderId);
    }

    @Override
    public int modifyOrderByOrderNumberSelective(Order order) {
        return orderMapper.updateByOrderNumberSelective(order);
    }

    @Override
    public List<Order> findOrderByUserId(Integer userId) {
        return orderMapper.selectOrderByUserId(userId);
    }

}
