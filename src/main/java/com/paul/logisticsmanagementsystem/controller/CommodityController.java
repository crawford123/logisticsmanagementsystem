package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.Commodity;
import com.paul.logisticsmanagementsystem.entity.CompleteCommodity;
import com.paul.logisticsmanagementsystem.entity.Goods;
import com.paul.logisticsmanagementsystem.entity.VoiceMail;
import com.paul.logisticsmanagementsystem.service.impl.CommodityServiceImpl;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/16/2018
 * Time: 8:50 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityServiceImpl;

    // 进入评价页面
    @RequestMapping(value = "/toMangeCommodity")
    public  String toVoicemail(){
        return "/admin/manageCommodity/manageCommodity";
    }

    // 进入评价页面
    @RequestMapping(value = "/toSingleCommodity")
    public  String toVoicemailRecorcd(){
        return "/admin/manageCommodity/singleCommodity";
    }


    @RequestMapping(value = "/getCommodityById", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getCommodityById(Commodity commodity){
        GeneralUserResponse generalUserResponse=commodityServiceImpl.getCommodityById(commodity);
        return  generalUserResponse;

    }

    @RequestMapping(value = "/getAllCommodity", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getAllCommodity(CompleteCommodity completeCommodity, GeneralUserRequest generalUserRequest){
        GeneralUserResponse generalUserResponse=commodityServiceImpl.getAllCommodity(completeCommodity,generalUserRequest);
        return  generalUserResponse;

    }
    @RequestMapping(value = "/deleteCommodityById", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse deleteCommodityById(Commodity commodity){
        GeneralUserResponse generalUserResponse=commodityServiceImpl.deleteCommodityById(commodity);
        return  generalUserResponse;

    }

    @RequestMapping(value = "/getCompleteCommodityById", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getCompleteCommodityById(CompleteCommodity completeCommodity){
        GeneralUserResponse generalUserResponse=commodityServiceImpl.getCompleteCommodityById(completeCommodity);
        return  generalUserResponse;

    }


}
