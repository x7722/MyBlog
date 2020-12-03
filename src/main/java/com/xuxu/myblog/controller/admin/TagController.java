package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.entiy.BlogTag;
import com.xuxu.myblog.service.admin.TagsService;

import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;
import com.xuxu.myblog.util.Result;
import com.xuxu.myblog.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  标签管理Controller
 *****/

@Controller
@RequestMapping("/admin/tags")
public class TagController {

    //注入tag服务层
    @Autowired
    private TagsService tagsService;

    /**
     * 访问tags页面
     *
     * @return
     */
    @RequestMapping("")
    public String goPage() {
        return "admin/tags.html";
    }

    /**
     * 查询所有的标签
     *
     * @return 返回到tags.html页面
     */
    @GetMapping("/list")
    public String queryAllTags(Model model) {
        //调用服务层的方法层，查询所有的博客标签
        List<BlogTag> list = tagsService.queryAllTags();
        for (BlogTag tag : list) {
            model.addAttribute("tags", list);
        }
        return "admin/tags.html";

    }

    /**
     * 根据id修改标签名称
     *
     * @param tagId 标签id
     * @return Result结果对象
     */
    @RequestMapping("/update/{tagId}/{tagName}")
    @ResponseBody
    public Result updateTag(@PathVariable("tagId") Integer tagId, @PathVariable("tagName") String tagName) {

        System.out.println("标签ID：" + tagId);
        System.out.println("名称：" + tagName);

        //调用service层方法，修改标签名称
        Boolean flag = tagsService.updateTag(tagId, tagName);

        if (flag) {
            return new Result(true, StatusCode.OK, "修改标签成功");
        }
        return new Result(false, StatusCode.ERROR, "修改标签失败");
    }

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页显示的条数
     * @return PageResult
     */
    @GetMapping("/findPage/{currentPage}/{pageSize}")
    @ResponseBody
    public PageResult findPage(@PathVariable String currentPage, @PathVariable String pageSize) {
        //创建一个分页查询对象
        QueryPageBean queryPageBean = new QueryPageBean();
        //封装数据
        queryPageBean.setCurrentPage(Integer.parseInt(currentPage));    //当前页码
        queryPageBean.setPageSize(Integer.parseInt(pageSize));      //每页显示的条数
        //调用service层的方法，进行分页查询
        return tagsService.findPage(queryPageBean);
    }


    /**
     * 添加博客标签
     *
     * @param blogTag
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result addTags(@RequestBody BlogTag blogTag) {
        //调用service层，添加标签
        boolean flag = tagsService.addTag(blogTag);
        //判断是否添加成功
        if (flag) {
            return new Result(true, StatusCode.OK, "添加标签成功");
        }
        return new Result(false, StatusCode.ERROR, "添加标签失败");
    }


    /**
     * 根据id删除标签
     *
     * @param tagId
     * @return
     */
    @DeleteMapping("/delete/{tagId}")
    @ResponseBody
    public Result deleteTag(@PathVariable String tagId) {
        //调用service层删除标签
        boolean flag = tagsService.deleteTag(Integer.parseInt(tagId));

        //判断是否删除成功
        if (flag) {
            return new Result(true, StatusCode.OK, "删除成功");
        }
        return new Result(false, StatusCode.ERROR, "删除失败");
    }


    /**
     * 根据id停用标签
     *
     * @param tagId
     * @return
     */
    @DeleteMapping("/stop/{tagId}")
    @ResponseBody
    public Result stopTag(@PathVariable String tagId) {

        boolean flag = tagsService.stopTag(Integer.parseInt(tagId));

        if (flag) {
            return new Result(true, StatusCode.OK, "停用成功");
        }
        return new Result(false, StatusCode.ERROR, "停用失败");

    }


    /**
     * 根据id恢复标签
     * @param tagId
     * @return
     */
    @DeleteMapping("/recover/{tagId}")
    @ResponseBody
    public Result recoverTag(@PathVariable String tagId){

        boolean flag = tagsService.recoverTag(Integer.parseInt(tagId));

        //判断是否恢复成功
        if (flag) {
            return new Result(true, StatusCode.OK, "恢复成功");
        }
        return new Result(false, StatusCode.ERROR, "恢复失败");
    }

}
