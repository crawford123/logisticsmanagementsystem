package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.*;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/16/2018
 * Time: 10:57 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface OrderService {

    GeneralUserResponse deleteOrderByState(Orders orders);

    GeneralUserResponse updataOrderState(Orders orders);

    GeneralUserResponse   getSelectiveTraces(CompleteOrder completeOrder);

    GeneralUserResponse deleteTracesByOrderId(Orders orders);

    GeneralUserResponse  deleteTraces(Traces traces);

    GeneralUserResponse insertTraces(Traces traces);

    GeneralUserResponse updateByPrimaryKeySelective(Orders record);

    GeneralUserResponse  deleteByPrimaryKey(Orders orders);

    GeneralUserResponse getAllCompleteOrders(GeneralUserRequest GeneralUserRequest);

    GeneralUserResponse getAllCompleteOrdersByOrderid(Orders order);

    GeneralUserResponse getSelectiveOrders(GeneralUserRequest generalUserRequest,Orders orders);

    GeneralUserResponse insert(Orders record);

    GeneralUserResponse selectByPrimaryKey(HttpServletRequest httpServletRequest,Orders order);

    GeneralUserResponse getTracesByOrderId(GeneralUserRequest generalUserRequest,Orders order);

    GeneralUserResponse getAllOrders(GeneralUserRequest GeneralUserRequest,Orders orders);

    GeneralUserResponse getTrace(Traces traces);

    GeneralUserResponse updateTrace(Traces traces);


}
