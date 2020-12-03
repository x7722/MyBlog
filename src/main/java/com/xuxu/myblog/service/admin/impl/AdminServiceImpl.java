package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.service.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *  admin服务层实现
 *****/
@Service
public class AdminServiceImpl implements AdminService {

    //注入 文章服务层
    @Autowired
    private BlogService blogService;

    //注入 评论服务层
    @Autowired
    private CommentService commentService;

    //注入 分类服务层
    @Autowired
    private CategoryService categoryService;

    //注入 标签服务层
    @Autowired
    private TagsService tagsService;

    //注入 友情链接服务层
    @Autowired
    private LinkService linkService;

    /**
     * 查询首页中的数据封装到map中
     * @return map
     */
    @Override
    public HashMap<String, Integer> queryPageDate() {
        //查询文章总数
        Integer blogCount = blogService.queryBlogCount();

        //查询评论总数
        Integer commentCount = commentService.queryCommentCount();

        //查询分类总数
        Integer categoryCount = categoryService.queryCategoryCount();

        //查询标签总数
        Integer tagCount = tagsService.queryTagsCount();

        //查询友情链接总数
        Integer linkCount = linkService.queryLinkCount();

        HashMap<String, Integer> map = new HashMap<>();
        //封装数据
        map.put("blogCount",blogCount);
        map.put("commentCount",commentCount);
        map.put("categoryCount",categoryCount);
        map.put("tagCount",tagCount);
        map.put("linkCount",linkCount);

        System.out.println(map);

        //返回map
        return map;
    }
}
