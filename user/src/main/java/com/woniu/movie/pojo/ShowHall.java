package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShowHall implements Serializable {
    /**
     * 放映厅id
     */
    private Integer showHallId;

    /**
     * 放映厅编号
     */
    private String showHallNumber;

    /**
     * 放映厅名字
     */
    private String showHallName;

    /**
     * 放映厅类型
     */
    private String showHallType;

    /**
     * 座位数
     */
    private Integer showHallSeatCount;

    /**
     * 放映厅状态
     */
    private String showHallState;

    /**
     * 放映点id
     */
    private Integer showSiteId;

    private static final long serialVersionUID = 1L;
}