package com.paul.logisticsmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.mapper.AdminMapper;
import com.paul.logisticsmanagementsystem.mapper.GeneralUserMapper;
import com.paul.logisticsmanagementsystem.service.UserService;
import com.paul.logisticsmanagementsystem.util.MD5Util;
import com.paul.logisticsmanagementsystem.util.Request.AdminRequest;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import  java.util.*;



/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/7/2018
 * Time: 3:03 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GeneralUserMapper generalUserMapper;

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public GeneralUserResponse getAllGeneralUsers(GeneralUserRequest generalUserRequest,GeneralUser generalUser) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<GeneralUser> allGenaralUsers=generalUserMapper.getAllGeneralUsers(generalUser.getUsername(),generalUser.getPhone(),generalUser.getSex(), generalUser.getIdnumber(),generalUser.getLogintype());
        if(allGenaralUsers==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无数据！！");
        }else {
            Page<GeneralUser> page = (Page<GeneralUser>) allGenaralUsers;
            PageInfo<GeneralUser> pageInfo = new PageInfo<GeneralUser>(allGenaralUsers, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPage(pageInfo);
            generalUserResponse.setCode("0000");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse selectByPrimaryKey(GeneralUser generalUser, HttpServletRequest httpServletRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        GeneralUser generalUser1=generalUserMapper.selectByPrimaryKey(generalUser.getUserid());
        if(generalUser1!=null){
            generalUserResponse.setGeneralUser(generalUser1);
            httpServletRequest.getSession().setAttribute("generaluser",generalUser1);
            generalUserResponse.setMsg("查询成功！！");
            generalUserResponse.setCode("0000");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteByPrimaryKey(GeneralUser generalUser) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=generalUserMapper.deleteByPrimaryKey(generalUser.getUserid());
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("删除成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("删除失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse insert(GeneralUser generalUser,HttpServletRequest httpServletRequest)  throws Exception{
        GeneralUserResponse generalUserResponse=new  GeneralUserResponse();
        String username=generalUser.getUsername();
        String idnumber=generalUser.getIdnumber();
        String phone=generalUser.getPhone();
        String email=generalUser.getEmail();
        generalUser.setPassword(MD5Util.md5Encode(generalUser.getPassword()));
        if (generalUserMapper.verifyGeneralUserByUserName(username)!=null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("该用户名已被被注册过！！");
        }else if(generalUserMapper.verifyGeneralUserByIdNumber(idnumber)!=null){
            generalUserResponse.setCode("0002");
            generalUserResponse.setMsg("该身份证信息已被注册过！！");
        }else if(generalUserMapper.verifyGeneralUserByEmail(email)!=null){
            generalUserResponse.setCode("0003");
            generalUserResponse.setMsg("该电子邮箱已被注册过！！");
        } else if(generalUserMapper.verifyGeneralUserByPhone(phone)!=null){
            generalUserResponse.setCode("0004");
            generalUserResponse.setMsg("该手机号码已被注册过！！");
        }else{
            int result = generalUserMapper.insertSelective(generalUser);
            if (result > 0){
                generalUserResponse.setCode("0000");
                generalUserResponse.setMsg("注册成功！！");
            } else {
                generalUserResponse.setCode("0001");
                generalUserResponse.setMsg("注册失败！！");
            }
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updateByPrimaryKey(GeneralUser generalUser, HttpServletRequest httpServletRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int  result=generalUserMapper.updateByPrimaryKeySelective(generalUser);
        if(result>0){
            GeneralUser generalUsers=generalUserMapper.selectByPrimaryKey(generalUser.getUserid());
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改个人用户信息成功！！");
        }else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改个人用户信息失败！！");
        }

        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updateUserLoginState(GeneralUser generalUser) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=generalUserMapper.updateByPrimaryKeySelective(generalUser);
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getSelectiveGeneralUser(GeneralUser generalUser,GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
       /* Integer userid=generalUser.getUserid();*/
        String username=generalUser.getUsername();
       /* String phone=generalUser.getPhone();*/
        PageHelper.startPage(pageNum,pageSize,true);
        List<GeneralUser> allGenaralUsers=generalUserMapper.getSelectiveGeneralUser(username);
        if(allGenaralUsers==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无数据！！");
        }else {
            Page<GeneralUser> page = (Page<GeneralUser>) allGenaralUsers;
            PageInfo<GeneralUser> pageInfo = new PageInfo<GeneralUser>(allGenaralUsers, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPage(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }

    @Override
    public AdminResponse getAllAdmins(AdminRequest adminRequest,Admin admin) {
        AdminResponse adminResponse=new AdminResponse();
        int pageSize=adminRequest.getPageSize();
        int pageNum=adminRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<Admin> allAdmins=adminMapper.getAllAdmin(admin.getUsername(),admin.getPhone(),admin.getSex(),admin.getIdnumber());
        if(allAdmins==null){
            adminResponse.setCode("0001");
            adminResponse.setMsg("无数据！！");
        }else {
            Page<Admin> page = (Page<Admin>) allAdmins;
            PageInfo<Admin> pageInfo = new PageInfo<Admin>(allAdmins, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            adminResponse.setPage(pageInfo);
            adminResponse.setCode("0000");
            adminResponse.setMsg("查询成功！！");
        }
        return adminResponse;
    }

    @Override
    public AdminResponse selectByPrimaryKeyAdmin(Admin admin, HttpServletRequest httpServletRequest) {
        AdminResponse adminResponse=new AdminResponse();
        Admin admins=adminMapper.selectByPrimaryKey(admin.getAdminid());
        if(admins!=null){
            adminResponse.setAdmin(admins);
            adminResponse.setCode("0000");
        }else{
            adminResponse.setCode("0001");
            adminResponse.setMsg("查询失败！！");
        }
        return adminResponse;
    }

    @Override
    public AdminResponse deleteByPrimaryKeyAdmin(Admin admin) {
        AdminResponse adminResponse=new AdminResponse();
        int result=adminMapper.deleteByPrimaryKey(admin.getAdminid());
        if(result>0){
            adminResponse.setCode("0000");
            adminResponse.setMsg("删除成功！！");
        }else{
            adminResponse.setCode("0001");
            adminResponse.setMsg("删除失败！！");
        }
        return adminResponse;
    }

    @Override
    public AdminResponse insert(Admin admin) {
        AdminResponse adminResponse=new AdminResponse();
        int result=adminMapper.insert(admin);
        if(result>0){
            adminResponse.setCode("0000");
            adminResponse.setMsg("增加成功！！");
        }else{
            adminResponse.setCode("0001");
            adminResponse.setMsg("增加失败！！");
        }
        return adminResponse;
    }

    @Override
    public AdminResponse updateByPrimaryKey(Admin admin, HttpServletRequest httpServletRequest) {
        AdminResponse adminResponse=new AdminResponse();
        int result=adminMapper.updateByPrimaryKeySelective(admin);
        if(result>0){
            adminResponse.setCode("0000");
            adminResponse.setMsg("修改成功！！");
        }else{
            adminResponse.setCode("0001");
            adminResponse.setMsg("修改失败！！");
        }
        return adminResponse;
    }

}
