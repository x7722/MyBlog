package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *  admin 管理 Dao
 *****/
public interface AdminDao  extends JpaRepository<AdminUser, Integer> {



}
