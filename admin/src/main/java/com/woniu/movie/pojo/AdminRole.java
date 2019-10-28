package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminRole implements Serializable {
    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 角色id
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}