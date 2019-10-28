package com.woniu.movie.service.impl;

import com.woniu.movie.vo.CommentQueryVo;
import com.woniu.movie.vo.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.woniu.movie.mapper.CommentMapper;
import com.woniu.movie.pojo.Comment;
import com.woniu.movie.service.ICommentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int removeCommentByCommentId(Integer commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public int add(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int addSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public Comment findCommentByCommentId(Integer commentId) {
        return commentMapper.selectByPrimaryKey(commentId);
    }

    @Override
    public int modifyCommentByCommentIdSelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int modifyCommentByCommentId(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CommentVo> findAllCommentVoByCommentQueryVo(CommentQueryVo commentQueryVo) {
        return commentMapper.selectCommentVoByCommentQueryVo(commentQueryVo);
    }

}
