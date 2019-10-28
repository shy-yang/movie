package com.woniu.movie.service;

import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.vo.ShowHallQueryVo;

import java.util.List;

public interface IShowHallService {


    int removeShowHallByShowHallId(Integer showHallId);

    int add(ShowHall record);

    int addSelective(ShowHall record);

    ShowHall findShowHallByShowHallId(Integer showHallId);

    int modifyShowHallByShowHallIdSelective(ShowHall record);

    int modifyShowHallByShowHallId(ShowHall record);

    List<ShowHall> findAll(ShowHallQueryVo queryVo);

}
