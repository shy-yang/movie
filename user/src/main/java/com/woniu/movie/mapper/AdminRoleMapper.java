package com.woniu.movie.mapper;

import com.woniu.movie.pojo.AdminRole;

public interface AdminRoleMapper {
    int insert(AdminRole record);

    int insertSelective(AdminRole record);
}