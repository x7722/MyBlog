package com.xuxu.myblog.controller.admin;

import com.xuxu.myblog.entiy.BlogComment;
import com.xuxu.myblog.service.admin.CommentService;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.Result;
import com.xuxu.myblog.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  评论管理控制层
 *****/

@Controller
@RequestMapping("/admin/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    /**
     * 访问comment 评论页面
     * @return
     */
    @RequestMapping("")
    public String goPage() {
        return "admin/comment.html";
    }

    /**
     * 分页查询评论信息
     * @return
     */
    @RequestMapping("/findPage/{currentPage}/{pageSize}")
    @ResponseBody
    public PageResult findPage(@PathVariable String currentPage, @PathVariable String pageSize){
        return commentService.findPage(currentPage,pageSize);
    }

    /**
     * 审核通过
     * @param commentId
     * @return
     */
    @PutMapping("/recover/{commentId}")
    @ResponseBody
    public Result recover(@PathVariable String commentId){

        boolean flag = commentService.recover(Long.parseLong(commentId));

        if (flag){
            return new Result(true, StatusCode.OK,"审核通过");
        }
        return new Result(false, StatusCode.ERROR,"审核失败");
    }

    /**
     * 取消审核通过
     * @param commentId
     * @return
     */
    @PutMapping("/stop/{commentId}")
    @ResponseBody
    public Result stop(@PathVariable String commentId){

        boolean flag = commentService.stop(Long.parseLong(commentId));

        if (flag){
            return new Result(true, StatusCode.OK,"审核通过");
        }
        return new Result(false, StatusCode.ERROR,"审核失败");
    }


    /**
     * 删除评论
     * @param commentId
     * @return
     */
    @DeleteMapping("/delete/{commentId}")
    @ResponseBody
    public Result delete(@PathVariable String commentId){

        boolean flag = commentService.delete(Long.parseLong(commentId));

        if (flag){
            return new Result(true, StatusCode.OK,"删除评论成功");
        }
        return new Result(false, StatusCode.ERROR,"删除评论失败");
    }


    /**
     * 回复用户消息
     * @param blogComment
     * @return
     */
    @PostMapping("/reply/{commentId}")
    @ResponseBody
    public Result reply(@PathVariable String commentId, @RequestBody BlogComment blogComment){

        //获取回复的信息
        String replyBody = blogComment.getReplyBody();

        System.out.println(replyBody);

        //调用服务成的方法，回复用户
        boolean flag = commentService.reply(commentId,replyBody);

        if (flag){
            return new Result(true, StatusCode.OK,"回复成功");
        }
        return new Result(false, StatusCode.OK,"回复失败");
    }
}
