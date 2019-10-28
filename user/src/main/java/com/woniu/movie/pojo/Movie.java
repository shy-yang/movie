package com.woniu.movie.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Movie implements Serializable {
    /**
     * 影片id
     */
    private Integer movieId;

    /**
     * 影片名
     */
    private String movieName;

    /**
     * 影片年代
     */
    private String movieDecade;

    /**
     * 影片国家
     */
    private String movieCountry;

    /**
     * 电影分类
     */
    private String movieLevel;

    /**
     * 影片语言
     */
    private String movieLanguage;

    /**
     * 影片时长
     */
    private String movieDuration;

    /**
     * 影片导演
     */
    private String movieDirector;

    /**
     * 影片主演
     */
    private String movieActors;

    /**
     * 影片海报
     */
    private String moviePlacard;

    /**
     * 影片上映时间
     */
    private Date moviePublish;

    /**
     * 影片分数=总分/评分次数
     */
    private Double movieScore;

    /**
     * 影片总分
     */
    private Double movieTotalScore;

    /**
     * 评分次数
     */
    private Integer movieScoreTimes;

    /**
     * 影片描述
     */
    private String movieDescription;

    /**
     * 票房统计
     */
    private Long movieBoxOffice;

    /**
     * 影片状态
     */
    private Integer movieState;
    private Date orderDate;
    private static final long serialVersionUID = 1L;
}
