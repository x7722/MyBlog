package com.xuxu.myblog.dao.admin;

import com.xuxu.myblog.entiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*****
 *  角色管理 dao
 *  @author Monster Xu
 *  @date 2020/12/3
 *****/
public interface RoleDao extends JpaRepository<Role,Integer> {

    /**
     * 根据userId查询当前用户的所有角色信息，返回所有的角色对象
     * @param userId
     * @return
     */
    @Query(value = "select r.* from tb_admin_role r, tb_admin_user_and_role ur where r.id=ur.role_id and ur.user_id=?1",nativeQuery = true)
    List<Role> findRoleByUserId(Integer userId);
}
