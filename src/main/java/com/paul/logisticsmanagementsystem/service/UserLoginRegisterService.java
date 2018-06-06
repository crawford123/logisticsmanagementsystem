package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.util.Request.AdminRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/12/2018
 * Time: 5:23 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public  interface UserLoginRegisterService {
       AdminResponse  resetPassword(Admin admin) throws Exception;

       AdminResponse doAdminRegister(Admin admin) throws  Exception;

       GeneralUserResponse doLogin(GeneralUser generalUser,HttpServletRequest httpServletRequest) throws  Exception;

       GeneralUserResponse doRegister(GeneralUser generalUser, HttpServletRequest httpServletRequest) throws Exception;

       void doLogout(HttpServletRequest request, GeneralUser generalUser) ;
       void doLogout(HttpServletRequest request, Admin admin) ;
       AdminResponse doLogin(HttpServletRequest httpServletRequest,Admin admin) throws  Exception;


}
