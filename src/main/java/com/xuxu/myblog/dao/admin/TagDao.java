package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  标签管理dao层
 *****/

public interface TagDao extends JpaRepository<BlogTag, Integer> {

    //根据id修改标签名称
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogTag set tag_name=?2 where tag_id=?1 ")
    int updateTagById(Integer tagId, String tagName);


    //根据id停用标签
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogTag set isDeleted=1 where tagId=?1")
    int stopTagById(int tagId);

    //根据id恢复标签
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogTag set isDeleted=0 where tagId=?1")
    int recoverTagById(int tagId);

    //查询标签总数
    @Query("select count(tagId) from BlogTag ")
    Integer queryTagsCount();
}
