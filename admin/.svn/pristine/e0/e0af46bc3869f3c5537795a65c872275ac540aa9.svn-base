package com.woniu.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.movie.pojo.ShowHall;
import com.woniu.movie.response.ResponseResult;
import com.woniu.movie.service.IShowHallService;
import com.woniu.movie.vo.ShowHallQueryVo;
import com.woniu.movie.vo.ShowHallVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 放映厅管理
 *
 * @author 范崇文
 */
@Controller
@RequestMapping("/show_hall")
public class ShowHallController {
    @Autowired
    private IShowHallService showHallService;

    /**
     * 根据条件分页查询放映厅
     *
     * @param showHallQueryVo 放映厅查询条件
     */
    @GetMapping("/list")
    @ResponseBody
    public ResponseResult getShowHallVoList(ShowHallQueryVo showHallQueryVo) {
        //从queryVo中获取页数和单页显示量
        Integer page = showHallQueryVo.getPageNum();
        Integer pageSize = showHallQueryVo.getPageSize();
        //如果没有获取到页数相关参数或者页数不合法 就设置为默认值
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }
        PageHelper.startPage(page, pageSize);
        List<ShowHallVo> showHallVos = showHallService.findShowHallVosByShowHallQueryVo(showHallQueryVo);
        return new ResponseResult("200", "操作成功").add("showHallVos", new PageInfo<>(showHallVos));
    }

    /**
     * 设置单个放映厅的状态
     *
     * @param showHallState 放映厅的状态
     * @param showHallId    放映厅的id
     */
    @PostMapping("/setShowHallState")
    @ResponseBody
    public ResponseResult setShowHallState(String showHallState, Integer showHallId) {
        ShowHall showHall = new ShowHall();
        showHall.setShowHallId(showHallId);
        showHall.setShowHallState(showHallState);
        int success = showHallService.modifyShowHallByShowHallIdSelective(showHall);
        if (success == 0) {
            return new ResponseResult("400", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }

    /**
     * 批量修改放映厅状态
     *
     * @param showHallState 优惠券的状态
     * @param showHallIds   优惠券的id
     */
    @PostMapping("/batchSetShowHallState")
    @ResponseBody
    public ResponseResult batchSetShowHallState(String showHallIds, String showHallState) {
        int success = showHallService.batchModifyShowHallStateByShowHallIds(showHallIds.split(","), showHallState);
        if (success == 0) {
            return new ResponseResult("400", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }

    /**
     * 添加放映厅
     *
     * @param showHall 从前端接收到的放映厅对象
     * @param errors   数据验证后的错误结果
     */
    @PostMapping("/add")
    @ResponseBody
    public ResponseResult addShowHall(@Validated ShowHall showHall, BindingResult errors) {
        if (errors.getErrorCount() > 0) {
            return new ResponseResult("500", "数据有误！");
        }
        showHallService.addSelective(showHall);
        return new ResponseResult("200", "添加成功！");
    }

    /**
     * 根据放映厅id修改整个放映厅
     *
     * @param showHall 接收到的放映厅对象
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseResult updateShowHallByShowHallId(ShowHall showHall) {
        int success = showHallService.modifyShowHallByShowHallIdSelective(showHall);
        if (success == 0) {
            return new ResponseResult("404", "修改失败！");
        }
        return new ResponseResult("200", "修改成功！");
    }
}
