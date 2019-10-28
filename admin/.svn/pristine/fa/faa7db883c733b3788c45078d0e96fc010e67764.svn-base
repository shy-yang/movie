package com.woniu.movie.util;

import com.woniu.movie.pojo.Seat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理座位数据的工具类
 */
public class SeatUtil {
    /**
     * 将x_y形式的座位数据转换为Seat对象数组
     *
     * @param seats x_y形式的座位坐标字符串，坐标之间用,隔开
     * @return 返回一个座位对象集合
     */
    public static List<Seat> transStringToSeats(String seats) {
        List<Seat> seatList = new ArrayList<>();
        String[] seatPosition = seats.split(",");
        for (String sp : seatPosition) {
            String[] yAndX = sp.split("_");
            seatList.add(new Seat(yAndX[1], yAndX[0]));
        }
        return seatList;
    }

    /**
     * 根据Seat对象集合生成座位坐标集合
     *
     * @param seatList 座位对象集合
     * @return 返回y_x类型的字符串集合
     */
    public static Map<String, Object> getSelectedSeatPosition(List<Seat> seatList) {
        List<String> selectedSeat = new ArrayList<>();
        for (Seat s : seatList) {
            selectedSeat.add(s.getSeatY() + "_" + s.getSeatX());
        }
        int X = 0;
        int Y = 0;
        if (seatList.size() > 0) {
            //利用循环找出X和Y最大值
            if (seatList.size() < 2) {
                X = Integer.parseInt(seatList.get(0).getSeatX());
                Y = Integer.parseInt(seatList.get(0).getSeatY());
            } else {
                for (Seat seat : seatList) {

                    Y = Math.max(Y, Integer.parseInt(seat.getSeatY()));
                    X = Math.max(X, Integer.parseInt(seat.getSeatX()));
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("selectedSeat", selectedSeat);
        map.put("x", X);
        map.put("y", Y);
        return map;
    }

    /**
     * 将数据库内的座位数据转换成前端可识别的字符串集合
     *
     * @param seatList 从数据库中查出来的座位集合
     * @return 返回c和_组合的字符串集合
     */
    public static List<String> getSeatSquare(List<Seat> seatList) {
        int X = 0;
        int Y = 0;
        //利用循环找出X和Y最大值
        if (seatList.size() < 2) {
            X = Integer.parseInt(seatList.get(0).getSeatX());
            Y = Integer.parseInt(seatList.get(0).getSeatY());
        } else {
            for (Seat seat : seatList) {
                Y = Math.max(Y, Integer.parseInt(seat.getSeatY()));
                X = Math.max(X, Integer.parseInt(seat.getSeatX()));
            }
        }
        //循环拼接出长度为X的_字符串
        String line = "";
        for (int j = 1; j <= X; j++) {
            line += "_";
        }
        //数组接受每行座位数据
        List<String> seat = new ArrayList<>();
        for (int i = 1; i <= Y; i++) {
            //找出当前行的座位坐标
            List<Seat> seatsLine = new ArrayList<>();
            for (Seat s : seatList) {
                if (Integer.parseInt(s.getSeatY()) == i) {
                    seatsLine.add(s);
                }
            }
            //根据当前行座位坐标 修改字符串
            StringBuilder sb = new StringBuilder(line);
            for (int k = 0; k < seatsLine.size(); k++) {
                //将于x坐标相同的_字符串替换为c
                for (int j = 1; j <= X; j++) {
                    if (Integer.parseInt(seatsLine.get(k).getSeatX()) == j) {
                        sb.replace(j - 1, j, "c");
                    }
                }
            }
            //处理完当前行座位后，加入集合中
            seat.add(sb.toString());
        }
        return seat;
    }
}
