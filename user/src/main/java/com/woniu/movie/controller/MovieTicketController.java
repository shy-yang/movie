package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IMovieTicketService;
import com.woniu.movie.util.SeatUtil;
import com.woniu.movie.vo.MovieTicketQueryVo;
import com.woniu.movie.vo.MovieTicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/movie_ticket")
public class MovieTicketController {
    @Autowired
    private IMovieTicketService movieTicketService;

    /**
     * 跳转到电影票页面并携带排片id
     *
     * @param movieScheduleId 电影票id
     * @param map             请求域数据
     * @return 返回视图
     */
    @GetMapping("/buy")
    public String goToTicketView(Integer movieScheduleId, Map<String, Object> map) {
        map.put("movieScheduleId", movieScheduleId);
        return "movie_ticket/movie_ticket_detail";
    }

    /**
     * 根据条件分页查询电影票详情
     *
     * @param movieTicketQueryVo 查询条件
     * @return 返回电影票信息
     */
    @GetMapping("/query")
    @ResponseBody
    public ResponseResult queryMovieTicketVo(MovieTicketQueryVo movieTicketQueryVo) {
        Integer isShowAll = movieTicketQueryVo.getIsShowAll();
        if (isShowAll != null && isShowAll == 1) {
            List<MovieTicketVo> movieTicketVos = movieTicketService.findMovieTicketVoByMovieTicketQueryVo(movieTicketQueryVo);
            if (movieTicketVos.size() < 1) {
                return new ResponseResult("404", "未查询到排片！");
            }
            MovieTicketVo movieTicketVo = movieTicketVos.get(0);
            Map<String, Object> map = SeatUtil.getMovieTicketSeat(movieTicketVos);
            return new ResponseResult("200", "操作成功！").add("movieTicketVo", movieTicketVo)
                    .add("allSeat", map.get("allSeat")).add("unavailableSeat", map.get("unavailableSeat"));
        }
        //从queryVo中获取页数和单页显示量
        Integer page = movieTicketQueryVo.getPage();
        Integer pageSize = movieTicketQueryVo.getPageSize();
        //如果没有获取到页数相关参数或者页数不合法 就设置为默认值
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<MovieTicketVo> movieTicketVos = movieTicketService.findMovieTicketVoByMovieTicketQueryVo(movieTicketQueryVo);
        return new ResponseResult("200", "操作成功！").add("movieTicketVos", new PageInfo<>(movieTicketVos));
    }
}
