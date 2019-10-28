package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.media.sound.SoftTuning;
import com.woniu.movie.pojo.Movie;
import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.pojo.ShowSite;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IMovieScheduleService;
import com.woniu.movie.service.IMovieService;
import com.woniu.movie.service.IShowHallService;
import com.woniu.movie.service.IShowSiteService;
import com.woniu.movie.vo.MovieScheduleQueryVo;
import com.woniu.movie.vo.ShowHallQueryVo;
import com.woniu.movie.vo.ShowSiteQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

/**
 * 功能描述:<br>
 * 〈根据影片选取影院〉
 *
 * @author 单海洋
 * @create 2019/10/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/movieSchedule")
public class MovieScheduleController {
    @Autowired
    IMovieService movieService;
    @Autowired
    IMovieScheduleService movieScheduleService;
    @Autowired
    IShowSiteService showSiteService;
    @Autowired
    IShowHallService showHallService;
    /**
     * 转到影院选择界面
     *
     * @return
     */
    @RequestMapping("/movie_schedule_view")
    public String cinemaView(Integer movieId, Map map) {
        Movie movie = movieService.selectByPrimaryKey(movieId);
        map.put("movie", movie);
        return "movieSchedule/movie_schedule_view";
    }

    /**
     * 得到列表信息
     *
     * @param queryVo 获取各种搜索要求
     * @return
     */
    @RequestMapping("/getMovieScheduleMessage")
    @ResponseBody
    public ResponseResult getMovieScheduleMessage(MovieScheduleQueryVo queryVo) {
        if (queryVo.getShowTime() == null || queryVo.getShowTime().toString().trim() == "" || queryVo.getShowTime() == "NaN-NaN-NaN") {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String str = sdf.format(date);
            queryVo.setShowTime(str);
        }
        //得到放映厅id
        if (queryVo.getShowSiteAddress() != null && queryVo.getShowSiteAddress().toString().trim() != "") {
            ShowSiteQueryVo showSiteQueryVo = new ShowSiteQueryVo();
            showSiteQueryVo.setShowSiteAddress(queryVo.getShowSiteAddress());
            List<ShowSite> showSite = showSiteService.findAllShowSite(showSiteQueryVo);
            if (showSite.size() != 0) {
                //System.out.println("放映点id:"+showSite.get(0).getShowSiteId());
                queryVo.setShowSiteId(showSite.get(0).getShowSiteId());
            } else {
                queryVo.setShowSiteId(-1);
            }
        }
        List<MovieScheduleQueryVo> mv = new ArrayList<>();
        if (queryVo.getShowHallName() != null && queryVo.getShowHallName().toString().trim() != "") {
            //得到展厅id
            ShowHallQueryVo showHallQueryVo = new ShowHallQueryVo();
            showHallQueryVo.setShowHallName(queryVo.getShowHallName());
            List<ShowHall> showHalls = showHallService.findAll(showHallQueryVo);
            for (ShowHall sh : showHalls) {
                //System.out.println("showHall:"+sh);
                queryVo.setShowHallId(sh.getShowHallId());
                List<MovieScheduleQueryVo> list = movieScheduleService.findAllMovieSchedule(queryVo);
                mv.addAll(list);
            }
        } else {
            List<MovieScheduleQueryVo> list = movieScheduleService.findAllMovieSchedule(queryVo);
            mv.addAll(list);
        }
        //System.out.println("movieId:" + queryVo);
        //System.out.println(mv);
        for (int i = 0; i < mv.size() - 1; i++) {
            for (int y = i + 1; y < mv.size(); y++) {
                if (mv.get(i).getShowSiteId() == mv.get(y).getShowSiteId()) {
                    mv.remove(mv.get(y));
                }
            }
        }
        PageHelper.startPage(queryVo.getPageNum(), queryVo.getPageSize());
        PageInfo<MovieScheduleQueryVo> pageInfo = new PageInfo<>(mv, 3);
        return new ResponseResult("200", "操作成功").add("pageInfo", pageInfo);
    }

    /**
     * 转到具体一家的放映点
     *
     * @return
     */
    @RequestMapping("/showSiteView")
    public String showSiteView(MovieScheduleQueryVo queryVo, Map map) {
        map.put("showSiteId", queryVo.getShowSiteId());
        map.put("movieId", queryVo.getMovieId());
        return "movieSchedule/show_site_view";
    }

    /**
     * 根据放映点id得到放映点信息
     *
     * @param showSite
     * @return
     */
    @RequestMapping("/getShowSiteMessage")
    @ResponseBody
    public ShowSite getShowSiteMessage(ShowSite showSite) {
        return showSiteService.findShowSiteByShowSiteId(showSite.getShowSiteId());
    }


    /**
     * 根据具体时间选择已经选定的影片的排片
     *
     * @param queryVo
     * @return
     */
    @RequestMapping("/getMovieMessage")
    @ResponseBody
    public ResponseResult movieLanguage(MovieScheduleQueryVo queryVo) {
        if (queryVo.getShowTime() == null || queryVo.getShowTime().toString().trim() == "" || queryVo.getShowTime() == "NaN-NaN-NaN") {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String str = sdf.format(date);
            queryVo.setShowTime(str);
        }
        Movie movie = movieService.selectByPrimaryKey(queryVo.getMovieId());
        List<MovieScheduleQueryVo> list = movieScheduleService.findAllMovieSchedule(queryVo);
        return new ResponseResult("200", "操作成功").add("movie", movie).add("list", list);
    }


    @RequestMapping("/getOtherMovie")
    @ResponseBody
    public ResponseResult getOtherMovie(Integer showSiteId, Integer movieId, Integer pageNum, Integer pageSize) {

        MovieScheduleQueryVo queryVo = new MovieScheduleQueryVo();
        queryVo.setShowSiteId(showSiteId);
        List<MovieScheduleQueryVo> list = movieScheduleService.findAllMovieSchedule(queryVo);
        Map<Integer, MovieScheduleQueryVo> map = new HashMap<>();
        for (MovieScheduleQueryVo m : list) {
            if (!map.containsKey(m.getMovieId())) {
                map.put(m.getMovieId(), m);
            }
        }

        List<MovieScheduleQueryVo> movies = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            movies.add(map.get(key));
        }
        if (pageSize > movies.size()) {
            pageSize = movies.size();
        }
        List<MovieScheduleQueryVo> newMovies = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            newMovies.add(movies.get(i));
        }

        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 1;
        }
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<MovieScheduleQueryVo> pageInfo = new PageInfo<>(newMovies, 4);

        return new ResponseResult("200", "操作成功").add("movies", pageInfo);
    }

}
