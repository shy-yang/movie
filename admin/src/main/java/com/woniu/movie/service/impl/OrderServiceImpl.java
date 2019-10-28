package com.woniu.movie.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.pojo.Order;
import com.woniu.movie.mapper.OrderMapper;
import com.woniu.movie.service.IOrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

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
    public int findTicketsByOrderId(Integer orderId) {
        return orderMapper.findByPrimaryKeyT(orderId);
    }

}
