package com.woniu.movie.service;

import com.woniu.movie.pojo.MovieSchedule;
import com.woniu.movie.vo.MovieScheduleQueryVo;

import java.util.List;

public interface IMovieScheduleService {


    int removeMovieScheduleByMovieScheduleId(Integer movieScheduleId);

    int removeMovieSchedules(String[] str);

    int add(MovieSchedule record);

    int addSelective(MovieSchedule record);

    MovieScheduleQueryVo findMovieScheduleByMovieScheduleId(Integer movieScheduleId);

    int modifyMovieScheduleByMovieScheduleIdSelective(MovieSchedule record);

    int modifyMovieScheduleByMovieScheduleId(MovieSchedule record);

    List<MovieScheduleQueryVo> findAllMovieSchedule(MovieScheduleQueryVo queryVo);

    List<MovieScheduleQueryVo> findMovieChecked(MovieSchedule queryVo);
}
