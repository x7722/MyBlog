package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.BlogTag;
import org.springframework.data.jpa.repository.JpaRepository;


/*****
 *  @author Monster Xu
 *  @date 2020/7/17
 *  标签管理dao层
 *****/
public interface TagDao extends JpaRepository<BlogTag, Integer> {

}
