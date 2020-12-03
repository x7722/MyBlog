package com.xuxu.myblog.service.admin;

import com.xuxu.myblog.entiy.BlogCategory;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;

/*****
 *  @author Monster Xu
 *  @date 2020/7/22
 *  分类 服务层接口
 *****/

public interface CategoryService {
    //分页查询
    PageResult findPage(QueryPageBean queryPageBean);

    //修改分类
    Boolean updateCategory(Integer categoryId, String categoryName);

    //添加分类
    boolean addCategory(BlogCategory blogCategory);

    //根据id删除分类
    boolean deleteCategory(int categoryId);

    //根据id停用分类
    boolean stopCategory(int categoryId);

    //根据id恢复分类
    boolean recoverCategory(int categoryId);

    //查询 分类 总数
    Integer queryCategoryCount();
}
