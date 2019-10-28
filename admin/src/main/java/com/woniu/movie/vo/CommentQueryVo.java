package com.woniu.movie.vo;

import lombok.Data;

@Data
public class CommentQueryVo {
    private String movieName;
    private String userName;
    private Integer commentId;
    private Integer movieId;
    private Integer userId;
}
