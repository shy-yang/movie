package com.woniu.movie.mapper;

import com.woniu.movie.pojo.MovieTicket;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieTicketMapper {
    int deleteByPrimaryKey(Integer movieTicketId);

    int insert(MovieTicket record);

    int insertSelective(MovieTicket record);

    MovieTicket selectByPrimaryKey(Integer movieTicketId);

    int updateByPrimaryKeySelective(MovieTicket record);

    int updateByPrimaryKey(MovieTicket record);
    //根据排片id删除电影票
    int deleteMovieTicketByMovieScheduleId(Integer movieScheduleId);

    int insertMovieTickets(@Param("movieTickets") List<MovieTicket> movieTickets);

    int deleteMovieTicketByMovieScheduleIds(@Param("list") String[] str);
}