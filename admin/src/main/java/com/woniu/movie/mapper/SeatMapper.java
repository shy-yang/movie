package com.woniu.movie.mapper;

import com.woniu.movie.pojo.Seat;
import com.woniu.movie.vo.SeatQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatMapper {
    int deleteByPrimaryKey(Integer seatId);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer seatId);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

    int deleteByShowHallId(Integer showHallId);

    int updateSeatByShowHallId(@Param("showHallId") Integer showHallId, @Param("seatList") List<Seat> seatList);

    List<Seat> selectSeatByQueryVo(@Param("sqv") SeatQueryVo seatQueryVo);
}