package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.entiy.Blog;
import com.xuxu.myblog.service.admin.BlogService;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.Result;
import com.xuxu.myblog.util.StatusCode;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  博客文章管理控制层
 *****/
@Controller
@RequestMapping("/admin/blog")

@Api(tags = "博客管理")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 访问 后台 blog页面
     */
    @GetMapping("")
    @ApiOperation("访问Blog.html这个页面")
    public String goPage() {
        return "admin/blog.html";
    }

    @GetMapping("/full")
    @ApiIgnore  //在Swagger上忽略这个API接口
    public String goPage1() {
        return "admin/full.html";
    }


    /**
     * 进入新增文章页面
     * @return
     */
    @GetMapping("/showAddBlog")
    @ApiOperation("进入新增文章的页面")
    public String showAddBlog(){
        return "admin/showAddBlog.html";
    }


    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/findPage/{currentPage}/{pageSize}")
    @ResponseBody

    //Swagger注解
    @ApiOperation("所有博客的分页查询")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页面的页码",required = true,paramType = "path",dataType = "int"),
            @ApiImplicitParam(name = "pageSize",value = "每个页面显示的条数",required = true,paramType = "path",dataType = "int")
            })
    //Swagger响应错误信息的描述
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数填写有误"),
            @ApiResponse(code = 404,message = "请求路径有误")
    })
    public PageResult findPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return blogService.findPage(currentPage, pageSize);
    }


    /**
     * 发布文章
     *
     * @param blogId
     * @return
     */
    @PutMapping("/push/{blogId}")
    @ResponseBody
    //Swagger注解
    @ApiOperation("发布文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blogId",value = "文章id",required = true,paramType = "path",dataType = "long")
    })
    public Result push(@PathVariable Long blogId) {

        boolean flag = blogService.push(blogId);

        if (flag) {
            return new Result(flag, StatusCode.OK, "发布成功");
        }
        return new Result(flag, StatusCode.ERROR, "发布失败");
    }

    /**
     * 取消发布文章
     *
     * @param blogId
     * @return
     */
    @PutMapping("/stop/{blogId}")
    @ResponseBody
    //Swagger注解
    @ApiOperation("关闭已经发布的文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blogId",value = "文章id",required = true,paramType = "path",dataType = "long")
    })
    public Result stop(@PathVariable Long blogId) {

        boolean flag = blogService.stop(blogId);

        if (flag) {
            return new Result(flag, StatusCode.OK, "文章关闭成功");
        }
        return new Result(flag, StatusCode.ERROR, "文章关闭失败");
    }

    /**
     * 彻底删除文章
     *
     * @param blogId
     * @return
     */
    @DeleteMapping("/delete/{blogId}")
    @ResponseBody

    //Swagger注解
    @ApiOperation("彻底删除文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blogId",value = "文章id",required = true,paramType = "path",dataType = "long")
    })
    public Result delete(@PathVariable Long blogId) {

        boolean flag = blogService.delete(blogId);

        if (flag) {
            return new Result(flag, StatusCode.OK, "彻底删除文章成功");
        }
        return new Result(flag, StatusCode.OK, "彻底删除文章成功");
    }

    /**
     * 恢复删除
     *
     * @param blogId
     * @return
     */
    @PutMapping("/recover/{blogId}")
    @ResponseBody

    //Swagger注解
    @ApiOperation("恢复文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blogId",value = "文章的id",required = true,paramType = "path",dataType = "long")
    })
    public Result recover(@PathVariable Long blogId) {
        boolean flag = blogService.recover(blogId);

        if (flag) {
            return new Result(flag, StatusCode.OK, "恢复删除文章成功");
        }
        return new Result(flag, StatusCode.ERROR, "恢复删除文章失败");
    }


    /**
     * 逻辑删除文章
     *
     * @param blogId
     * @return
     */
    @PutMapping("/isDelete/{blogId}")
    @ResponseBody

    //Swagger注解
    @ApiOperation("逻辑删除文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blogId",value = "文章id",required = true,paramType = "path",dataType = "long")
    })
    public Result isDelete(@PathVariable Long blogId) {
        boolean flag = blogService.isDelete(blogId);

        if (flag) {
            return new Result(flag, StatusCode.OK, "逻辑删除文章成功");
        }
        return new Result(flag, StatusCode.ERROR, "逻辑删除文章失败");
    }


    /**
     * 根据文章ID查询文章信息
     *
     * @return
     */
    @GetMapping("/findById/{blogId}")
    //Swagger注解
    @ApiOperation("根据文章id，获取文章内容")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blogId",value = "文章id",required = true,paramType = "path",dataType = "long")
    })
    public String findBlogById(@PathVariable Long blogId, Model model) {

        Blog blog = blogService.findBlogById(blogId);

        if (blog != null) {
            model.addAttribute("blogs",blog);

            System.out.println("找到了对应的文章信息："+blog);

            return  "admin/edit.html";
        }
        return "admin/blog.html";

    }


    /**
     * 修改文章内容
     * @param blog
     * @return
     */
    @PostMapping("/editBlog")
    @ResponseBody

    //Swagger注解
    @ApiOperation("修改编辑文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blog",value = "文章对象，不需要文章id、添加时间、更新时间",required = true,paramType = "body",dataType = "Blog")
    })
    public Result editBlog(@RequestBody Blog blog){

        System.out.println("修改文章："+blog);

        boolean flag = blogService.editBlog(blog);

        if (flag){
            return new Result(flag,StatusCode.OK,"修改文章成功");
        }
        return new Result(flag,StatusCode.ERROR,"修改文章失败");

    }



    /**
     * 新增文章
     * @param blog
     * @return
     */
    @PostMapping("/addBlog")
    @ResponseBody

    //Swagger注解
    @ApiOperation("新增文章")
    //Swagger请求参数的描述
    @ApiImplicitParams({
            @ApiImplicitParam(name = "blog",value = "文章对象，不需要文章id、添加时间、更新时间",required = true,paramType = "body",dataType = "Blog")
    })
    public Result addBlog(@RequestBody Blog blog){

        boolean flag = blogService.addBlog(blog);
        if (flag){

            return new Result(true,StatusCode.OK,"新增文章成功");
        }

        return new Result(false,StatusCode.ERROR,"新增文章失败");
    }

}
