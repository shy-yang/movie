package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户头像
     */
    private String userHeadImage;

    /**
     * 用户个人简介
     */
    private String userDescription;

    /**
     * 用户可用积分
     */
    private Integer userScoreActive;

    /**
     * 用户总积分
     */
    private Integer userScoreSum;

    /**
     * 用户等级
     */
    private Integer userLevel;
    /**
     * 用户状态
     */
    private String userState;


    private String userVerifyCode;


    public User(Integer userId, Integer userScoreActive, Integer userScoreSum, Integer userLevel) {
        this.userId = userId;
        this.userScoreActive = userScoreActive;
        this.userScoreSum = userScoreSum;
        this.userLevel = userLevel;
    }

    private static final long serialVersionUID = 1L;
}
