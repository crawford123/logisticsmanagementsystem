package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.Commodity;
import com.paul.logisticsmanagementsystem.entity.CompleteCommodity;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 8:43 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface CommodityService {

    GeneralUserResponse  getCompleteCommodityById(CompleteCommodity completeCommodity);

    GeneralUserResponse insert(Commodity commodity);

    GeneralUserResponse deleteCommodityById(Commodity  commodity);

    GeneralUserResponse getCommodityById(Commodity commodity);

    GeneralUserResponse getAllCommodity(CompleteCommodity commodity, GeneralUserRequest generalUserRequest);

}
