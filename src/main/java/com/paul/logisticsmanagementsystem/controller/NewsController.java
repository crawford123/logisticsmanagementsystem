package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.News;
import com.paul.logisticsmanagementsystem.entity.Orders;
import com.paul.logisticsmanagementsystem.service.impl.NewsServiceImpl;
import com.paul.logisticsmanagementsystem.service.impl.OrderServiceImpl;
import com.paul.logisticsmanagementsystem.util.FileManager;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 5/13/2018
 * Time: 11:33 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @RequestMapping(value = "/toNews")
    public  String toNews(){
        return "/generaluser/news/news";
    }
    @RequestMapping(value = "/toNewsDetail")
    public  String toNewsDetail(){
        return "/generaluser/news/newsDetail";
    }

    @RequestMapping(value = "/toManageNews")
    public  String toManageNews(){
        return "/admin/manageNews/manageNews";
    }
    @RequestMapping(value = "/toAnnouncement")
    public  String toAnnouncement(){
        return "/generaluser/news/announcement";
    }
    @RequestMapping(value = "/toDynamic")
    public  String toDynamic(){
        return "/generaluser/news/dynamic";
    }
    @RequestMapping(value = "/toSingleNews")
    public  String toSingleNews(){
        return "/admin/manageNews/singleNews";
    }

    @RequestMapping(value = "/getAllNewsByType",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getAllNewsByType(News news, GeneralUserRequest generalUserRequest) throws  Exception {
        GeneralUserResponse generalUserResponse=newsServiceImpl.getAllNewsByType(news,generalUserRequest);
        return generalUserResponse;
    }


    @RequestMapping(value = "/getNewsByTypeAndId",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getNewsByTypeAndId( News news,HttpServletRequest httpServletRequest) throws  Exception {
        GeneralUserResponse generalUserResponse=newsServiceImpl.getNewsByTypeAndId(news,httpServletRequest);
        return generalUserResponse;
    }



    @RequestMapping(value = "/deleteNewsById",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteNewsById(News news,HttpServletRequest httpServletRequest) throws  Exception {
        GeneralUserResponse generalUserResponse=newsServiceImpl.deleteNewsById(news);
        return generalUserResponse;
    }

    @RequestMapping(value = "/updateNews",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateNews(News news,HttpServletRequest request, MultipartFile file) throws  Exception {
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(request, file);
            news.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=newsServiceImpl.updateNews(news,request);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getAllNews",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getAllNews( News news,GeneralUserRequest generalUserRequest) throws  Exception {
        GeneralUserResponse generalUserResponse=newsServiceImpl.getAllNews(news,generalUserRequest);
        return generalUserResponse;
    }


    @RequestMapping(value = "/getAllNewsByDynamic",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getAllNewsByDynamic() throws  Exception {
        GeneralUserResponse generalUserResponse=newsServiceImpl.getAllNewsByDynamic();
        return generalUserResponse;
    }
    @RequestMapping(value = "/addNews",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse addNews(HttpServletRequest request,MultipartFile file, News news) throws  Exception {
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(request, file);
            news.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=newsServiceImpl.addNews(news);
        return generalUserResponse;
    }

}
