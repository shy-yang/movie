package com.woniu.movie.mapper;

import com.woniu.movie.pojo.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    Admin selectByPrimaryAccount(String adminAccount);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}
