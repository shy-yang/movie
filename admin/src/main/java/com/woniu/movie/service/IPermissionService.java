package com.woniu.movie.service;

import com.woniu.movie.pojo.Permission;

public interface IPermissionService {


    int removePermissionByPermissionId(Integer permissionId);

    int add(Permission record);

    int addSelective(Permission record);

    Permission findPermissionByPermissionId(Integer permissionId);

    int modifyPermissionByPermissionIdSelective(Permission record);

    int modifyPermissionByPermissionId(Permission record);

}
