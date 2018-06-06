package com.paul.logisticsmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/13/2018
 * Time: 10:32 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/index")
public class IndexController {

       // 进入普通用户主页和企业用户页面
    @RequestMapping(value = "/userIndex")
    public  String generalUserIndex(){
        return "/generaluser/home/index";
    }


    // 进入普通用户主页页面
    @RequestMapping(value = "/adminIndex")
    public  String adminIndex(){
        return "/admin/home/index";
    }

    // 进入管理员主页页面
    @RequestMapping(value = "/toAdminHome")
    public  String toAdminHome(){
        return "/admin/home/home";
    }

    // 进入关于我们页面
    @RequestMapping(value = "/toAboutUs")
    public  String toAboutUs(){
        return "/generaluser/company/aboutus";
    }

}
