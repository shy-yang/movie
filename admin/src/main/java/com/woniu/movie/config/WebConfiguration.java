package com.woniu.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述:网站拦截器和视图配置
 *
 * @author justin
 * @create 2019/10/18
 * @since 1.0.0
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    /**
     * 注册视图
     *
     * @param registry springboot中的视图注册对象
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //首页视图
        registry.addViewController("/").setViewName("index");
        //放映点视图
        registry.addViewController("/show_site/add_show_site").setViewName("show_site/add_show_site");
        //优惠券视图
        registry.addViewController("/coupon/listView").setViewName("coupon/couponList");
        //管理员登录视图
        registry.addViewController("/admin/loginView").setViewName("admin/adminLogin");
        //普通用户管理界面
        registry.addViewController("/user/userManager").setViewName("user/userManager");
        //电影列表视图
        registry.addViewController("/film/film_list").setViewName("film/film_list");
        //电影详细视图
        registry.addViewController("/film_detail").setViewName("film/film_detail");
        //电影更新视图
        registry.addViewController("/film_update").setViewName("film/film_update");
        //排片视图
        registry.addViewController("/movie_schedule/movie_schedule_view").setViewName("/movie_schedule/movie_schedule_view");
        //座位管理视图
        registry.addViewController("/show_hall/seat").setViewName("show_hall/show_hall_seat");
        //放映厅视图
        registry.addViewController("/show_hall/listView").setViewName("show_hall/show_hall_list");
    }
}
