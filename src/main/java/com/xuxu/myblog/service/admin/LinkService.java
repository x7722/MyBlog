package com.xuxu.myblog.service.admin;

import com.xuxu.myblog.entiy.BlogLink;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  友情链接管理 服务层接口
 *****/
public interface LinkService {
    //查询友情链接总数
    Integer queryLinkCount();

    //分页查询
    PageResult findPage(QueryPageBean queryPageBean);

    //添加链接
    boolean add(BlogLink blogLink);

    //修改链接
    boolean update(BlogLink blogLink);

    //删除链接
    void delete(String linkId);
}
