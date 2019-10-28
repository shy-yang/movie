package com.woniu.movie.controller;

import com.woniu.movie.pojo.Admin;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IAdminService;
import com.woniu.movie.util.VerifyUtil;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 功能描述:<br>
 * 〈管理员相关〉
 *
 * @author 李志祥
 * @create 2019/10/18
 * @since 1.0.0
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    /**管理员ajax登录验证
     * @param admin 前台传过来的管理员用户
     * @param verification  用户输入的验证码信息
     * */

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult loginByIdAndName(Admin admin, HttpServletRequest request,String verification){
        Admin adminResult=adminService.findAdminByAdminAccount(admin.getAdminAccount());
        //判断用户名是否存在
        if(adminResult==null){
            return new ResponseResult("500", "用户名错误，请重新输入！");
        }else{
            String passwordResult=adminResult.getAdminPassword();
            if(passwordResult.equals(admin.getAdminPassword())){
                /*用户名和秘密都正确后进行验证码验证，从session中取出验证码imageCode*/
                HttpSession session=request.getSession();
                Object obj =session.getAttribute("imageCode");
                if(verification.equals((String) obj)){
                    return new ResponseResult("100", "登录成功");
                }else{
                    return new ResponseResult("300", "验证码错误，请重新输入");
                }
            }else{
                return new ResponseResult("200", "密码错误，请重新输入!");
            }
        }
    }
    /*前台向后台获取验证码图片，验证码存于session,验证图片输出到浏览器*/
    @GetMapping  ("/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session,设置60秒后失效!
        session.setAttribute("imageCode",objs[0]);
        session.setMaxInactiveInterval(60);
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        ImageIO.write(image, "png", response.getOutputStream());
    }
}
