package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.BlogCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/*****
 *  @author Monster Xu
 *  @date 2020/7/22
 *
 *  博客分类 dao接口
 *****/
public interface CategoryDao extends JpaRepository<BlogCategory, Integer> {

    //根据id修改分类名称
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogCategory set categoryName=?2 where categoryId=?1 ")
    int updateCategoryById(Integer categoryId, String categoryName);

    //根据id停用标签
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogCategory set isDeleted=1 where categoryId=?1")
    int stopCategoryById(int categoryId);

    //根据id恢复标签
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogCategory set isDeleted=0 where categoryId=?1")
    int recoverCategoryById(int categoryId);


    //查询分类总数
    @Query("select count(categoryId) from BlogCategory ")
    Integer queryCategoryCount();
}
