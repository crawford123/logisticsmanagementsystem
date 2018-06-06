package com.paul.logisticsmanagementsystem.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/29/2018
 * Time: 12:59 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    public static  final  String DEFAULT_ERROR_VIEW = "error/error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest httpServletRequest,Exception e) throws  Exception{
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception",e.getMessage());
        modelAndView.addObject("url",httpServletRequest.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return  modelAndView;

    }

}
