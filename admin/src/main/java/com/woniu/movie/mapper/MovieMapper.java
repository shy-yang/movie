package com.woniu.movie.mapper;

import com.woniu.movie.pojo.Movie;
import com.woniu.movie.vo.FilmQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {
    int removeMovieByMovieId(Integer movieId);

    int add(Movie record);

    int addSelective(Movie record);

    Movie findMovieByMovieId(Integer movieId);

    int modifyMovieByMovieIdSelective(Movie record);

    int modifyMovieByMovieId(Movie record);

    List<Movie> selectAllMovie(@Param("qv") FilmQueryVo queryVo);

    int removeMovieByArray(Integer[] movieIds);

    int updateMovieStates(@Param("movies") List<Movie> movies);
}
