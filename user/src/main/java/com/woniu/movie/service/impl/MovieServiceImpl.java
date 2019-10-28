package com.woniu.movie.service.impl;

import com.woniu.movie.vo.MovieQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.pojo.Movie;
import com.woniu.movie.mapper.MovieMapper;
import com.woniu.movie.service.IMovieService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements IMovieService {

    @Resource
    private MovieMapper movieMapper;

    @Override
    public int deleteByPrimaryKey(Integer movieId) {
        return movieMapper.removeMovieByMovieId(movieId);
    }

    @Override
    public int insert(Movie record) {
        return movieMapper.add(record);
    }

    @Override
    public int insertSelective(Movie record) {
        return movieMapper.addSelective(record);
    }

    @Override
    public Movie selectByPrimaryKey(Integer movieId) {
        return movieMapper.findMovieByMovieId(movieId);
    }

    @Override
    public int updateByPrimaryKeySelective(Movie record) {
        return movieMapper.modifyMovieByMovieIdSelective(record);
    }

    @Override
    public int updateByPrimaryKey(Movie record) {
        return movieMapper.modifyMovieByMovieId(record);
    }

    @Override
    public List<Movie> findAllMovieByFilmQueryVo(MovieQueryVo queryVo) {
        return movieMapper.selectAllMovieByMovieQueryVo(queryVo);
    }

    @Override
    public List<String> findAllMovieLevels() {
        return movieMapper.selectAllMovieLevels();
    }

    @Override
    public List<String> findAllMovieCounties() {
        return movieMapper.selectAllMovieCountries();
    }

    @Override
    public List<String> findALlMovieDecade() {
        return movieMapper.selectAllMovieDecade();
    }

}
