package com.xuxu.myblog.service.admin;

import com.xuxu.myblog.util.PageResult;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  评论管理 服务层接口
 *****/
public interface CommentService {

    //查询评论总数
    Integer queryCommentCount();

    //分页查询
    PageResult findPage(String currentPage,String pageSize);

    //通过审核评论
    boolean recover(Long commentId);

    //取消通过审核
    boolean stop(long commentId);

    //删除评论
    boolean delete(long commentId);

    //回复用户评论
    boolean reply(String commentId, String replyBody);
}
