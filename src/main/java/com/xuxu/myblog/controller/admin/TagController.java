package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.entiy.BlogTag;
import com.xuxu.myblog.service.admin.TagService;
import com.xuxu.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  标签管理Controller
 *****/

@RestController
@RequestMapping("/admin/tag")
public class TagController {

    //注入tag服务层
    @Autowired
    private TagService tagService;

    /**
     * 查询所有的标签
     * @return
     */
    @RequestMapping("/queryAllTags")
    public Result<BlogTag> queryAllTags(){

        //调用服务层的方法层，查询所有的博客标签
        List<BlogTag> list =  tagService.queryAllTags();

        return new Result (200,"查询所有博客标签成功",list);

    }


}
