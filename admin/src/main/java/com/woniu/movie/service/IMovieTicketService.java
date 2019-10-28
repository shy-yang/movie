package com.woniu.movie.service;

import com.woniu.movie.pojo.MovieTicket;

import java.util.List;

public interface IMovieTicketService {


    int removeMovieTicketByMovieTicketId(Integer movieTicketId);

    int add(MovieTicket record);

    int addSelective(MovieTicket record);

    MovieTicket findMovieTicketByMovieTicketId(Integer movieTicketId);

    int modifyMovieTicketByMovieTicketIdSelective(MovieTicket record);

    int modifyMovieTicketByMovieTicketId(MovieTicket record);

    int removeMovieTicketByMovieScheduleId(Integer movieScheduleId);

    int addMovieTickets(List<MovieTicket> movieTickets);

    int removeMovieTicketByMovieScheduleIds(String[] str);
}
