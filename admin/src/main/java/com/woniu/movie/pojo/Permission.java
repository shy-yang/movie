package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Permission implements Serializable {
    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 权限名
     */
    private String permissionName;

    /**
     * 权限url
     */
    private String permissionUrl;

    private static final long serialVersionUID = 1L;
}