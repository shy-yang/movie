package com.woniu.movie.util;

/**
 * 用户状态的判断计算
 */
public class UserUtil {

    /**
     * 根据用户总积分返回对应等级
     *
     * @param userScoreSum 用户总积分
     * @return 用户等级
     */
    public static Integer getLevelByUserScoreSum(Integer userScoreSum) {
        if (userScoreSum < 100) {
            return 1;
        }
        if (userScoreSum < 300) {
            return 2;
        }
        if (userScoreSum < 600) {
            return 3;
        }
        if (userScoreSum < 1000) {
            return 4;
        }
        if (userScoreSum < 1800) {
            return 5;
        }
        if (userScoreSum < 4050) {
            return 6;
        }
        if (userScoreSum < 7800) {
            return 7;
        }
        if (userScoreSum < 16666) {
            return 8;
        }
        return 9;
    }
}
