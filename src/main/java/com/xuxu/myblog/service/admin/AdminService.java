package com.xuxu.myblog.service.admin;

import java.util.HashMap;

/*****
 *  @author Monster Xu
 *  @date 2020/7/25
 *****/
public interface AdminService {

    //查询首页中的数据封装到map中
    HashMap<String, Integer> queryPageDate();
}
