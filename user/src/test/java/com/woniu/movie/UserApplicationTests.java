package com.woniu.movie;

import com.woniu.movie.mapper.MovieMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class UserApplicationTests {
    @Autowired
    private MovieMapper movieMapper;

    @Test
    void contextLoads() {
        List<String> level = movieMapper.selectAllMovieLevels();
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
        System.out.println("=========================================");
        for (String ls : levelSet) {
            System.out.println(ls);
        }
        System.out.println("=========================================");
        System.out.println("共有电影分类：" + levelSet.size());
    }

}
