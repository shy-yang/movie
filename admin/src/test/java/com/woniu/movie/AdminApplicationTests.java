package com.woniu.movie;

import com.woniu.movie.service.ICinemaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminApplicationTests {
    @Autowired
    private ICinemaService cinemaService;

    @Test
    void contextLoads() {
        //添加一个注释测试SVN
        //第二次测试
        //测试三
        System.out.println(cinemaService.findCinemaByCinemaIdKey(1));
    }
}
