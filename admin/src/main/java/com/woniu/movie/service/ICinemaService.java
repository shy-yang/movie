package com.woniu.movie.service;

import com.woniu.movie.pojo.Cinema;

public interface ICinemaService {

    int removeCinemaByCinemaId(Integer cinemaId);

    int add(Cinema record);

    int addSelective(Cinema record);

    Cinema findCinemaByCinemaIdKey(Integer cinemaId);

    int modifyCinemaByCinemaIdSelective(Cinema record);

    int modifyCinemaByCinemaId(Cinema record);

}
