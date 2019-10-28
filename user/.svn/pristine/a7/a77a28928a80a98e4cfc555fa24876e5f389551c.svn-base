package com.woniu.movie.service;

import com.woniu.movie.pojo.MovieTicket;
import com.woniu.movie.vo.MovieTicketQueryVo;
import com.woniu.movie.vo.MovieTicketVo;

import java.util.List;

public interface IMovieTicketService {


    int removeMovieTicketByMovieTicketId(Integer movieTicketId);

    int add(MovieTicket record);

    int addSelective(MovieTicket record);

    MovieTicket findMovieTicketByMovieTicketId(Integer movieTicketId);

    int modifyMovieTicketByMovieTicketIdSelective(MovieTicket record);

    int modifyMovieTicketByMovieTicketId(MovieTicket record);

    List<MovieTicketVo> findMovieTicketVoByMovieTicketQueryVo(MovieTicketQueryVo movieTicketQueryVo);

    List<MovieTicket> findUntouchableMovieTicketByMovieTicketIds(List<Integer> movieTicketIds);

}
