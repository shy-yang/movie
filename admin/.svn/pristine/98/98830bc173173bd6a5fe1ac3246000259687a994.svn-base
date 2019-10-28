package com.woniu.movie.service;

import com.woniu.movie.pojo.User;
import com.woniu.movie.vo.UserQueryVo;

import java.util.List;

public interface IUserService {


    int removeUserByUserId(Integer userId);

    int add(User record);

    int addSelective(User record);

    User findUserByUserId(Integer userId);

    int modifyUserByUserIdSelective(User record);

    int modifyUserByUserId(User record);

    List<User> findAllUser(UserQueryVo vo);

    int updateUserStateById(User user);

    int updateUserStateByArray(String[] strings);

}
