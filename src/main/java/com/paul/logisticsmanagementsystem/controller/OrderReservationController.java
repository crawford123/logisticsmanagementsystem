package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.OrderReservation;
import com.paul.logisticsmanagementsystem.entity.Orders;
import com.paul.logisticsmanagementsystem.entity.TracesReservation;
import com.paul.logisticsmanagementsystem.service.impl.OrderReservationServiceImpl;
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
 * Date: 4/29/2018
 * Time: 5:28 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/orderReservation")
public class OrderReservationController {

    @Autowired
    private OrderReservationServiceImpl orderReservationServiceImpl;


    @RequestMapping(value = "/toOrderReservation")
    public String toOrderReservation() {
        return "/generaluser/order/orderReservation";
    }


    @RequestMapping(value = "/toOrderReservationRecord")
    public String toOrderReservationRecord() {
        return "/generaluser/order/orderReservationRecord";
    }

    //开始寄件
    @RequestMapping(value = "/reserveOrder",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse reserveOrder(HttpServletRequest request, MultipartFile file, OrderReservation orderReservation) throws  Exception {
        String allfilename= FileManager.uploadFile(request,file);
        orderReservation.setGoodsphoto(allfilename);
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.insert(orderReservation);
        return generalUserResponse;

    }


    @RequestMapping(value = "/insertTraceReservation",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse insertTraceReservation(TracesReservation tracesReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.insertTraceReservation(tracesReservation);
        return generalUserResponse;

    }
    //开始寄件
    @RequestMapping(value = "/getSelectiveOrderReservations",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getSelectiveOrderReservations(GeneralUserRequest generalUserRequest, OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.getSelectiveOrderReservations(generalUserRequest,orderReservation);
        return generalUserResponse;
    }


    //开始寄件
    @RequestMapping(value = "/getOrderReservationbyId",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getOrderReservationbyId(HttpServletRequest httpServletRequest, OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.getOrderReservationbyId(orderReservation,httpServletRequest);
        return generalUserResponse;
    }


    //开始寄件
    @RequestMapping(value = "/toOrderReservationbyDetail")
    public String toOrderReservationbyDetail() {
        return "/generaluser/order/orderReservationDetail";
    }
    // 进入订单结果界面
    @RequestMapping(value = "/toSuccess")
    public String toSuccess() {
        return "/generaluser/order/reserveResult";
    }

    @RequestMapping(value = "/getTracesByOrderId",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getTracesByOrderId(GeneralUserRequest generalUserRequest, OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.getTracesByOrderId(generalUserRequest,orderReservation);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getTracesByOrderIds",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getTracesByOrderIds( OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.getTracesByOrderId(orderReservation);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getSelectiveManageOrderReservations",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getSelectiveManageOrderReservations(GeneralUserRequest generalUserRequest, OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.getSelectiveManageOrderReservations(generalUserRequest,orderReservation);
        return generalUserResponse;
    }


    @RequestMapping(value = "/updateOrderReservationById",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateOrderReservationById(GeneralUserRequest generalUserRequest, OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.updateOrderReservationById(orderReservation);
        return generalUserResponse;
    }
    @RequestMapping(value = "/deleteOrderReservationById",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteOrderReservationById(OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.deleteOrderReservationById(orderReservation);
        return generalUserResponse;
    }
    @RequestMapping(value = "/deleteTraceReservationById",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteTraceReservationById(TracesReservation tracesReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.deleteTraceReservationById(tracesReservation);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getTraceReservationbyId",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getTraceReservationbyId(TracesReservation tracesReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.getTraceReservationbyId(tracesReservation);
        return generalUserResponse;
    }

    @RequestMapping(value = "/updateTraceReservationById",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateTraceReservationById(TracesReservation tracesReservation) throws  Exception {
        GeneralUserResponse generalUserResponse=orderReservationServiceImpl.updateTraceReservationById(tracesReservation);
        return generalUserResponse;
    }

    @RequestMapping(value = "/updateOrderReservation",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateOrderReservation(OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse = orderReservationServiceImpl.updateOrderReservation(orderReservation);
        return generalUserResponse;
    }


    @RequestMapping(value = "/deleteOrderReservation",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteOrderReservation(OrderReservation orderReservation) throws  Exception {
        GeneralUserResponse generalUserResponse = orderReservationServiceImpl.deleteOrderReservation(orderReservation);
        return generalUserResponse;
    }
    /*管理员*/

    @RequestMapping(value = "/toManageOrderReservation")
    public String toManageOrderReservation() {
        return "/admin/manageOrderReservation/manageOrderReservation";
    }
    @RequestMapping(value = "/toSingleOrderReservation")
    public String toSingleOrderReservation() {
        return "/admin/manageOrderReservation/singleOrderReservation";
    }
    @RequestMapping(value = "/toUpdateOrderReservation")
    public String toUpdateOrderReservation() {
        return "/admin/manageOrderReservation/updateOrderReservation";
    }
    @RequestMapping(value = "/toManageTraceReservation")
    public String toManageTraceReservation() {
        return "/admin/manageOrderReservation/manageTraceReservation";
    }
    @RequestMapping(value = "/toSingleTraceReservation")
    public String toSingleTraceReservation() {
        return "/admin/manageOrderReservation/singleTraceReservation";
    }
    @RequestMapping(value = "/toSingleReservation")
    public String toSingleReservation() {
        return "/admin/manageOrderReservation/singleReservation";
    }



}
