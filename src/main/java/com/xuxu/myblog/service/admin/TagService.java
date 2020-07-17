package com.xuxu.myblog.service.admin;

import com.xuxu.myblog.entiy.BlogTag;

import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *
 *  标签服务层接口
 *****/
public interface TagService {
    //查询所有的博客标签
    List<BlogTag> queryAllTags();
}
