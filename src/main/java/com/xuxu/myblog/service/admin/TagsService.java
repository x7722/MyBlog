package com.xuxu.myblog.service.admin;

import com.xuxu.myblog.entiy.BlogTag;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;

import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *
 *  标签服务层接口
 *****/
public interface TagsService {
    //查询所有的博客标签
    List<BlogTag> queryAllTags();

    //根据id修改标签
    Boolean updateTag(Integer tagId, String tagName);

    //分页查询
    PageResult findPage(QueryPageBean queryPageBean);

    //添加标签
    boolean addTag(BlogTag blogTag);

    //根据id删除标签
    boolean deleteTag(int tagId);

    //根据id恢复标签
    boolean recoverTag(int tagId);

    //根据id停用标签
    boolean stopTag(int tagId);

    //查询标签总数
    Integer queryTagsCount();
}
