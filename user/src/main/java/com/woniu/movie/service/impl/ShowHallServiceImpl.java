package com.woniu.movie.service.impl;

import com.woniu.movie.vo.ShowHallQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.mapper.ShowHallMapper;
import com.woniu.movie.service.IShowHallService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShowHallServiceImpl implements IShowHallService {

    @Resource
    private ShowHallMapper showHallMapper;

    @Override
    public int removeShowHallByShowHallId(Integer showHallId) {
        return showHallMapper.deleteByPrimaryKey(showHallId);
    }

    @Override
    public int add(ShowHall record) {
        return showHallMapper.insert(record);
    }

    @Override
    public int addSelective(ShowHall record) {
        return showHallMapper.insertSelective(record);
    }

    @Override
    public ShowHall findShowHallByShowHallId(Integer showHallId) {
        return showHallMapper.selectByPrimaryKey(showHallId);
    }

    @Override
    public int modifyShowHallByShowHallIdSelective(ShowHall record) {
        return showHallMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyShowHallByShowHallId(ShowHall record) {
        return showHallMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ShowHall> findAll(ShowHallQueryVo queryVo) {
        return showHallMapper.selectAll(queryVo);
    }

}
