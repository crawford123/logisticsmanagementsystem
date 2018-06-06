package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.util.Request.AdminRequest;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/7/2018
 * Time: 3:03 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface UserService {
    GeneralUserResponse updateUserLoginState(GeneralUser generalUser);

    /*获取所有个人用户*/
    GeneralUserResponse getAllGeneralUsers(GeneralUserRequest generalUserRequest,GeneralUser generalUser);

    /*获取一个个人用户*/
    GeneralUserResponse  selectByPrimaryKey(GeneralUser generalUser, HttpServletRequest httpServletRequest);

   /* 删除个人用户*/
     GeneralUserResponse  deleteByPrimaryKey(GeneralUser generalUser);
     /*新增个人用户*/
     GeneralUserResponse insert(GeneralUser generalUser,HttpServletRequest httpServletRequest) throws Exception;

    /*修改一个个人用户*/
    GeneralUserResponse updateByPrimaryKey(GeneralUser generalUser, HttpServletRequest httpServletRequest);

    /*获取具体的个人用户*/
    GeneralUserResponse getSelectiveGeneralUser(GeneralUser generalUser,GeneralUserRequest generalUserRequest);

    AdminResponse getAllAdmins(AdminRequest adminRequest,Admin admin);

    AdminResponse  selectByPrimaryKeyAdmin(Admin admin, HttpServletRequest httpServletRequest);

    AdminResponse  deleteByPrimaryKeyAdmin(Admin admin);

    AdminResponse insert(Admin admin);

    AdminResponse updateByPrimaryKey(Admin admin, HttpServletRequest httpServletRequest);


}
