package com.woniu.movie.mapper;

import com.woniu.movie.pojo.MovieSchedule;
import com.woniu.movie.vo.MovieScheduleQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieScheduleMapper {
    int deleteByPrimaryKey(Integer movieScheduleId);

    int deleteByPrimaryKeys(String[] str);

    int insert(MovieSchedule record);

    int insertSelective(MovieSchedule record);

    MovieScheduleQueryVo selectByPrimaryKey(Integer movieScheduleId);

    int updateByPrimaryKeySelective(MovieSchedule record);

    int updateByPrimaryKey(MovieSchedule record);

    List<MovieScheduleQueryVo> selectAllMovieSchedule(@Param("qv") MovieScheduleQueryVo queryVo);

    List<MovieScheduleQueryVo> selectMovieChecked(@Param("qv") MovieSchedule queryVo);
}