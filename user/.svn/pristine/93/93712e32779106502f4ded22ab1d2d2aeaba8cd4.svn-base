package com.woniu.movie.service;

import com.woniu.movie.pojo.Movie;
import com.woniu.movie.vo.MovieQueryVo;

import java.util.List;

public interface IMovieService {


    int deleteByPrimaryKey(Integer movieId);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Integer movieId);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    List<Movie> findAllMovieByFilmQueryVo(MovieQueryVo queryVo);

    List<String> findAllMovieLevels();

    List<String> findAllMovieCounties();

    List<String> findALlMovieDecade();
}
