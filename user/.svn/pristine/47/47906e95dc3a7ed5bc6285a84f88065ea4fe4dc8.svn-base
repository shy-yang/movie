package com.woniu.movie.vo;

import com.woniu.movie.pojo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieTicketVo implements Serializable {
    /**
     * 电影票id
     */
    private Integer movieTicketId;

    /**
     * 排片id
     */
    private Integer movieScheduleId;
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
    /**
     * 价格
     */
    private BigDecimal movieSchedulePrice;

    /**
     * 影片对象
     */
    private Movie movie;

    /**
     * 放映厅对象
     */
    private ShowHall showHall;

    /**
     * 放映点对象
     */
    private ShowSite showSite;

    /**
     * 影院对象
     */
    private Cinema cinema;

    /**
     * 用户对象
     */
    private User user;

    /**
     * 座位x坐标
     */
    private String movieTicketSeatX;

    /**
     * 座位y坐标
     */
    private String movieTicketSeatY;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 座位状态
     */
    private String movieTicketSeatState;


    private static final long serialVersionUID = 1L;
}
