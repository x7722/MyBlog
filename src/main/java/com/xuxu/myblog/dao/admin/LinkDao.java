package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.BlogLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  友情链接dao
 *****/
public interface LinkDao extends JpaRepository<BlogLink, Integer> {

    //查询友情链接总数
    @Query("select count(linkId) from BlogLink ")
    Integer queryLinkCount();
}
