package com.xuxu.my_blog;

import com.xuxu.myblog.MyBlogApplication;
import com.xuxu.myblog.controller.admin.LinkController;
import com.xuxu.myblog.entiy.BlogLink;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * SpringBoot 单元测试
 *
 */

//固定写法
@RunWith(SpringRunner.class)
//固定写法，这里的classes要指定启动器的class文件
@SpringBootTest(classes = MyBlogApplication.class)
class SpringbootSecurityOauth2ApplicationTests {

    /** 注入接口对象(接口指针？) */
    @Autowired
    private LinkController linkController;

    @Test
    void testLinkController(){
        //创建友情链接对象，用于添加数据到数据库中
        BlogLink blogLink = new BlogLink();
        blogLink.setLinkName("淘宝网");
        blogLink.setLinkUrl("www.taobao.com");
        blogLink.setLinkDescription("剁手花钱月光族");
        blogLink.setIsDeleted(0);
        blogLink.setLinkRank(0);
        blogLink.setLinkType(0);
        //调用接口中的方法(函数)，测试添加友情链接的接口
        linkController.add(blogLink);
    }






    @Test
    void contextLoads() {

        //使用BCrypt加密密码，参数一：原密码  参数二：加盐
        //$2a$10$lvT/RXG8uRbXJFm22tEJfeR2cGk2Q4iDMhmP96WLmp/PurbnUuFAu
        //$2a$10$hjbsf5I.HYv9dXD3E.zga.ncQOgAMBFeowgB1tK5qLTquSe77.1eq
        String pass = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(pass);

    }

    @Test
    void test1(){

        //适应BCrypt验证密码 参数一：输入的密码  参数二：加密的密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$w88zDNTGtU4xfhT4du0/xue.YfpSKncVZMpgb/jN/rhyqlaymTyqO");
        System.out.println(checkpw);
    }


    @Test
    public void teset2(){

        //System.out.println(renturnStr());
        //System.out.println(renturnInt());

        HashMap map = returnMap();
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
    }



    public String renturnStr(){

        String str = "123";

        try{
            str = "456";
            //int a = 1/0;
            return str;
        }catch (Exception e){

            str = "555";
            return str;
        }finally {
            str = "666";
        }

    }


    public int renturnInt(){

        int a = 123;

        try{
            a = 456;
            //int b = 1/0;
            return a;
        }catch (Exception e){

            a = 555;
            return a;


        }finally {

            a = 666;
        }

    }



    public HashMap<String, Object> returnMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);

        try {
            return map;
        }catch (Exception e){

            map.put("c",3);
            return map;
        }finally {

            map.put("d",1);

        }
    }




}
