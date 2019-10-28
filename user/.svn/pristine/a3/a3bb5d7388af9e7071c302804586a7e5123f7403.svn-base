package com.woniu.movie.mapper;

import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.vo.ShowHallQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowHallMapper {
    int deleteByPrimaryKey(Integer showHallId);

    int insert(ShowHall record);

    int insertSelective(ShowHall record);

    ShowHall selectByPrimaryKey(Integer showHallId);

    int updateByPrimaryKeySelective(ShowHall record);

    int updateByPrimaryKey(ShowHall record);

    List<ShowHall> selectAll(@Param("qv") ShowHallQueryVo queryVo);
}