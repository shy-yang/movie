package com.woniu.movie.service;

import com.woniu.movie.pojo.AdminRole;

public interface IAdminRoleService {


    int add(AdminRole record);

    int addSelective(AdminRole record);

}
