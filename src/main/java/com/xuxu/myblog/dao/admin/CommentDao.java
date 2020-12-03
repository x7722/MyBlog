package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  评论留言 dao
 *****/
public interface CommentDao extends JpaRepository<BlogComment,Long> {

    //查询 评论 总数
    @Query("select count(commentId) from BlogComment ")
    Integer findCommentCount();

    //通过审核评论
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogComment set commentStatus=1 where commentId=?1 ")
    Integer recover(Long commentId);

    //取消审核通过
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogComment set commentStatus=0 where commentId=?1 ")
    Integer stop(long commentId);

    //回复用户评论
    @Transactional
    @Modifying  //如果用到 update 或者 delete 必须要加 @Modifying
    @Query(value = "update BlogComment set replyBody=?2 where commentId=?1 ")
    int replay(long parseLong, String replyBody);
}
