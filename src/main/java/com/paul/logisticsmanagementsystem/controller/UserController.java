package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.service.impl.UserServiceImpl;
import com.paul.logisticsmanagementsystem.util.FileManager;
import com.paul.logisticsmanagementsystem.util.Request.AdminRequest;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/4/2018
 * Time: 12:42 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;



   /*个人用户管理*/
    // 进入管理个人用户界面
    @RequestMapping(value = "/manageUser",method = RequestMethod.GET)
    public  String generalUserIndex(){
        return "/admin/manageUser/manageGeneralUser";
    }

    //获取所有个人用户信息
    @RequestMapping(value = "/getAllGeneralUsers",method = RequestMethod.POST)
    @ResponseBody
    public GeneralUserResponse getAllGeneralUsers(GeneralUserRequest generalUserRequest,GeneralUser generalUser){
        GeneralUserResponse generalUserResponse=userServiceImpl.getAllGeneralUsers(generalUserRequest,generalUser);
        return  generalUserResponse;

    }
      //获取一个具体的个人用户信息
      @RequestMapping(value = "/getSelectiveGeneralUsers",method = RequestMethod.POST)
      @ResponseBody
      public GeneralUserResponse getSelectiveGeneralUsers(GeneralUser generalUser,GeneralUserRequest generalUserRequest){
          GeneralUserResponse generalUserResponse=userServiceImpl.getSelectiveGeneralUser(generalUser,generalUserRequest);
          return  generalUserResponse;

      }


    //获取一个个人用户信息（post）
    @RequestMapping(value = "/getGeneralUser",method = RequestMethod.POST)
    @ResponseBody
    public GeneralUserResponse getGeneralUser(GeneralUser generalUser, HttpServletRequest httpServletRequest){
        GeneralUserResponse generalUserResponse= userServiceImpl.selectByPrimaryKey(generalUser,httpServletRequest);
        return  generalUserResponse;
    }

    //跳转到单个个人用户界面(get)
    @RequestMapping(value = "/toGeneralUserGet", method = RequestMethod.GET)
    public  String toGeneralUserGet(){
        return "/admin/manageUser/singleGeneralUser";
    }

    //跳转到单个个人用户界面
    @RequestMapping(value = "/toGeneralUser", method = RequestMethod.POST)
    public  String toGeneralUser(){
        return "/admin/manageUser/singleGeneralUser";
    }
    //修改个人用户信息
    @RequestMapping(value = "/modifyGeneralUser",method = RequestMethod.POST)
    @ResponseBody
    public GeneralUserResponse  modifyGeneralUser(GeneralUser generalUser,HttpServletRequest httpServletRequest, MultipartFile file) throws Exception{
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, file);
            generalUser.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=userServiceImpl.updateByPrimaryKey(generalUser,httpServletRequest);
        return generalUserResponse;
    }
    //删除个人信息
    @RequestMapping(value = "/deleteGeneralUser",method = RequestMethod.POST)
    @ResponseBody
    public GeneralUserResponse  deleteGeneralUser(GeneralUser generalUser){
        GeneralUserResponse generalUserResponse=userServiceImpl.deleteByPrimaryKey(generalUser);
        return generalUserResponse;
    }
    //增加个人信息
    @RequestMapping(value = "/addGeneralUser",method = RequestMethod.POST)
    @ResponseBody
    public  GeneralUserResponse addGeneralUser(GeneralUser generalUser,HttpServletRequest httpServletRequest,MultipartFile multipartFile) throws  Exception{
        if(multipartFile.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, multipartFile);
            generalUser.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=userServiceImpl.insert(generalUser,httpServletRequest);
        return  generalUserResponse;
    }

    /*管理员管理*/
    // 进入管理个人用户界面
    @RequestMapping(value = "/manageAdmin",method = RequestMethod.GET)
    public  String manageAdmin(){
        return "/admin/manageUser/manageAdmin";
    }

    @RequestMapping(value = "/toSingleAdmin",method = RequestMethod.POST)
    public  String toManageAdmin(){
        return "/admin/manageUser/singleAdmin";
    }

    @RequestMapping(value = "/tomanageAdminDetail",method = RequestMethod.POST)
    public  String tomanageAdminDetail(){
        return "/admin/manageUser/manageAdminDetail";
    }

    @RequestMapping(value = "/getAllAdmins",method = RequestMethod.POST)
    @ResponseBody
    public AdminResponse getAllAdmins(AdminRequest adminRequest,Admin admin){
        AdminResponse adminResponse=userServiceImpl.getAllAdmins(adminRequest,admin);
        return  adminResponse;

    }

    @RequestMapping(value = "/getAdmin",method = RequestMethod.POST)
    @ResponseBody
    public AdminResponse getAdmin(Admin admin, HttpServletRequest httpServletRequest){
        AdminResponse adminResponse=userServiceImpl.selectByPrimaryKeyAdmin(admin,httpServletRequest);
        return  adminResponse;
    }



    //删除个人信息
    @RequestMapping(value = "/deleteAdmin",method = RequestMethod.POST)
    @ResponseBody
    public AdminResponse  deleteAdmin(Admin admin){
        AdminResponse adminResponse=userServiceImpl.deleteByPrimaryKeyAdmin(admin);
        return adminResponse;
    }

    //修改个人用户信息
    @RequestMapping(value = "/modifyAdmin",method = RequestMethod.POST)
    @ResponseBody
    public AdminResponse  modifyAdmin(Admin admin ,HttpServletRequest httpServletRequest){
        AdminResponse adminResponse=userServiceImpl.updateByPrimaryKey(admin,httpServletRequest);
        return adminResponse;
    }

    //增加个人信息
    @RequestMapping(value = "/addAdmin",method = RequestMethod.POST)
    @ResponseBody
    public  AdminResponse addAdmin(Admin admin){
        AdminResponse adminResponse=userServiceImpl.insert(admin);
        return adminResponse;
    }

    //管理权限信息

    @RequestMapping(value = "/toManageAdminAuthority")
    public  String toManageAdminAuthority(){
        return "/admin/manageAuthority/manageAdminAuthority";
    }

    @RequestMapping(value = "/toManageUserAuthority")
    public  String toManageUserAuthority(){
        return "/admin/manageAuthority/manageUserAuthority";
    }

    @RequestMapping(value = "/toSingleUserAuthority")
    public  String toSingleUserAuthority(){
        return "/admin/manageAuthority/singleUserAuthority";
    }
    @RequestMapping(value = "/toSingleAdminAuthority")
    public  String toSingleAdminAuthority(){
        return "/admin/manageAuthority/singleAdminAuthority";
    }

    //删除个人信息
    @RequestMapping(value = "/manageAdminAuthority",method = RequestMethod.POST)
    @ResponseBody
    public AdminResponse  manageAdminAuthority(Admin admin,HttpServletRequest httpServletRequest){
        AdminResponse adminResponse=userServiceImpl.updateByPrimaryKey(admin,httpServletRequest);
        return adminResponse;
    }


    @RequestMapping(value = "/updateUserLoginState",method = RequestMethod.POST)
    @ResponseBody
    public GeneralUserResponse  updateUserLoginState(GeneralUser generalUser){
        GeneralUserResponse generalUserResponse=userServiceImpl.updateUserLoginState(generalUser);
        return generalUserResponse;
    }




}
