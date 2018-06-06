package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.service.impl.UpdateInformationServiceImpl;
import com.paul.logisticsmanagementsystem.util.FileManager;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/17/2018
 * Time: 1:54 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/updateInformation")
public class UpdateInformationController {


    @Autowired
    private UpdateInformationServiceImpl updateInformationServiceImpl;


    // 进入修改个人资料页面
    @RequestMapping(value = "/toUpdateAccount")
    public  String toUpdateAccount(){
        return "/generaluser/updateInformation/UpdateAccount";
    }

    // 执行修改个人资料操作
    @RequestMapping(value = "/updateAccount", method = { RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateAccount(GeneralUser generalUser,HttpServletRequest httpServletRequest, MultipartFile file) throws Exception{
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, file);
            generalUser.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=updateInformationServiceImpl.updateAccountByPrimaryKeySelective(generalUser,httpServletRequest);
        return generalUserResponse;
    }


    // 进入修改个人密码页面
    @RequestMapping(value = "/toUpdatePassword")
    public  String toUpdatePassword(){
        return "/generaluser/updateInformation/UpdatePassword";
    }
    @RequestMapping(value = "/toUpdateAdminPassword")
    public  String toUpdateAdminPassword(){
        return "/admin/manageUser/updateAdminPassword";
    }
    @RequestMapping(value = "/toUpdateAdminInfo")
    public  String toUpdateAdminInfo(){
        return "/admin/manageUser/updateAdminInfo";
    }
    // 执行修改密码操作
    @RequestMapping(value = "/updatePassword" , method = { RequestMethod.POST})
    @ResponseBody

    public GeneralUserResponse updatePassword(GeneralUser generalUser,String oldPassword) throws  Exception {
        GeneralUserResponse generalUserResponse=updateInformationServiceImpl.updatePasswordByPrimaryKeySelective(generalUser,oldPassword);
        return generalUserResponse;
    }

    // 执行修改密码操作
    @RequestMapping(value = "/updateAdminPassword" , method = { RequestMethod.POST})
    @ResponseBody
    public AdminResponse updateAdminPassword(Admin admin, String oldPassword) throws Exception{
        AdminResponse adminResponse=updateInformationServiceImpl.updateAdminPassword(admin,oldPassword);
        return adminResponse;
    }

    // 执行修改管理员信息操作
    @RequestMapping(value = "/updateAdminInfo" , method = { RequestMethod.POST})
    @ResponseBody
    public AdminResponse updateAdminInfo(Admin admin, HttpServletRequest httpServletRequest, MultipartFile file) throws  Exception{
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, file);
            admin.setPhoto(allfilename);
        }
        AdminResponse adminResponse=updateInformationServiceImpl.updateAdminInfo(admin,httpServletRequest);
        return adminResponse;
    }




}
