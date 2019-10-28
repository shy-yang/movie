package com.woniu.movie.vo;

import com.woniu.movie.pojo.Movie;
import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.pojo.ShowSite;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/10/23
 * @since 1.0.0
 */
@Data
@Transactional
public class MovieScheduleQueryVo {
    /**
     * 排片id
     */
    private Integer movieScheduleId;

    /**
     * 影片id
     */
    private Integer movieId;
    private Movie movie;
    private String movieName;

    /**
     * 放映厅id
     */
    private Integer showHallId;
    private ShowHall showHall;
    private String showHallName;
    /**
     * 放映点id
     */
    private Integer showSiteId;
    private ShowSite showSite;
    private String showSiteName;
    private String showSiteAddress;
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date movieScheduleStartTime;
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date movieScheduleEndTime;

    private String showTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date showDate;

    private BigDecimal movieSchedulePrice;

    private static final long serialVersionUID = 1L;

    private Integer pageNum;
    private Integer pageSize;
}
