package com.xuxu.myblog.service.admin;

import com.xuxu.myblog.entiy.Blog;
import com.xuxu.myblog.util.PageResult;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *  文章(博客) 服务层接口
 *****/
public interface BlogService {
    //查询文章总数
    Integer queryBlogCount();

    //分页查询
    PageResult findPage(int currentPage, int pageSize);

    //发布文章
    boolean push(Long blogId);

    //关闭文章
    boolean stop(Long blogId);

    //删除文章
    boolean delete(Long blogId);

    //恢复删除文章
    boolean recover(Long blogId);

    //逻辑删除文章
    boolean isDelete(Long blogId);

    //根据id查询文章
    Blog findBlogById(Long blogId);

    //修改文章
    boolean editBlog(Blog blog);

    //新增文章
    boolean addBlog(Blog blog);
}
