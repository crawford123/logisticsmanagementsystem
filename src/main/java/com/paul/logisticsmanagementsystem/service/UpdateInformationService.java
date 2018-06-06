package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/17/2018
 * Time: 1:56 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface UpdateInformationService {


    GeneralUserResponse updatePasswordByPrimaryKeySelective(GeneralUser generalUser,String oldPassword) throws  Exception ;

    GeneralUserResponse updateAccountByPrimaryKeySelective(GeneralUser generalUser,HttpServletRequest httpServletRequest);

    AdminResponse updateAdminPassword(Admin admin, String oldPassword) throws Exception ;

    AdminResponse updateAdminInfo(Admin admin,HttpServletRequest httpServletRequest);

}
