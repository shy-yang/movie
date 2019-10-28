package com.woniu.movie.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.RoleMapper;
import com.woniu.movie.pojo.Role;
import com.woniu.movie.service.IRoleService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int removeRoleByRoleId(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int add(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int addSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role findRoleByRoleId(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int modifyRoleByRoleIdSelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyRoleByRoleId(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

}
