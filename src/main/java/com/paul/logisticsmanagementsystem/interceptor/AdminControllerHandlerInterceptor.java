package com.paul.logisticsmanagementsystem.interceptor;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.util.LogCvt;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 5/1/2018
 * Time: 12:10 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class AdminControllerHandlerInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LogCvt.info("-------------preHandle " + handler);
        Admin admin=(Admin)request.getSession().getAttribute("admin");
            if(admin==null){
            String url=request.getContextPath()+"/userLoginRegister/toAdminLogin";
            response.sendRedirect(url);
            return  false;
        }

        return true;
    }
}
