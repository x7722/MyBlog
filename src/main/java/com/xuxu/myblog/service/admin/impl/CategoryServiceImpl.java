package com.xuxu.myblog.service.admin.impl;

import com.xuxu.myblog.dao.admin.CategoryDao;
import com.xuxu.myblog.entiy.BlogCategory;
import com.xuxu.myblog.service.admin.CategoryService;
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
 *  @date 2020/7/22
 *  Category 博客分类服务层实现
 *****/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 分页查询
     *
     * @param queryPageBean 分页查询对象
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        //获取分页查询的条件
        Integer currentPage = queryPageBean.getCurrentPage();//当前页码
        Integer pageSize = queryPageBean.getPageSize(); //每页显示的个数

        //获取一个Pageable对象
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        //调用JPA中的方法，进行分页查询，获得一个page对象
        Page<BlogCategory> page = categoryDao.findAll(pageable);

        //获取page对象的结果
        long total = page.getTotalElements();//总记录数
        List<BlogCategory> pageList = page.getContent();

        //创建一个分页结果对象，然后返回
        return new PageResult(total, pageList);
    }

    /**
     * 修改分类
     *
     * @param categoryId
     * @param categoryName
     * @return
     */
    @Override
    public Boolean updateCategory(Integer categoryId, String categoryName) {

        int count = categoryDao.updateCategoryById(categoryId, categoryName);

        return count > 0;
    }

    /**
     * 添加分类
     *
     * @param blogCategory
     * @return
     */
    @Override
    public boolean addCategory(BlogCategory blogCategory) {

        blogCategory.setCategoryIcon("/img/category/1");
        blogCategory.setIsDeleted(new Byte("0"));
        blogCategory.setCreateTime(new Date());
        blogCategory.setCategoryRank(1);

        BlogCategory save = categoryDao.save(blogCategory);

        return save != null;
    }

    /**
     * 删除分类
     *
     * @param categoryId
     * @return
     */
    @Override
    public boolean deleteCategory(int categoryId) {

        categoryDao.deleteById(categoryId);

        return true;
    }

    /**
     * 停用分类
     *
     * @param categoryId
     * @return
     */
    @Override
    public boolean stopCategory(int categoryId) {
        //count 受影响的行数
        int count = categoryDao.stopCategoryById(categoryId);
        return count > 0;
    }

    /**
     * 恢复分类
     *
     * @param categoryId
     * @return
     */
    @Override
    public boolean recoverCategory(int categoryId) {

        int count = categoryDao.recoverCategoryById(categoryId);
        return count > 0;
    }

    /**
     * 查询分类总数
     * @return
     */
    @Override
    public Integer queryCategoryCount() {
        return categoryDao.queryCategoryCount();
    }
}
