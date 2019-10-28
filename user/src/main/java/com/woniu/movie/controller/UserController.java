package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.pojo.User;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IUserService;
import com.woniu.movie.util.TencentUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static com.woniu.movie.util.MailUtils.sendEmail;

/**
 * 功能描述:<br>
 * 〈用户登录、注册、找回密码〉
 *
 * @author 李志祥
 * @create 2019/10/18
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    /*页面显示、分页*/
    @PostMapping("/login")
    @ResponseBody
    public ResponseResult userLogin(User user, HttpServletRequest request) {
        User user1 = userService.findUserByUserName(user.getUserName());
        if (user1 == null) {
            return new ResponseResult("100", "用户名错误");
        } else if (!user1.getUserPassword().equals(user.getUserPassword())) {
            return new ResponseResult("200", "密码错误");
        }
        request.getSession().setAttribute("user", user1);
        return new ResponseResult("300", "登录成功");
    }

    /*注册用户账号*/
    @RequestMapping("/register")
    @ResponseBody
    public ResponseResult userRegister(@RequestParam("uploadImg") MultipartFile userHeadImage, User user, HttpServletRequest request) throws IOException {
        User ResultUser = userService.findUserByUserName(user.getUserName());
        if (ResultUser != null) {
            return new ResponseResult("100", "用户名重复！请重新输入");
        }
        String verifyCode = (String) request.getSession().getAttribute("VarifyCode");
        if (verifyCode == null || !verifyCode.equals(user.getUserVerifyCode())) {
            return new ResponseResult("200", "验证码错误！");
        }
        //上传图片
        if (!userHeadImage.isEmpty()) {
            String imgName = TencentUploadUtil.uploadImgToTencentCloud(userHeadImage);
            user.setUserHeadImage(imgName);
        }
        user.setUserState("1");
        int num = userService.addSelective(user);
        if (num < 1) {
            return new ResponseResult("300", "注册失败");
        }
        request.getSession().setAttribute("user", user);
        return new ResponseResult("400", "注册成功,2s后跳转主页！");
    }

    /*获取邮箱验证码*/
    @GetMapping("/email")
    @ResponseBody
    public ResponseResult emailCode(HttpServletRequest request, String userEmail) throws MessagingException {
        String randomNum = (int) ((Math.random() * 9 + 1) * 100000) + "";
        HttpSession session = request.getSession();
        /*将获取的验证码放到session域中*/
        session.setAttribute("VarifyCode", randomNum);
        /*设置60秒失效*/
        session.setMaxInactiveInterval(30);
        boolean flag = sendEmail("1181580150@qq.com", userEmail, randomNum);
        if (!flag) {
            return new ResponseResult("200", "发送失败");
        }
        return new ResponseResult("100", randomNum);
    }

    @RequestMapping("/personalCenter")
    public String personalCenter() {
        return "user/personal_center";
    }

    @RequestMapping("/userOrder")
    public String personalOrder() {
        return "user/personal_order";
    }

}
