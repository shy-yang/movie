package com.woniu.movie.service.impl;

import com.woniu.movie.vo.MovieTicketQueryVo;
import com.woniu.movie.vo.MovieTicketVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.pojo.MovieTicket;
import com.woniu.movie.mapper.MovieTicketMapper;
import com.woniu.movie.service.IMovieTicketService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieTicketServiceImpl implements IMovieTicketService {

    @Resource
    private MovieTicketMapper movieTicketMapper;

    @Override
    public int removeMovieTicketByMovieTicketId(Integer movieTicketId) {
        return movieTicketMapper.deleteByPrimaryKey(movieTicketId);
    }

    @Override
    public int add(MovieTicket record) {
        return movieTicketMapper.insert(record);
    }

    @Override
    public int addSelective(MovieTicket record) {
        return movieTicketMapper.insertSelective(record);
    }

    @Override
    public MovieTicket findMovieTicketByMovieTicketId(Integer movieTicketId) {
        return movieTicketMapper.selectByPrimaryKey(movieTicketId);
    }

    @Override
    public int modifyMovieTicketByMovieTicketIdSelective(MovieTicket record) {
        return movieTicketMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyMovieTicketByMovieTicketId(MovieTicket record) {
        return movieTicketMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MovieTicketVo> findMovieTicketVoByMovieTicketQueryVo(MovieTicketQueryVo movieTicketQueryVo) {
        return movieTicketMapper.selectMovieTicketVoByMovieTicketQueryVo(movieTicketQueryVo);
    }

    @Override
    public List<MovieTicket> findUntouchableMovieTicketByMovieTicketIds(List<Integer> movieTicketIds) {
        return movieTicketMapper.selectUntouchableMovieTicketByMovieTicketIds(movieTicketIds);
    }


}
