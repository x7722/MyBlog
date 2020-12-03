package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.entiy.BlogLink;
import com.xuxu.myblog.service.admin.LinkService;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;
import com.xuxu.myblog.util.Result;
import com.xuxu.myblog.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *****/
@Controller
@RequestMapping("/admin/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    /**
     * 访问link 友情链接 页面
     *
     * @return
     */
    @RequestMapping("")
    public String goPage() {
        return "admin/link.html";
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
        return linkService.findPage(queryPageBean);
    }


    /**
     * 添加链接
     *
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody BlogLink blogLink) {
        boolean flag = linkService.add(blogLink);
        if (flag) {
            System.out.println(blogLink);
            return new Result(true, StatusCode.OK, "添加链接成功");
        }
        return new Result(false, StatusCode.ERROR, "添加链接失败");


    }


    /**
     * 修改链接
     *
     * @param blogLink
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody BlogLink blogLink) {

        boolean flag = linkService.update(blogLink);

        if (flag) {
            return new Result(true, StatusCode.OK, "修改链接成功");
        }
        return new Result(false, StatusCode.ERROR, "修改链接失败");
    }

    /**
     * 删除链接
     *
     * @param linkId
     * @return
     */
    @DeleteMapping("/delete/{linkId}")
    @ResponseBody
    public Result delete(@PathVariable String linkId) {

        linkService.delete(linkId);
        return new Result(true, StatusCode.OK, "删除成功");
    }
}
