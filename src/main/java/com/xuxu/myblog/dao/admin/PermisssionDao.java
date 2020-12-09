package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.Permission;
import com.xuxu.myblog.entiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*****
 *  权限管理 dao
 *  @author Monster Xu
 *  @date 2020/12/3
 *****/
public interface PermisssionDao extends JpaRepository<Permission, Integer> {

}
