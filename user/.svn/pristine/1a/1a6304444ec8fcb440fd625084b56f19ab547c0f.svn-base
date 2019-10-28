package com.woniu.movie.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.AdminRoleMapper;
import com.woniu.movie.pojo.AdminRole;
import com.woniu.movie.service.IAdminRoleService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminRoleServiceImpl implements IAdminRoleService {

    @Resource
    private AdminRoleMapper adminRoleMapper;

    @Override
    public int add(AdminRole record) {
        return adminRoleMapper.insert(record);
    }

    @Override
    public int addSelective(AdminRole record) {
        return adminRoleMapper.insertSelective(record);
    }

}
