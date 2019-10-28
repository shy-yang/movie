package com.woniu.movie.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.woniu.movie.pojo.AlipayConfig;
import com.woniu.movie.pojo.Order;
import com.woniu.movie.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:<br>
 * 使用时注入AlipayUtil对象，然后调用goAlipay()方法！
 * 原理：调用这个方法后页面跳转到支付宝支付页面,支付完成后再跳转到我们自己项目页面！
 * 支付完成后跳转的的页面配置在application.yml里！可以修改！
 *
 * @author 李志祥
 * @create 2019/10/22
 * @since 1.0.0
 */
@Component
public class AlipayUtil {

    /*注入配置信息*/
    @Autowired
    AlipayConfig alipayConfig;

    /*用来获得订单里面票数*/
    @Autowired
    OrderServiceImpl orderService;

    /**
     * @param order    order订单信息
     * @param request  http请求
     * @param response http响应
     */
    public void goAlipay(Order order, HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {

        //获得初始化的AlipayClient服务器
        AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getURL(), alipayConfig.getAPPID(), alipayConfig.merchant_private_key, "json", alipayConfig.getCHARSET(), alipayConfig.getALIPAY_PUBLIC_KEY(), alipayConfig.getSIGNTYPE());

        //设置支付成功后的url请求
        AlipayTradePagePayRequest aliaRequest = new AlipayTradePagePayRequest();
        aliaRequest.setReturnUrl(alipayConfig.getReturn_url());
        aliaRequest.setNotifyUrl(alipayConfig.getNotify_url());

        //1、商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order.getOrderNumber();
        //2、付款金额，必填
        String total_amount = order.getTotalPrice() + "";
        //3、订单名称，必填
        String subject = "电影票";
        //4、商品描述，可空
        int num = orderService.findTicketsByOrderId(order.getOrderId());
        String body = "用户选购票数：" + num + "张";

        //5、设置该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        //String timeout_express = "1m";

        //6、。。。
        aliaRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                /*   + "\"timeout_express\":\""+ timeout_express +"\","*/
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //7、发送请求到支付宝支付界面
        String result = alipayClient.pageExecute(aliaRequest).getBody();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(result);
    }
}

