package com.woniu.movie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class MovieSchedule implements Serializable {
    /**
     * 排片id
     */
    private Integer movieScheduleId;

    /**
     * 影片id
     */
    private Integer movieId;

    /**
     * 放映厅id
     */
    private Integer showHallId;

    /**
     * 放映点id
     */
    private Integer showSiteId;

    /**
     * 开始时间
     */
    private Date movieScheduleStartTime;

    /**
     * 结束时间
     */
    private Date movieScheduleEndTime;

    private BigDecimal movieSchedulePrice;

    private static final long serialVersionUID = 1L;
}