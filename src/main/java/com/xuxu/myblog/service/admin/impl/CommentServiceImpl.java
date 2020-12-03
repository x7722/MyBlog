package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.dao.admin.CommentDao;
import com.xuxu.myblog.entiy.BlogComment;
import com.xuxu.myblog.service.admin.CommentService;
import com.xuxu.myblog.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *  评论管理服务层
 *****/

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    /**
     * 查询 评论 总数
     *
     * @return
     */
    @Override
    public Integer queryCommentCount() {
        return commentDao.findCommentCount();
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public PageResult findPage(String currentPage, String pageSize) {

        Pageable pageable = PageRequest.of(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        Page<BlogComment> page = commentDao.findAll(pageable);

        //获取page结果对象中需要的信息，封装成PageResult对象返回
        long totalElements = page.getTotalElements();//总记录数
        List<BlogComment> pageList = page.getContent();


        return new PageResult(totalElements, pageList);
    }

    /**
     * 通过审核评论
     *
     * @param commentId
     * @return
     */
    @Override
    public boolean recover(Long commentId) {

        Integer count = commentDao.recover(commentId);

        return count > 0;

    }

    /**
     * 取消通过审核
     *
     * @param commentId
     * @return
     */
    @Override
    public boolean stop(long commentId) {

        Integer count = commentDao.stop(commentId);

        return count > 0;
    }

    /**
     * 删除评论
     *
     * @param commentId
     * @return
     */
    @Override
    public boolean delete(long commentId) {

        commentDao.deleteById(commentId);

        return true;
    }

    /**
     * 回复用户评论
     *
     * @param commentId
     * @param replyBody
     * @return
     */
    @Override
    public boolean reply(String commentId, String replyBody) {

        int count = commentDao.replay(Long.parseLong(commentId), replyBody);

        return count > 0;
    }
}
