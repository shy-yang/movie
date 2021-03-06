package com.woniu.movie.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.PermissionMapper;
import com.woniu.movie.pojo.Permission;
import com.woniu.movie.service.IPermissionService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public int removePermissionByPermissionId(Integer permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId);
    }

    @Override
    public int add(Permission record) {
        return permissionMapper.insert(record);
    }

    @Override
    public int addSelective(Permission record) {
        return permissionMapper.insertSelective(record);
    }

    @Override
    public Permission findPermissionByPermissionId(Integer permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    @Override
    public int modifyPermissionByPermissionIdSelective(Permission record) {
        return permissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyPermissionByPermissionId(Permission record) {
        return permissionMapper.updateByPrimaryKey(record);
    }

}
