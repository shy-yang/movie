package com.woniu.movie.controller;

import com.woniu.movie.pojo.Comment;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author justin
 * @create 2019/10/24
 * @since 1.0.0
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public ResponseResult addComment(Comment comment) {
        comment.setCommentState(0);
        Integer i = 1;
        i = commentService.addSelective(comment);
        if (i == 1) {
            return new ResponseResult("200", "评论成功，等待管理员审核");
        } else {
            return new ResponseResult("400", "评论失败");
        }

    }
}
