package com.woniu.movie.mapper;

import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.vo.ShowHallQueryVo;
import com.woniu.movie.vo.ShowHallVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowHallMapper {
    int deleteByPrimaryKey(Integer showHallId);

    int insert(ShowHall record);

    int insertSelective(ShowHall record);

    ShowHall selectByPrimaryKey(Integer showHallId);

    int updateByPrimaryKeySelective(ShowHall record);

    int updateByPrimaryKey(ShowHall record);

    List<ShowHall> selectAllByShowSiteId(@Param("qv") ShowHallQueryVo queryVo);

    int updateShowHallSeatCountByShowHallId(@Param("showHalId") Integer showHalId, @Param("seatCount") Integer seatCount);

    List<ShowHallVo> selectShowHallVosByShowHallQueryVo(@Param("sqv") ShowHallQueryVo showHallQueryVo);

    int batchUpdateShowHallStateByShowHallIds(@Param("showHallIds") String[] showHallIds, @Param("showHallState") String showHallState);
}