package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ShowSite implements Serializable {
    /**
     * 放映点id
     */
    private Integer showSiteId;
    /**
     * 放映点名称
     */
    private String showSiteName;

    /**
     * 放映点地址
     */
    private String showSiteAddress;
    /**
     * 放映点坐标
     */
    private String showSiteCoordinate;

    /**
     * 放映点电话
     */
    @Pattern(regexp = "^021-[0-9]{8}", message = "电话号码为021-加8位数字组成")
    private String showSitePhone;

    /**
     * 放映点服务
     */
    private String showSiteService;

    /**
     * 放映点图片
     */
    private String showSiteImage;

    /**
     * 放映点介绍
     */
    private String showSiteDescription;

    /**
     * 影院id
     */
    private Integer cinemaId;

    private static final long serialVersionUID = 1L;
}