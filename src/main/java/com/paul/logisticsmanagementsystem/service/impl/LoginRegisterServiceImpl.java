package com.paul.logisticsmanagementsystem.service.impl;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.mapper.AdminMapper;
import com.paul.logisticsmanagementsystem.mapper.GeneralUserMapper;
import com.paul.logisticsmanagementsystem.service.UserLoginRegisterService;
import com.paul.logisticsmanagementsystem.util.MD5Util;
import com.paul.logisticsmanagementsystem.util.Request.AdminRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/12/2018
 * Time: 5:14 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class LoginRegisterServiceImpl implements UserLoginRegisterService {

        @Autowired
        GeneralUserMapper generalUserMapper;


       @Autowired
       AdminMapper  adminMapper;

       //用户登陆
        @Override
        public GeneralUserResponse doLogin(GeneralUser generalUser,HttpServletRequest httpServletRequest) throws  Exception {
            GeneralUserResponse generalUserResponse = new GeneralUserResponse();

            String username = generalUser.getUsername();
            String password = generalUser.getPassword();
            HashMap<String, String> hashMap = generalUserMapper.getLoginTypeByUserName(username);
            if (hashMap != null){
            String logintype = hashMap.get("logintype");
            if (logintype.equals("0")){
                GeneralUser generalUsers = generalUserMapper.verifyGeneralUser(username, MD5Util.md5Encode(password));
                if (generalUsers != null){
                    generalUserResponse.setCode("0000");
                    generalUserResponse.setMsg("登录成功！");
                    httpServletRequest.getSession().setAttribute("generaluser", generalUsers);
                } else {
                    generalUserResponse.setCode("0001");
                    generalUserResponse.setMsg("用户名或密码错误!");
                }
            } else if (logintype.equals("1")){
                generalUserResponse.setCode("0002");
                generalUserResponse.setMsg("该账户已经被暂停使用!");
            } else if (logintype.equals("2")){
                generalUserResponse.setCode("0003");
                generalUserResponse.setMsg("该账户已经被销户!");
            }
        }else{
                    generalUserResponse.setCode("0001");
                    generalUserResponse.setMsg("用户名或密码错误!");
                }
                return generalUserResponse;

        }

        //普通用户注册
        @Override
        public GeneralUserResponse doRegister(GeneralUser generalUser,HttpServletRequest httpServletRequest)  throws Exception{
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
                    httpServletRequest.getSession().setAttribute("generaluser", generalUser);
                } else {
                    generalUserResponse.setCode("0001");
                    generalUserResponse.setMsg("注册失败！！");
                }
            }
                return generalUserResponse;

        }


    @Override
    public AdminResponse resetPassword(Admin admin) throws Exception{
        AdminResponse adminResponse=new  AdminResponse();
        admin.setPassword(MD5Util.md5Encode("888888"));
         int result=adminMapper.updateByPrimaryKeySelective(admin);
         if(result>0){
             adminResponse.setCode("0000");
             adminResponse.setMsg("密码已重置为888888！！");
         }else{
             adminResponse.setCode("0001");
             adminResponse.setMsg("重置密码失败！！");
         }
        return adminResponse;
    }

    @Override
    public AdminResponse doAdminRegister(Admin admin) throws  Exception{
        AdminResponse adminResponse=new  AdminResponse();
        String username=admin.getUsername();
        String idnumber=admin.getIdnumber();
        String phone=admin.getPhone();
        String email=admin.getEmail();
        admin.setPassword(MD5Util.md5Encode(admin.getPassword()));
        if (adminMapper.verifyAdminByUserName(username)!=null){
            adminResponse.setCode("0001");
            adminResponse.setMsg("该用户名已被被注册过！！");
        }else if(adminMapper.verifyAdminByIdNumber(idnumber)!=null){
            adminResponse.setCode("0002");
            adminResponse.setMsg("该身份证信息已被注册过！！");
        }else if(adminMapper.verifyAdminByEmail(email)!=null){
            adminResponse.setCode("0003");
            adminResponse.setMsg("该电子邮箱已被注册过！！");
        } else if(adminMapper.verifyAdminByPhone(phone)!=null){
            adminResponse.setCode("0004");
            adminResponse.setMsg("该手机号码已被注册过！！");
        }else{
            int result = adminMapper.insertSelective(admin);
            if (result > 0){
                adminResponse.setCode("0000");
                adminResponse.setMsg("注册成功！！");
               // httpServletRequest.getSession().setAttribute("generaluser", generalUser);
            } else {
                adminResponse.setCode("0001");
                adminResponse.setMsg("注册失败！！");
            }
        }
        return adminResponse;
    }

        //普通用户用户登出
        @Override
        public void  doLogout(HttpServletRequest request, GeneralUser generalUser) {

                request.getSession().removeAttribute("generaluser");

        }

    @Override
    public void doLogout(HttpServletRequest request, Admin admin) {
        request.getSession().removeAttribute("admin");

    }

    @Override
    public AdminResponse doLogin(HttpServletRequest httpServletRequest,Admin admin) throws  Exception{
        AdminResponse adminResponse=new AdminResponse();
        String username =admin.getUsername();
        String password = admin.getPassword();
        HashMap<String, String> hashMap = adminMapper.getLoginTypeByUserName(username);
        if (hashMap != null){
            String logintype = hashMap.get("logintype");
            if (logintype.equals("0")){
                Admin admins = adminMapper.getAdmin(username, MD5Util.md5Encode(password));
                if (admins != null){
                    adminResponse.setCode("0000");
                    adminResponse.setMsg("登录成功！！");
                    httpServletRequest.getSession().setAttribute("admin", admins);
                } else {
                    adminResponse.setCode("0001");
                    adminResponse.setMsg("用户名或密码错误!!");
                }
            }else if (logintype.equals("1")){
                adminResponse.setCode("0002");
                adminResponse.setMsg("该账户已经被暂停使用!");
            } else if (logintype.equals("2")){
                adminResponse.setCode("0003");
                adminResponse.setMsg("该账户已经被销户!");
            }
        }else{
            adminResponse.setCode("0001");
            adminResponse.setMsg("用户名或密码错误!");
        }
        return adminResponse;
    }




}
