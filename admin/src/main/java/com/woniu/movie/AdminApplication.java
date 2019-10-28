package com.woniu.movie;

import com.woniu.movie.pojo.AlipayConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.woniu.movie.mapper")
@EnableConfigurationProperties({AlipayConfig.class})
public class AdminApplication {
    //测试main
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
