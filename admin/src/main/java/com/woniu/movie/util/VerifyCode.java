package com.woniu.movie.util;

import lombok.Data;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/10/18
 * @since 1.0.0
 */
@Data
public class VerifyCode {
    private String code;

    private byte[] imgBytes;

    private long expireTime;
}
