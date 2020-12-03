package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.dao.admin.TagDao;
import com.xuxu.myblog.entiy.BlogTag;
import com.xuxu.myblog.service.admin.TagsService;
import com.xuxu.myblog.util.PageResult;
import com.xuxu.myblog.util.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  标签服务层实现
 *****/

@Service
public class TagsServiceImpl implements TagsService {

    //注入Tag dao层
    @Autowired
    private TagDao tagDao;

    /**
     * 查询所有的博客标签
     *
     * @return
     */
    @Override
    public List<BlogTag> queryAllTags() {
        List<BlogTag> list = tagDao.findAll();
        return list;
    }

    /**
     * 根据id修改标签名称
     *
     * @param tagId
     * @param tagName
     * @return
     */
    @Override
    public Boolean updateTag(Integer tagId, String tagName) {

        int count = tagDao.updateTagById(tagId, tagName);

        //判断受影响的行数是否大于0
        return count > 0;

    }

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        //获取前端传递过来的分页参数
        Integer pageSize = queryPageBean.getPageSize(); //每页显示的个数
        Integer currentPage = queryPageBean.getCurrentPage();   //当前页码

        //使用JPA的分页查询方法，获取一个PageRequest对象
        Pageable pageRequest = PageRequest.of(currentPage, pageSize);

        //使用JPA，调用接口中的分页查询方法，获取Page对象，Page对象中封装的有分页查询的结果
        Page<BlogTag> page = tagDao.findAll(pageRequest);

        //获取page对象的结果
        long totalElements = page.getTotalElements();//总记录数
        List<BlogTag> pageList = page.getContent();

        //创建一个分页查询返回的对象
        return new PageResult(totalElements, pageList);

    }

    /**
     * 添加标签
     *
     * @param blogTag 标签对象
     * @return
     */
    @Override
    public boolean addTag(BlogTag blogTag) {

        //设置状态未删除
        blogTag.setIsDeleted(new Byte("0"));
        //设置添加时间
        blogTag.setCreateTime(new Date());
        //调用dao层的方法，添加标签
        BlogTag save = tagDao.save(blogTag);

        System.out.println(save);

        return save != null;

    }

    /**
     * 根据id删除标签,实际是将 idDelete 字段改成1
     *
     * @param tagId
     * @return
     */
    @Override
    public boolean deleteTag(int tagId) {
        //count 受影响的行数
        tagDao.deleteById(tagId);
        return true;
    }

    /**
     * 根据id恢复标签
     * @param tagId
     * @return
     */
    @Override
    public boolean recoverTag(int tagId) {

        int count = tagDao.recoverTagById(tagId);

        return count > 0;
    }

    /**
     * 根据id停用标签
     * @param tagId
     * @return
     */
    @Override
    public boolean stopTag(int tagId) {
        //count 受影响的行数
        int count = tagDao.stopTagById(tagId);
        return count > 0;

    }

    /**
     * 查询标签总数
     * @return
     */
    @Override
    public Integer queryTagsCount() {
        return tagDao.queryTagsCount();
    }


}
