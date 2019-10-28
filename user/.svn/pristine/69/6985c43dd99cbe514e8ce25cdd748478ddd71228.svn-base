package com.woniu.movie.mapper;

import com.woniu.movie.pojo.MovieTicket;
import com.woniu.movie.vo.MovieTicketQueryVo;
import com.woniu.movie.vo.MovieTicketVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MovieTicketMapper {
    int deleteByPrimaryKey(Integer movieTicketId);

    int insert(MovieTicket record);

    int insertSelective(MovieTicket record);

    MovieTicket selectByPrimaryKey(Integer movieTicketId);

    int updateByPrimaryKeySelective(MovieTicket record);

    int updateByPrimaryKey(MovieTicket record);

    List<MovieTicketVo> selectMovieTicketVoByMovieTicketQueryVo(@Param("mtqv") MovieTicketQueryVo movieTicketQueryVo);

    BigDecimal selectMovieTicketPriceByMovieTicketId(Integer movieTicketId);

    BigDecimal selectTotalPriceByMovieTicketIds(@Param("movieTicketIds") List<Integer> movieTicketIds);

    int updateByMovieTicketIdsSelective(@Param("movieTicketIds") List<Integer> tickets, @Param("movieTicket") MovieTicket movieTicket);

    List<MovieTicket> selectUntouchableMovieTicketByMovieTicketIds(@Param("movieTicketIds") List<Integer> movieTicketIds);
}