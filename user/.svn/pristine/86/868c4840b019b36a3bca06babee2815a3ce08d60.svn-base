package com.woniu.movie.service.impl;

import com.woniu.movie.pojo.Order;
import com.woniu.movie.util.UserUtil;
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
    public List<User> findAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    @Override
    public int modifyUserByOrderNumberSelective(Order order) {
        User user = userMapper.selectUserByOrderNumber(order.getOrderNumber());
        user.setUserScoreActive(user.getUserScoreActive() + order.getTotalPrice().intValue());
        user.setUserScoreSum(user.getUserScoreSum() + order.getTotalPrice().intValue());
        //将需要改变的数据放在新的User实例中
        User update = new User(user.getUserId(), user.getUserScoreActive(), user.getUserScoreSum(), UserUtil.getLevelByUserScoreSum(user.getUserScoreSum()));
        return userMapper.updateByPrimaryKeySelective(update);
    }
}
