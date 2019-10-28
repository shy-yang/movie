package com.woniu.movie.vo;

import lombok.Data;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/10/21
 * @since 1.0.0
 */
@Data
public class ShowHallQueryVo {
    private String showSiteName;
    private String showHallNumber;
    private Integer showHallId;
    private String showHallName;
    private String showHallType;
    private Integer pageNum;
    private Integer pageSize;
    private Integer showSiteId;
}
