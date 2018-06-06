package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.entity.News;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 5/13/2018
 * Time: 4:38 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface NewsService {
    GeneralUserResponse  getAllNewsByDynamic();
    GeneralUserResponse deleteNewsById(News news);

    GeneralUserResponse updateNews(News news,HttpServletRequest httpServletRequest);

    GeneralUserResponse   getAllNews(News news,GeneralUserRequest generalUserRequest);
   GeneralUserResponse getAllNewsByType(News news, GeneralUserRequest generalUserRequest);

    GeneralUserResponse getNewsByTypeAndId(News news,HttpServletRequest httpServletRequest);

    GeneralUserResponse addNews(News news);
}
