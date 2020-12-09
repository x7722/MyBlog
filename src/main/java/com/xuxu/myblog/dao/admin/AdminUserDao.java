package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*****
 *  后台管理员dao
 *  @author Monster Xu
 *  @date 2020/7/25
 *
 *****/
public interface AdminUserDao extends JpaRepository<AdminUser, Integer> {


    /**
     * 根据username查询user信息
     * @param username
     * @return
     */
    @Query(value = "select * from tb_admin_user where username=?1",nativeQuery = true)
    AdminUser findUserByUsername(String username);
}
