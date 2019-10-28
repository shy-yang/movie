package com.woniu.movie.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author EDZ
 * @create 2019/10/21
 * @since 1.0.0
 */
@Component
@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix ="alipay") //从配置文件中获取值
public class AlipayConfig {
    // 商户appid
    public  String APPID ;
    // 商户私钥
    public  String merchant_private_key ;

    // 支付完成后异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public  String notify_url ;
    // 支付完成后同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public  String return_url ;
    // 请求网关地址,沙箱支付有个dev，固定写法
    public String URL ;
    // 编码
    public  String CHARSET ;
    // 返回格式
    public  String FORMAT ;
    // 支付宝公钥
    public  String ALIPAY_PUBLIC_KEY ;
    // 日志记录目录
    public  String log_path ;

    public String getAPPID() {
        return APPID;
    }

    public void setAPPID(String APPID) {
        this.APPID = APPID;
    }

    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getCHARSET() {
        return CHARSET;
    }

    public void setCHARSET(String CHARSET) {
        this.CHARSET = CHARSET;
    }

    public String getFORMAT() {
        return FORMAT;
    }

    public void setFORMAT(String FORMAT) {
        this.FORMAT = FORMAT;
    }

    public String getALIPAY_PUBLIC_KEY() {
        return ALIPAY_PUBLIC_KEY;
    }

    public void setALIPAY_PUBLIC_KEY(String ALIPAY_PUBLIC_KEY) {
        this.ALIPAY_PUBLIC_KEY = ALIPAY_PUBLIC_KEY;
    }

    public String getLog_path() {
        return log_path;
    }

    public void setLog_path(String log_path) {
        this.log_path = log_path;
    }

    public String getSIGNTYPE() {
        return SIGNTYPE;
    }

    public void setSIGNTYPE(String SIGNTYPE) {
        this.SIGNTYPE = SIGNTYPE;
    }

    // RSA2
    public  String SIGNTYPE ;
}
