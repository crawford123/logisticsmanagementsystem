package com.paul.logisticsmanagementsystem.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //登录不做拦截
        if(httpServletRequest.getRequestURI().equals("/userLoginRegister/genaralUserLogin")||httpServletRequest.getRequestURI().equals("/userLoginRegister/toUserLogin")){

            return true;
        }
        //验证session是否存在
        Object obj = httpServletRequest.getSession().getAttribute("_session_user");
        if(obj==null)
        {

            httpServletResponse.sendRedirect("/userLoginRegister/toUserLogin");
            return false;
        }
         return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
