package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.pojo.Movie;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IMovieService;
import com.woniu.movie.vo.MovieQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author justin
 * @create 2019/10/18
 * @since 1.0.0
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    /**
     * 根据queryVo查询电影
     *
     * @param filmQueryVo 电影查询条件
     * @return 返回查询结果
     */
    @GetMapping("/list")
    @ResponseBody
    public ResponseResult queryMovieByQueryVo(MovieQueryVo filmQueryVo) {
        //从queryVo中获取页数和单页显示量
        Integer page = filmQueryVo.getPage();
        Integer pageSize = filmQueryVo.getPageSize();
        //如果没有获取到页数相关参数或者页数不合法 就设置为默认值
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<Movie> movies = movieService.findAllMovieByFilmQueryVo(filmQueryVo);
        return new ResponseResult("200", "查询成功！").add("movies", new PageInfo<>(movies));
    }

    @GetMapping("detail")
    public String queryMovieDetail(Integer movieId, Map map) {
        Movie movie = movieService.selectByPrimaryKey(movieId);
        map.put("movie", movie);
        return "film_detail/film_detail";
    }

    @PostMapping("getMovieLevels")
    @ResponseBody
    public ResponseResult queryMovieLevels() {
        List<String> level = movieService.findAllMovieLevels();
        Set<String> levelSet = new HashSet<>();
        for (String l : level) {
            String[] ls = l.split("/");
            for (String ll : ls) {
                if (ll != null && !"".equals(ll)) {
                    ll = ll.trim();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < ll.length(); i++) {
                        char llTest = ll.charAt(i);
                        if (llTest >= 0x4e00 && llTest <= 0x9fa5) {
                            sb.append(llTest);
                        }
                    }
                    levelSet.add(sb.toString());
                }
            }
        }
        return new ResponseResult().add("movieLevels", levelSet);
    }

    @PostMapping("getMovieCountries")
    @ResponseBody
    public ResponseResult queryMovieCountries() {
        List<String> Countries = movieService.findAllMovieCounties();
        Set<String> CountriesSet = new HashSet<>();
        for (String l : Countries) {
            String[] ls = l.split("/");
            for (String ll : ls) {
                if (ll != null && !"".equals(ll)) {
                    ll = ll.trim();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < ll.length(); i++) {
                        char llTest = ll.charAt(i);
                        if (llTest >= 0x4e00 && llTest <= 0x9fa5) {
                            sb.append(llTest);
                        }
                    }
                    CountriesSet.add(sb.toString());
                }
            }
        }
        return new ResponseResult().add("movieCountries", CountriesSet);
    }

    @PostMapping("movieDecade")
    @ResponseBody
    public ResponseResult queryMovieDecade() {
        List<String> decades = movieService.findALlMovieDecade();
        Set<String> decadesSet = new HashSet<>();
        for (String s : decades) {
            String s1 = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 48 && c <= 57) {
                    s1 += c;
                }
            }
            if (s1 != "") {
                decadesSet.add(s1.trim());
            }
        }
        for (String s : decadesSet) {

        }

        return new ResponseResult().add("movieDecade", decadesSet);
    }

}
