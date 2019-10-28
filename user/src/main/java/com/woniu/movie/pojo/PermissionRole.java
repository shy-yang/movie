package com.woniu.movie.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class PermissionRole implements Serializable {
    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 角色id
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}