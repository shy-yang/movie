package com.woniu.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.CinemaMapper;
import com.woniu.movie.pojo.Cinema;
import com.woniu.movie.service.ICinemaService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CinemaServiceImpl implements ICinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public int removeCinemaByCinemaId(Integer cinemaId) {
        return cinemaMapper.deleteByCinemaId(cinemaId);
    }

    @Override
    public int add(Cinema record) {
        return cinemaMapper.insert(record);
    }

    @Override
    public int addSelective(Cinema record) {
        return cinemaMapper.insertSelective(record);
    }

    @Override
    public Cinema findCinemaByCinemaIdKey(Integer cinemaId) {
        return cinemaMapper.selectByCinemaId(cinemaId);
    }

    @Override
    public int modifyCinemaByCinemaIdSelective(Cinema record) {
        return cinemaMapper.updateByCinemaIdSelective(record);
    }

    @Override
    public int modifyCinemaByCinemaId(Cinema record) {
        return cinemaMapper.updateByCinemaId(record);
    }

}
