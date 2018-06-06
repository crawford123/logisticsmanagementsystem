package com.paul.logisticsmanagementsystem.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.News;
import com.paul.logisticsmanagementsystem.mapper.NewsMapper;
import com.paul.logisticsmanagementsystem.service.NewsService;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 5/13/2018
 * Time: 4:39 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class NewsServiceImpl  implements NewsService{

    @Autowired
    private NewsMapper newsMapper;


    @Override
    public GeneralUserResponse getAllNewsByDynamic() {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        List<News> allNewsByDynamic=newsMapper.getAllNewsByDynamic();
        if(allNewsByDynamic!=null){
            generalUserResponse.setNewsList(allNewsByDynamic);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteNewsById(News news) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=newsMapper.deleteByPrimaryKey(news.getNewsid());
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
    public GeneralUserResponse updateNews(News news, HttpServletRequest httpServletRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=newsMapper.updateByPrimaryKeySelective(news);
        if(result>0){
            generalUserResponse.setNews(news);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getAllNews(News news, GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<News> allNews=newsMapper.getAllNews(news.getType(),news.getTitle(),news.getContent(),generalUserRequest.getStartDate(),generalUserRequest.getEndDate());
        if(allNews==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何新闻信息！！");
        }else {
            Page<News> page = (Page<News>) allNews;
            PageInfo<News> pageInfo = new PageInfo<News>(allNews, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageNews(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;

    }

    @Override
    public GeneralUserResponse getAllNewsByType(News news, GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<News> allNews=newsMapper.getAllNewsByType(news.getType());
        if(allNews==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何新闻信息！！");
        }else {
            Page<News> page = (Page<News>) allNews;
            PageInfo<News> pageInfo = new PageInfo<News>(allNews, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageNews(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;


    }

    @Override
    public GeneralUserResponse getNewsByTypeAndId(News news, HttpServletRequest httpServletRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        News news1=newsMapper.selectByPrimaryKey(news.getNewsid());
        if(news1!=null){
            generalUserResponse.setNews(news1);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询特定新闻信息成功！！");
            httpServletRequest.getSession().setAttribute("news",news1);
        }else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无特定新闻信息！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse addNews(News news) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=newsMapper.insertSelective(news);
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("新增成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("新增失败！！");

        }
        return generalUserResponse;
    }
}
