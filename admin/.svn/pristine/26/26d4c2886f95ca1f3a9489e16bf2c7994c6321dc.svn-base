package com.woniu.movie.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:<br>
 * 〈用来向前台返回json数据〉
 *
 * @author 李志祥
 * @create 2019/10/18
 * @since 1.0.0
 */
@Data
public class ResponseResult {
    private String code;
    private String message;
    private Map<String, Object> map = new HashMap<>();

    public ResponseResult(String code, String message, Map<String, Object> map) {
        this.code = code;
        this.message = message;
        this.map = map;
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public ResponseResult() {
    }
}
