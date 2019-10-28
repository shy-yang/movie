package com.woniu.movie.controller;

import com.woniu.movie.pojo.Seat;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.ISeatService;
import com.woniu.movie.util.SeatUtil;
import com.woniu.movie.vo.SeatQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 座位管理
 */
@Controller
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private ISeatService seatService;

    /**
     * 改变放映厅的座位排布
     *
     * @param selectedSeats 座位的坐标排布
     * @param showHallId    放映厅id
     */
    @PostMapping("/change")
    @ResponseBody
    public ResponseResult changeSeat(String selectedSeats, Integer showHallId) {
        if (showHallId == null) {
            return new ResponseResult("400", "请输入放映厅编号！");
        }
        List<Seat> seatList = SeatUtil.transStringToSeats(selectedSeats);
        int success = seatService.modifySeatByShowHallId(showHallId, seatList);
        if (success == 0) {
            return new ResponseResult("500", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }

    /**
     * 根据查询条件获得指定放映厅的座位排布
     *
     * @param seatQueryVo 查询条件
     */
    @GetMapping("/list")
    @ResponseBody
    public ResponseResult getSeatWithSeatQueryVo(SeatQueryVo seatQueryVo) {
        if (seatQueryVo.getShowHallId() == null) {
            return new ResponseResult("400", "请输入放映厅编号！");
        }
        List<Seat> seatList = seatService.findSeatByQueryVo(seatQueryVo);
        if (seatList.size() == 0) {
            return new ResponseResult("404", "该放映厅尚未排座！");
        }
        Map<String, Object> map = SeatUtil.getSelectedSeatPosition(seatList);
        return new ResponseResult("200", "查询成功！").add("selectedSeat", map.get("selectedSeat"))
                .add("seatCount", seatList.size()).add("x", map.get("x")).add("y", map.get("y"));
    }
}
