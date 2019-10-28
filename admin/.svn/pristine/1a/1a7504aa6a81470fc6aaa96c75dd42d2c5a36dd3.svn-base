package com.woniu.movie.service.impl;

import com.woniu.movie.vo.MovieScheduleQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.pojo.MovieSchedule;
import com.woniu.movie.mapper.MovieScheduleMapper;
import com.woniu.movie.service.IMovieScheduleService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieScheduleServiceImpl implements IMovieScheduleService {

    @Resource
    private MovieScheduleMapper movieScheduleMapper;

    @Override
    public int removeMovieScheduleByMovieScheduleId(Integer movieScheduleId) {
        return movieScheduleMapper.deleteByPrimaryKey(movieScheduleId);
    }

    @Override
    public int removeMovieSchedules(String[] str) {
        return movieScheduleMapper.deleteByPrimaryKeys(str);
    }

    @Override
    public int add(MovieSchedule record) {
        return movieScheduleMapper.insert(record);
    }

    @Override
    public int addSelective(MovieSchedule record) {
        return movieScheduleMapper.insertSelective(record);
    }

    @Override
    public MovieScheduleQueryVo findMovieScheduleByMovieScheduleId(Integer movieScheduleId) {
        return movieScheduleMapper.selectByPrimaryKey(movieScheduleId);
    }

    @Override
    public int modifyMovieScheduleByMovieScheduleIdSelective(MovieSchedule record) {
        return movieScheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyMovieScheduleByMovieScheduleId(MovieSchedule record) {
        return movieScheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MovieScheduleQueryVo> findAllMovieSchedule(MovieScheduleQueryVo queryVo) {
        return movieScheduleMapper.selectAllMovieSchedule(queryVo);
    }

    @Override
    public List<MovieScheduleQueryVo> findMovieChecked(MovieSchedule queryVo) {
        return movieScheduleMapper.selectMovieChecked(queryVo);
    }

}
