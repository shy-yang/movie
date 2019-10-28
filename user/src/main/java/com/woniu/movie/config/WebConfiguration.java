package com.woniu.movie.config;

import com.woniu.movie.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
        //门户首页视图
        registry.addViewController("/").setViewName("index");
        //用户登录视图
        registry.addViewController("/user/userLogin").setViewName("user/userLogin");
        //用户注册视图
        registry.addViewController("/user/userRegister").setViewName("user/register");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/order/**")
                .addPathPatterns("/user/personalCenter")
                .addPathPatterns("/user/userOrder");
    }
}
