package com.woniu.movie.service;

import com.woniu.movie.pojo.Comment;
import com.woniu.movie.vo.CommentQueryVo;
import com.woniu.movie.vo.CommentVo;

import java.util.List;

public interface ICommentService {


    int removeCommentByCommentId(Integer commentId);

    int add(Comment record);

    int addSelective(Comment record);

    Comment findCommentByCommentId(Integer commentId);

    int modifyCommentByCommentIdSelective(Comment record);

    int modifyCommentByCommentId(Comment record);

    List<CommentVo> findAllCommentVoByCommentQueryVo(CommentQueryVo commentQueryVo);

}
