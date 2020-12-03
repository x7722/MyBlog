package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.dao.admin.BlogDao;
import com.xuxu.myblog.entiy.Blog;
import com.xuxu.myblog.service.admin.BlogService;
import com.xuxu.myblog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  文章（博客）管理服务层
 *****/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    /**
     * 查询文章总数
     *
     * @return
     */
    @Override
    public Integer queryBlogCount() {
        return blogDao.findBlogCount();
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int currentPage, int pageSize) {

        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Blog> page = blogDao.findAll(pageable);

        //获取page结果对象中需要的信息，封装成PageResult对象返回
        long totalElements = page.getTotalElements();//总记录数
        List<Blog> pageList = page.getContent();


        return new PageResult(totalElements, pageList);
    }

    /**
     * 发布文章
     *
     * @param blogId
     * @return
     */
    @Override
    public boolean push(Long blogId) {
        int count = blogDao.push(blogId);
        return count > 0;
    }

    /**
     * 关闭文章
     *
     * @param blogId
     * @return
     */
    @Override
    public boolean stop(Long blogId) {
        int count = blogDao.stop(blogId);
        return count > 0;
    }

    /**
     * 彻底删除文章
     *
     * @param blogId
     * @return
     */
    @Override
    public boolean delete(Long blogId) {
        blogDao.deleteById(blogId);
        return true;
    }


    /**
     * 恢复逻辑删除的文章
     *
     * @param blogId
     * @return
     */
    @Override
    public boolean recover(Long blogId) {

        int count = blogDao.recover(blogId);

        return count > 0;
    }

    /**
     * 逻辑删除文章
     *
     * @param blogId
     * @return
     */
    @Override
    public boolean isDelete(Long blogId) {

        int count = blogDao.isDelete(blogId);
        return count > 0;
    }

    /**
     * 根据id查询文章
     *
     * @param blogId 文章id
     * @return
     */
    @Override
    public Blog findBlogById(Long blogId) {

        //根据id查询对应的文章信息
        Optional<Blog> optional = blogDao.findById(blogId);

        //判断是否有值
        if (optional.isPresent()) {
            Blog blog = optional.get();
            return blog;
        }

        //没有值返回空
        return null;
    }

    /**
     * 修改文章
     *
     * @param blog
     * @return
     */
    @Override
    public boolean editBlog(Blog blog) {

        Long id = blog.getBlogId();
        String blogTitle = blog.getBlogTitle();
        String blogTags = blog.getBlogTags();
        String blogCategoryName = blog.getBlogCategoryName();
        String blogContent = blog.getBlogContent();

        Date updateTime = new Date();

        int count = blogDao.updateBlog(id, blogTitle, blogTags, blogCategoryName, blogContent, updateTime);

        return count > 0;
    }

    /**
     * 新增文章
     *
     * @param blog
     */
    @Override
    public boolean addBlog(Blog blog) {

        blog.setBlogSubUrl(blog.getBlogCategoryName());
        //目前固定写，以后在修改
        blog.setBlogCoverImage("/img/rand/1.jpg");
        blog.setBlogCategoryId(24);

        blog.setBlogStatus(new Byte("0"));
        blog.setBlogViews(0L);
        blog.setEnableComment(new Byte("0"));
        blog.setIsDeleted(new Byte("0"));
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());

        Blog flush = blogDao.saveAndFlush(blog);

        if (flush != null) {
            return true;
        }
        return false;

    }
}
