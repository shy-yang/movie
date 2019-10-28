package com.woniu.movie.mapper;

import com.woniu.movie.pojo.Comment;
import com.woniu.movie.vo.CommentQueryVo;
import com.woniu.movie.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<CommentVo> selectCommentVoByCommentQueryVo(@Param("cqv") CommentQueryVo commentQueryVo);
}