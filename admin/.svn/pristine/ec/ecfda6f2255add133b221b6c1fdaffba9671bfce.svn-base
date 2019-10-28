package com.woniu.movie.service;

import com.woniu.movie.pojo.Seat;
import com.woniu.movie.vo.SeatQueryVo;

import java.util.List;

public interface ISeatService {


    int removeSeatBySeatId(Integer seatId);

    int add(Seat record);

    int addSelective(Seat record);

    Seat findSeatBySeatId(Integer seatId);

    int modifySeatBySeatIdSelective(Seat record);

    int modifySeatBySeatId(Seat record);

    int modifySeatByShowHallId(Integer showHallId, List<Seat> seatList);

    List<Seat> findSeatByQueryVo(SeatQueryVo seatQueryVo);
}
