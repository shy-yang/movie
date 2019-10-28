package com.woniu.movie.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.SeatMapper;
import com.woniu.movie.pojo.Seat;
import com.woniu.movie.service.ISeatService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SeatServiceImpl implements ISeatService {

    @Resource
    private SeatMapper seatMapper;

    @Override
    public int removeSeatBySeatId(Integer seatId) {
        return seatMapper.deleteByPrimaryKey(seatId);
    }

    @Override
    public int add(Seat record) {
        return seatMapper.insert(record);
    }

    @Override
    public int addSelective(Seat record) {
        return seatMapper.insertSelective(record);
    }

    @Override
    public Seat findSeatBySeatId(Integer seatId) {
        return seatMapper.selectByPrimaryKey(seatId);
    }

    @Override
    public int modifySeatBySeatIdSelective(Seat record) {
        return seatMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifySeatBySeatId(Seat record) {
        return seatMapper.updateByPrimaryKey(record);
    }

}
