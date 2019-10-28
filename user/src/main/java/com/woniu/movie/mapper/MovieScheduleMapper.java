package com.woniu.movie.mapper;

import com.woniu.movie.pojo.MovieSchedule;
import com.woniu.movie.vo.MovieScheduleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieScheduleMapper {
    int deleteByPrimaryKey(Integer movieScheduleId);

    int insert(MovieSchedule record);

    int insertSelective(MovieSchedule record);

    MovieSchedule selectByPrimaryKey(Integer movieScheduleId);

    int updateByPrimaryKeySelective(MovieSchedule record);

    int updateByPrimaryKey(MovieSchedule record);

    List<MovieScheduleQueryVo> selectAllMovieSchedule(@Param("qv") MovieScheduleQueryVo queryVo);
}