package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.dao.admin.TagDao;
import com.xuxu.myblog.entiy.BlogTag;
import com.xuxu.myblog.service.admin.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  标签服务层实现
 *****/

@Service
public class TagServiceImpl implements TagService {

    //注入Tag dao层
    @Autowired
    private TagDao tagDao;

    /**
     * 查询所有的博客标签
     * @return
     */
    @Override
    public List<BlogTag> queryAllTags() {

        List<BlogTag> list = tagDao.findAll();

        return list;
    }
}
