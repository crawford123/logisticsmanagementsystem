package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.OrderReservation;
import com.paul.logisticsmanagementsystem.entity.Orders;
import com.paul.logisticsmanagementsystem.entity.TracesReservation;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/30/2018
 * Time: 1:22 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface OrderReservationService {

    GeneralUserResponse updateOrderReservation(OrderReservation orderReservation);

    GeneralUserResponse  insertTraceReservation(TracesReservation tracesReservation);

    GeneralUserResponse deleteTraceReservationById(TracesReservation tracesReservation);

    GeneralUserResponse deleteOrderReservation(OrderReservation orderReservation);

    GeneralUserResponse getTracesByOrderId(OrderReservation orderReservation);

    GeneralUserResponse getTraceReservationbyId(TracesReservation tracesReservation);

    GeneralUserResponse updateOrderReservationById(OrderReservation orderReservation);

    GeneralUserResponse updateTraceReservationById(TracesReservation tracesReservation);
;
    GeneralUserResponse deleteOrderReservationById(OrderReservation orderReservation);

    GeneralUserResponse getTracesByOrderId(GeneralUserRequest generalUserRequest,OrderReservation orderReservation);

    GeneralUserResponse insert(OrderReservation orderReservation);

    GeneralUserResponse getOrderReservationbyId(OrderReservation orderReservation,HttpServletRequest httpServletRequest);

    GeneralUserResponse  getSelectiveOrderReservations(GeneralUserRequest generalUserRequest,OrderReservation orderReservation);

    GeneralUserResponse getSelectiveManageOrderReservations(GeneralUserRequest generalUserRequest,OrderReservation orderReservation);
}
