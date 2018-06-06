package com.paul.logisticsmanagementsystem.controller;





import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.service.impl.LoginRegisterServiceImpl;
import com.paul.logisticsmanagementsystem.util.FileManager;
import com.paul.logisticsmanagementsystem.util.Request.AdminRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/userLoginRegister")
public class LoginRegisterController {

    @Autowired
    private LoginRegisterServiceImpl loginRegisterServiceImpl;

    // 进入用户的登录页面
    @RequestMapping(value = "/toAdminRegister")
    public  String toAdminRegister(){
        return "/admin/loginRegister/register";
    }

    // 进入用户的登录页面
    @RequestMapping(value = "/toUserLogin")
    public  String toGenaralUserLogin(){
        return "/generaluser/loginRegister/login";
     }

    // 执行普通用户的登录
    @RequestMapping(value = "/genaralUserLogin", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse genaralUserLogin(GeneralUser generalUser, HttpServletRequest httpServletRequest) throws  Exception{
        GeneralUserResponse generalUserResponse=loginRegisterServiceImpl.doLogin(generalUser,httpServletRequest);
        return  generalUserResponse;
    }
    // 进入普通用户注册页面
    @RequestMapping(value = "/toGenaralUserRegister")
    public  String toGenaralUserRegister(){
        return "/generaluser/loginRegister/register";
    }

    // 执行普通用户的注册
    @RequestMapping(value = "/adminRegister", method = { RequestMethod.POST })
    @ResponseBody
    public AdminResponse adminRegister(HttpServletRequest httpServletRequest, MultipartFile file,Admin admin) throws  Exception{
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, file);
            admin.setPhoto(allfilename);
        }
        AdminResponse adminResponse=loginRegisterServiceImpl.doAdminRegister(admin);
        return  adminResponse;

    }


    // 执行普通用户的注册
    @RequestMapping(value = "/genaralUserRegister", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse genaralUserRegister(GeneralUser generalUser,HttpServletRequest httpServletRequest, MultipartFile file) throws  Exception{
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, file);
            generalUser.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=loginRegisterServiceImpl.doRegister(generalUser,httpServletRequest);
        return  generalUserResponse;

    }



     //普通用户登出
    @RequestMapping(value = "/genaralUserLogout")
    public String genaralUserLogout(HttpServletRequest request, GeneralUser generalUser) throws Exception {
        loginRegisterServiceImpl.doLogout(request, generalUser);
        return "/generaluser/home/index";
    }


    // 进入管理员的登录界面
    @RequestMapping(value = "/toAdminLogin")
    public  String toAdminLogin(){
        return "/admin/loginRegister/login";
    }



    // 执行管理员的登录

    @RequestMapping(value = "/adminLogin", method = { RequestMethod.POST})
    @ResponseBody
    public Response adminLogin(HttpServletRequest httpServletRequest,Admin admin) throws  Exception{
        AdminResponse adminResponse=loginRegisterServiceImpl.doLogin(httpServletRequest,admin);
        return  adminResponse;
    }

    @RequestMapping(value = "/resetPassword", method = {RequestMethod.POST})
    @ResponseBody
    public AdminResponse resetPassword(Admin admin) throws  Exception{
        AdminResponse adminResponse=loginRegisterServiceImpl.resetPassword(admin);
        return  adminResponse;
    }

    //管理员登出
    @RequestMapping(value = "/adminLogout")
    public String genaralUserLogout(HttpServletRequest request, Admin admin) throws Exception {
        loginRegisterServiceImpl.doLogout(request, admin);
        return "/admin/loginRegister/login";
    }







}
