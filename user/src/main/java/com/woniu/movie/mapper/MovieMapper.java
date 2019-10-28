package com.woniu.movie.mapper;

import com.woniu.movie.pojo.Movie;
import com.woniu.movie.vo.MovieQueryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MovieMapper {
    int removeMovieByMovieId(Integer movieId);

    int add(Movie record);

    int addSelective(Movie record);

    Movie findMovieByMovieId(Integer movieId);

    int modifyMovieByMovieIdSelective(Movie record);

    int modifyMovieByMovieId(Movie record);

    List<Movie> selectAllMovieByMovieQueryVo(@Param("qv") MovieQueryVo queryVo);

    List<String> selectAllMovieLevels();

    List<String> selectAllMovieCountries();

    List<String> selectAllMovieDecade();
}
