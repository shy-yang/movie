package com.woniu.movie.mapper;

import com.woniu.movie.pojo.User;
import com.woniu.movie.vo.UserQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUserByUserQueryVo(@Param("vo")UserQueryVo vo);

    int updateByArray(String[] strings);
}
