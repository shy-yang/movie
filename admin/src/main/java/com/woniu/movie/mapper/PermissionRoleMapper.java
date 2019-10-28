package com.woniu.movie.mapper;

import com.woniu.movie.pojo.PermissionRole;

public interface PermissionRoleMapper {
    int insert(PermissionRole record);

    int insertSelective(PermissionRole record);
}