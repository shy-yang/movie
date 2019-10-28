package com.woniu.movie.service.impl;

import com.woniu.movie.vo.UserQueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.UserMapper;
import com.woniu.movie.pojo.User;
import com.woniu.movie.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int removeUserByUserId(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int add(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int addSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int modifyUserByUserIdSelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyUserByUserId(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> findAllUser(UserQueryVo vo) {
        return userMapper.selectAllUserByUserQueryVo(vo);
    }

    @Override
    public int updateUserStateById(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int updateUserStateByArray(String[] strings) {
        return userMapper.updateByArray(strings);
    }

}
