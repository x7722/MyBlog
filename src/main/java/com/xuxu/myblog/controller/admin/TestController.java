package com.xuxu.myblog.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*****
 *  @author Monster Xu
 *  @date 2020/11/17
 *****/
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/1")
    public String test1(){
        return "哈哈哈😄😄😄😄😄😄😄😄😄😄😄，应该是可以的吧！！";
    }
}
