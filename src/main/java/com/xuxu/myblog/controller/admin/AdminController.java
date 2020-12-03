package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.service.admin.AdminService;
import com.xuxu.myblog.util.Result;
import com.xuxu.myblog.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;


/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  AdminController
 *****/

@Controller
@RequestMapping("/admin")

//Swagger的注解，在SwaggerUI上面可以看到这个类的描述
@Api(tags = "后台主页API")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 访问index页面
     *
     * @return
     */
    @GetMapping("")
    @ApiOperation("访问后台管理首页")   //描述这个接口(简介)
    public String indexPage() {
        return "admin/index.html";
    }


    /**
     * 访问 博客编辑发布页面
     * 测试的时候用的，没有实际作用
     * @return
     */
    @GetMapping("/edit")
    @ApiIgnore  //使用该注解可以忽略这个API接口
    public String editPage(){
        return "admin/edit.html";
    }


    /**
     * 查询后台管理首页需要的数据
     * @return
     */
    @GetMapping("/pageData")
    @ResponseBody
    @ApiOperation("查询仪表盘所需要的数据")  //描述这个接口(简介)
    public Result queryPageDate(){

        //调用服务层的方法，查询首页需要的数据封装到map中
        HashMap<String,Integer> map = adminService.queryPageDate();

        return new Result(true, StatusCode.OK,"首页数据查询成功",map);

    }



}
