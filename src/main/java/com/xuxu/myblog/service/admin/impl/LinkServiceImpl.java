package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.dao.admin.LinkDao;
import com.xuxu.myblog.entiy.BlogLink;
import com.xuxu.myblog.service.admin.LinkService;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *  友情链接服务层
 *****/
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkDao linkDao;

    /**
     * 查询友情链接总数
     *
     * @return
     */
    @Override
    public Integer queryLinkCount() {

        return linkDao.queryLinkCount();
    }

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        //获取分页查询参数
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();

        //获取分页查询对象 pageRequest
        PageRequest of = PageRequest.of(currentPage, pageSize);
        //调用dao的方法进行分页查询
        Page<BlogLink> page = linkDao.findAll(of);

        //获取page结果对象中需要的信息，封装成PageResult对象返回
        long totalElements = page.getTotalElements();//总记录数
        List<BlogLink> pageList = page.getContent();

        //返回数据
        return new PageResult(totalElements, pageList);
    }


    /**
     * 添加链接
     *
     * @param blogLink
     * @return
     */
    @Override
    public boolean add(BlogLink blogLink) {
        blogLink.setIsDeleted(0);
        blogLink.setCreateTime(new Date());
        linkDao.save(blogLink);
        return true;
    }

    /**
     * 修改链接
     *
     * @param blogLink
     * @return
     */
    @Override
    public boolean update(BlogLink blogLink) {

        BlogLink save = linkDao.save(blogLink);

        if (save != null) {
            return true;
        }
        return false;
    }

    /**
     * 删除链接
     *
     * @param linkId
     * @return
     */
    @Override
    public void delete(String linkId) {
        linkDao.deleteById(Integer.parseInt(linkId));
    }
}
