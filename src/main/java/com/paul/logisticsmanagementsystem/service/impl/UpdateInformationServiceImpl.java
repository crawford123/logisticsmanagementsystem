package com.paul.logisticsmanagementsystem.service.impl;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.mapper.AdminMapper;
import com.paul.logisticsmanagementsystem.mapper.GeneralUserMapper;
import com.paul.logisticsmanagementsystem.service.UpdateInformationService;
import com.paul.logisticsmanagementsystem.util.MD5Util;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/17/2018
 * Time: 1:56 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class UpdateInformationServiceImpl implements UpdateInformationService {

    @Autowired
    private GeneralUserMapper  generalUserMapper;

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public GeneralUserResponse updatePasswordByPrimaryKeySelective(GeneralUser generalUser,String oldPassword) throws  Exception {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        GeneralUser generalUsers=generalUserMapper.verifyGeneralUser(generalUser.getUsername(),MD5Util.md5Encode(oldPassword));
        if(generalUsers!=null){
            generalUser.setPassword(MD5Util.md5Encode(generalUser.getPassword()));
            int result = generalUserMapper.updateByPrimaryKeySelective(generalUser);
            if (result > 0){
                generalUserResponse.setCode("0000");
                generalUserResponse.setMsg("修改密码成功！！");
            } else {
                generalUserResponse.setCode("0001");
                generalUserResponse.setMsg("修改密码失败！！");
            }
        }else {
            generalUserResponse.setCode("0002");
            generalUserResponse.setMsg("旧密码错误！！");
        }

        return generalUserResponse;
    }


    @Override
    public GeneralUserResponse updateAccountByPrimaryKeySelective(GeneralUser generalUser,HttpServletRequest httpServletRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int  result=generalUserMapper.updateByPrimaryKeySelective(generalUser);
        if(result>0){
            GeneralUser generalUsers=generalUserMapper.selectByPrimaryKey(generalUser.getUserid());
            httpServletRequest.getSession().setAttribute("generaluser",generalUsers);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改个人资料成功！！");
        }else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改个人资料失败！！");
        }

        return generalUserResponse;
    }

    @Override
    public AdminResponse updateAdminPassword(Admin admin, String oldPassword) throws Exception {
        AdminResponse adminResponse=new AdminResponse();
        Admin admin1=adminMapper.getAdmin(admin.getUsername(),MD5Util.md5Encode(oldPassword));
        if(admin1!=null){
            admin.setPassword(MD5Util.md5Encode(admin.getPassword()));
            int result = adminMapper.updateByPrimaryKeySelective(admin);
            if (result > 0){
                adminResponse.setCode("0000");
                adminResponse.setMsg("修改密码成功！！");
            } else {
                adminResponse.setCode("0001");
                adminResponse.setMsg("修改密码失败！！");
            }
        }else {
            adminResponse.setCode("0002");
            adminResponse.setMsg("旧密码错误！！");
        }

        return adminResponse;
    }

    @Override
    public AdminResponse updateAdminInfo(Admin admin,HttpServletRequest httpServletRequest) {
        AdminResponse adminResponse=new AdminResponse();
        int  result=adminMapper.updateByPrimaryKeySelective(admin);
        if(result>0){
            Admin admin1=adminMapper.selectByPrimaryKey(admin.getAdminid());
            httpServletRequest.getSession().setAttribute("admin",admin1);
            adminResponse.setCode("0000");
            adminResponse.setMsg("修改管理员资料成功！！");
        }else {
            adminResponse.setCode("0001");
            adminResponse.setMsg("修改管理员资料失败！！");
        }

        return adminResponse;
    }

}
