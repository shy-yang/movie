package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cinema implements Serializable {
    /**
     * 影院id
     */
    private Integer cinemaId;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院地址
     */
    private String cinemaAddress;

    /**
     * 影院电话
     */
    private String cinemaPhone;

    /**
     * 影院服务
     */
    private String cinemaService;

    /**
     * 影院图片
     */
    private String cinemaImage;

    /**
     * 影院介绍
     */
    private String cinemaDescription;

    private static final long serialVersionUID = 1L;
}