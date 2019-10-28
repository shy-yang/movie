package com.woniu.movie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.pojo.Movie;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IMovieService;
import com.woniu.movie.util.TencentUploadUtil;
import com.woniu.movie.vo.FilmQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author justin
 * @create 2019/10/18
 * @since 1.0.0
 */
@Controller
@RequestMapping("movie")
public class FilmController {

    @Autowired
    private IMovieService movieService;

    @RequestMapping("add_film")
    public String addFilm(){
        return "film/add_film";
    }

    /**
     * 根据条件分页查询电影
     * @param pageNow 当前页数
     * @param
     * @return
     */
    @RequestMapping("film_list")
    @ResponseBody
    public ResponseResult filmList(@RequestParam(value = "pageNow" ,defaultValue ="1")Integer pageNow,
                                   @RequestParam(value = "pageSize" ,defaultValue = "10") Integer pageSize, FilmQueryVo queryVo){
        if (queryVo.getMovieStatus()==-1){
            queryVo.setMovieStatus(null);
        }
        Page<Object> page = PageHelper.startPage(pageNow, pageSize);
        List<Movie> movies=movieService.findAllMovie(queryVo);
        //封装分页数据
        PageInfo<Movie> info = new PageInfo(movies);
        ResponseResult responseResult=new ResponseResult("200","查询成功").add("pageInfo",info);
        return  responseResult;
    }

    /**
     * 查询电影详情
     * @param movieId 查询电影详情的id
     * @return
     */
    @RequestMapping("film_detail")
    @ResponseBody
    public ResponseResult filmDetail(Integer movieId){
        ResponseResult responseResult=new ResponseResult();
        Movie movie=movieService.selectByPrimaryKey(movieId);
        return  responseResult.add("movie",movie);
    }
    @RequestMapping("add_film_execution")
    @ResponseBody
    public ResponseResult addFilm(Movie movie, @RequestParam("uploadImg")MultipartFile uploadImg, HttpServletRequest request ) throws IOException {
        System.out.println(movie);
        movie.setMovieCountry(movie.getMovieCountry().replace(',','/'));
        movie.setMovieLevel(movie.getMovieLevel().replace(',','/'));
        if (!uploadImg.isEmpty()){
            String imgName = TencentUploadUtil.uploadImgToTencentCloud(uploadImg);
            movie.setMoviePlacard(imgName);
        }
        Integer insertReturn=movieService.insert(movie);
        if (insertReturn==1){
            return new ResponseResult("200","添加成功");
        }
            return new ResponseResult("400","添加失败");
    }
    @RequestMapping("delete_film")
    @ResponseBody
    public ResponseResult deleteFilm(Integer movieId){
         Integer deleteReturn=movieService.deleteByPrimaryKey(movieId);
         if (deleteReturn==1){
             return new ResponseResult("200","删除成功");
         }
         return new ResponseResult("400","删除失败");
    }
    @RequestMapping("update_film")
    @ResponseBody
    public ResponseResult updateFilm(Movie movie, @RequestParam("uploadImg")MultipartFile uploadImg, HttpServletRequest request ) throws IOException {
        System.out.println(movie);
        movie.setMovieCountry(movie.getMovieCountry().replace(',','/'));
        movie.setMovieLevel(movie.getMovieLevel().replace(',','/'));
        if (!uploadImg.isEmpty()){
            String imgName = TencentUploadUtil.uploadImgToTencentCloud(uploadImg);
            movie.setMoviePlacard(imgName);
        }
        Integer insertReturn=movieService.updateByPrimaryKeySelective(movie);
        if (insertReturn==1){
            return new ResponseResult("200","修改成功");
        }
        return new ResponseResult("400","修改失败");
    }
    @RequestMapping("delete_film_array")
    @ResponseBody
    public ResponseResult deleteArrayFilm(@RequestBody Integer[] filmIds){
        Integer rows=movieService.deleteByArrayKeys(filmIds);
        if (rows>0){return new ResponseResult("200","删除成功");}
        else {
            return new ResponseResult("400","删除失败");
        }
    }
}
