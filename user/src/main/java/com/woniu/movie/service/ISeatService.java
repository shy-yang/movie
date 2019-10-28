package com.woniu.movie.service;

import com.woniu.movie.pojo.Seat;

public interface ISeatService {


    int removeSeatBySeatId(Integer seatId);

    int add(Seat record);

    int addSelective(Seat record);

    Seat findSeatBySeatId(Integer seatId);

    int modifySeatBySeatIdSelective(Seat record);

    int modifySeatBySeatId(Seat record);

}
