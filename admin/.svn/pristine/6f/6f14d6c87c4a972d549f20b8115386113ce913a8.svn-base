package com.woniu.movie.service;

import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.vo.ShowHallQueryVo;
import com.woniu.movie.vo.ShowHallVo;

import java.util.List;

public interface IShowHallService {


    int removeShowHallByShowHallId(Integer showHallId);

    int add(ShowHall record);

    int addSelective(ShowHall record);

    ShowHall findShowHallByShowHallId(Integer showHallId);

    int modifyShowHallByShowHallIdSelective(ShowHall record);

    int modifyShowHallByShowHallId(ShowHall record);

    List<ShowHall> findAllByShowSiteId(ShowHallQueryVo queryVo);

    List<ShowHallVo> findShowHallVosByShowHallQueryVo(ShowHallQueryVo showHallQueryVo);

    int batchModifyShowHallStateByShowHallIds(String[] showHallIds, String showHallState);
}
