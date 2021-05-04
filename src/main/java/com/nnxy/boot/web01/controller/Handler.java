package com.nnxy.boot.web01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：MengYinChang
 * @create at: 2021-04-29  21:00
 */
@RestController
public class Handler {

    /**
     * 请求进来，先去找Controller看能不能处理。
     * 不能处理的所有请求又都交给静态资源处理器。静态资源也找不到则响应404页面
     * @return
     */
    @RequestMapping(value = "/icon.jpg")
    public String hello() {
        return "haha";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String get_rest(){
        return "rest风格，get";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String post_rest(){
        return "rest风格，post";
    }
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String delete_rest(){
        return "rest风格，DELETE";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String put_rest(){
        return "rest风格，put";
    }
}