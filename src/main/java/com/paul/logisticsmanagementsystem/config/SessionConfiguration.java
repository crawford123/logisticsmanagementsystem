package com.paul.logisticsmanagementsystem.config;

import com.paul.logisticsmanagementsystem.interceptor.AdminControllerHandlerInterceptor;
import com.paul.logisticsmanagementsystem.interceptor.GeneralUserControllerHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/static/");
        super.addResourceHandlers(registry);
    }
    public GeneralUserControllerHandlerInterceptor getGeneralUserControllerHandlerInterceptor(){

        return  new GeneralUserControllerHandlerInterceptor();


    }

    public AdminControllerHandlerInterceptor getAdminControllerHandlerInterceptor(){

        return  new AdminControllerHandlerInterceptor();


    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration generalUserInterceptorRegistration= registry.addInterceptor(getGeneralUserControllerHandlerInterceptor());
        //InterceptorRegistration adminInterceptorRegistration= registry.addInterceptor(getAdminControllerHandlerInterceptor());

      //个人用户界面要拦截的url
        String[] generalUserUrl={"/order/sendExpress","/order/toSuccess","/voicemail/voicemail","/order/toOrderRecord","/order/toOrderDetail","/orderReservation/toOrderReservationbyDetail","/orderReservation/toOrderReservationRecord","/voicemail/voicemail","/voicemail/toVoicemailRecord"};
        for(String url:generalUserUrl){
            generalUserInterceptorRegistration.addPathPatterns(url);
        }

        //管理员界面不需要拦截的url
      /*  String[] adminUrl={"/userLoginRegister/toAdminLogin","/userLoginRegister/adminLogin","/userLoginRegister/adminLogout"};
        for(String url:adminUrl){
            adminInterceptorRegistration.excludePathPatterns(url);
        }
*/


    }
}
