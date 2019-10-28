package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.pojo.ShowSite;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IShowSiteService;
import com.woniu.movie.util.GetCoordinate;
import com.woniu.movie.util.TencentUploadUtil;
import com.woniu.movie.vo.ShowSiteQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 功能描述:<br>
 * 放映点管理
 *
 * @author 单海洋
 * @create 2019/10/18
 * @since 1.0.0
 */
@Controller
@RequestMapping("/show_site")
public class ShowSiteController {
    @Autowired
    IShowSiteService showSiteService;

    //转到放映点静态页面
    /*@RequestMapping("/add_show_site")
    public String showSite(){
        return "add_show_site";
    }*/

    //得到放映点信息并分页-使用前端分页插件
    //pageNum, pageSize 前台传的页数和每页数量
    @RequestMapping("/get_show_site")
    @ResponseBody
    public ResponseResult getShowSite(ShowSiteQueryVo queryVo) {
        System.out.println(queryVo + "------");
        PageHelper.startPage(queryVo.getPageNum(), queryVo.getPageSize());
        List<ShowSite> list = showSiteService.findAllShowSite(queryVo);
        PageInfo<ShowSite> pageInfo = new PageInfo<>(list, 3);
        return new ResponseResult("200", "操作成功").add("pageInfo", pageInfo);
    }

    //添加放映点信息

    /**
     * showSite对象，
     *
     * @param errors    验证错误信息
     * @param uploadImg 上传的图片
     */
    @RequestMapping(value = "/addShowSite")
    @ResponseBody
    public ResponseResult addShowSite(@Valid @ModelAttribute("showSite") ShowSite showSite, BindingResult errors, @RequestParam("uploadImg") MultipartFile uploadImg, HttpServletRequest request) throws Exception {
        String res = "";
        //影院id固定一个
        showSite.setCinemaId(1);
        ResponseResult result = new ResponseResult();
        if (errors.getErrorCount() > 0) {
            for (FieldError df : errors.getFieldErrors()) {
                System.out.println(df.getField() + "----" + df.getDefaultMessage());
                result.add("phone", df.getDefaultMessage());
            }
        }

        //高德地图验证地址信息是否正确
        String coordinate = new GetCoordinate().getLngLat(showSite.getShowSiteAddress());
        System.out.println("地址坐标" + coordinate);
        if (coordinate != null) {
            showSiteService.addSelective(showSite);
        } else {
            res = "地址信息错误";
            result.add("address", res);
        }
        //上传图片
        if (!uploadImg.isEmpty()) {
            String imgName = TencentUploadUtil.uploadImgToTencentCloud(uploadImg);
            showSite.setShowSiteImage(imgName);
        }
        System.out.println(showSite);
        showSiteService.addSelective(showSite);
        if (result.getMap().size() == 0) {
            return new ResponseResult("200", "添加成功");
        }
        return new ResponseResult("500", "添加失败").add("errors", result.getMap());
    }
}
