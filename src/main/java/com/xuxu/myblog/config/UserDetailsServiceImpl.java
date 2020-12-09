package com.xuxu.myblog.config;

import com.xuxu.myblog.dao.admin.AdminUserDao;
import com.xuxu.myblog.dao.admin.RoleDao;
import com.xuxu.myblog.entiy.AdminUser;
import com.xuxu.myblog.entiy.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/*****
 *  用户认证，通过查询数据库中的用户名和密码，完成登录
 *  @author Monster Xu
 *  @date 2020/11/4
 *****/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Autowired
    private RoleDao roleDao;

//    @Autowired
//    private PermisssionDao permissionDao;


    /**
     * 加载用户信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("用户名是：" + username);

        //从数据库中查询用户信息
        AdminUser adminUser = adminUserDao.findUserByUsername(username);

        //返回user对象非空验证
        if (adminUser == null) {
            //如果查询不到用户信息就直接返回空，这个时候就会由Provider来抛出异常
            return null;
        }

        //根据用户Id，获取用户的角色
        List<Role> roleList = findRoleByUserId(adminUser.getId());

        //分别准备一个list用来存储查询到的角色id和角色code(代码)
        ArrayList<String> roleCodes = new ArrayList<>();
        ArrayList<Integer> roleIds = new ArrayList<>();


        //获取所有的角色代码和角色id
        for (Role role : roleList) {
            roleCodes.add(role.getCode());
            roleIds.add(role.getId());
        }



        //根据当前用户的角色，获取当前用户的所有权限
        //String[] permissions = findPermissionByRoleIds(roleIds);

        //将用户角色信息code转换成String[]
        String[] codes = roleCodes.toArray(new String[roleCodes.size()]);


        System.out.println("当前用户：" + adminUser.getNickName() + "所拥有的角色有："+roleCodes.toString()+"变成数组之后是这样的："+Arrays.toString(codes));

        //用获取到的User对象，封装UserDetails对象 (这里是临时封装的一个)      暂时不用权限，直接用角色判断 authorities(permissions)
        UserDetails userDetails = User.withUsername(adminUser.getUsername()).password(adminUser.getPasswd()).roles(codes).build();
        //返回UserDetails对象
        return userDetails;

    }

    /**
     * 根据用户id查询用户所拥有的角色
     *
     * @return 权限数组
     */
    private List<Role> findRoleByUserId(Integer userId) {
        return roleDao.findRoleByUserId(userId);
    }


    /**
     * 根据用户的角色查询用户所拥有的权限
     *
     * @param roleIds
     * @return
     */
//    private String[] findPermissionByRoleIds(List<Integer> roleIds) {
//
//
//        for (Integer roleId : roleIds) {
//            ArrayList<Permission> list = permissionDao.findByRoleId();
//        }
//
//
//        return null;
//    }


}
