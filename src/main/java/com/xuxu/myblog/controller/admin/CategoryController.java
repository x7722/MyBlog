package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.entiy.BlogCategory;
import com.xuxu.myblog.entiy.BlogTag;
import com.xuxu.myblog.service.admin.CategoryService;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;
import com.xuxu.myblog.util.Result;
import com.xuxu.myblog.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*****
 *  博客分类
 *  @author Monster Xu
 *  @date 2020/7/22
 *****/

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 访问 Category 页面
     *
     * @return
     */
    @RequestMapping("")
    public String categoryPage() {
        return "admin/category.html";
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
        return categoryService.findPage(queryPageBean);

    }

    /**
     * 根据id修改分类名称
     *
     * @param categoryId 标签id
     * @return Result结果对象
     */
    @RequestMapping("/update/{categoryId}/{categoryName}")
    @ResponseBody
    public Result updateTag(@PathVariable("categoryId") Integer categoryId, @PathVariable("categoryName") String categoryName) {

        System.out.println("标签ID：" + categoryId);
        System.out.println("名称：" + categoryName);

        //调用service层方法，修改标签名称
        Boolean flag = categoryService.updateCategory(categoryId, categoryName);

        if (flag) {
            return new Result(true, StatusCode.OK, "修改分类成功");
        }
        return new Result(false, StatusCode.ERROR, "修改分类失败");
    }


    /**
     * 添加博客分类
     *
     * @param blogCategory
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Result addTags(@RequestBody BlogCategory blogCategory) {
        //调用service层，添加标签
        boolean flag = categoryService.addCategory(blogCategory);
        //判断是否添加成功
        if (flag) {
            return new Result(true, StatusCode.OK, "添加分类成功");
        }
        return new Result(false, StatusCode.ERROR, "添加分类失败");
    }


    /**
     * 根据id删除分类
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping("/delete/{categoryId}")
    @ResponseBody
    public Result deleteTag(@PathVariable String categoryId) {
        //调用service层删除标签
        boolean flag = categoryService.deleteCategory(Integer.parseInt(categoryId));

        //判断是否删除成功
        if (flag) {
            return new Result(true, StatusCode.OK, "删除成功");
        }
        return new Result(false, StatusCode.ERROR, "删除失败");
    }


    /**
     * 根据id停用标签
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping("/stop/{categoryId}")
    @ResponseBody
    public Result stopTag(@PathVariable String categoryId) {

        boolean flag = categoryService.stopCategory(Integer.parseInt(categoryId));

        if (flag) {
            return new Result(true, StatusCode.OK, "停用成功");
        }
        return new Result(false, StatusCode.ERROR, "停用失败");

    }


    /**
     * 根据id恢复标签
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping("/recover/{categoryId}")
    @ResponseBody
    public Result recoverTag(@PathVariable String categoryId) {

        boolean flag = categoryService.recoverCategory(Integer.parseInt(categoryId));

        //判断是否恢复成功
        if (flag) {
            return new Result(true, StatusCode.OK, "恢复成功");
        }
        return new Result(false, StatusCode.ERROR, "恢复失败");
    }


}
