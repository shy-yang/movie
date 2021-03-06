package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Seat implements Serializable {
    /**
     * 座位id
     */
    private Integer seatId;

    /**
     * 座位x坐标
     */
    private String seatX;

    /**
     * 座位y坐标
     */
    private String seatY;

    /**
     * 放映厅id
     */
    private Integer showHallId;

    public Seat() {
    }

    public Seat(String seatX, String seatY) {
        this.seatX = seatX;
        this.seatY = seatY;
    }

    private static final long serialVersionUID = 1L;
}