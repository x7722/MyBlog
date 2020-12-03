package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  博客文章 dao
 *****/
public interface BlogDao extends JpaRepository<Blog,Long> {

    //查询文章 总数
    @Query("select count(blogId) from Blog ")
    Integer findBlogCount();

    //发布文章
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update Blog set blogStatus=1 where blogId=?1 ")
    int push(Long blogId);


    //关闭文章
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update Blog set blogStatus=0 where blogId=?1 ")
    int stop(Long blogId);

    //逻辑删除文章
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update Blog set isDeleted=1,blogStatus=0 where blogId=?1 ")
    int isDelete(Long blogId);

    //恢复逻辑删除的文章
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update Blog set isDeleted=0,blogStatus=0 where blogId=?1 ")
    int recover(Long blogId);

    //修改文章内容
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update Blog set blogTitle=?2,blogTags=?3,blogCategoryName=?4,blogContent=?5,updateTime=?6 where blogId=?1 ")
    int updateBlog(Long id, String blogTitle, String blogTags, String blogCategoryName, String blogContent, Date updateTime);
}
