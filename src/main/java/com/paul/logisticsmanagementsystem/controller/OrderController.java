package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.*;
import com.paul.logisticsmanagementsystem.service.impl.OrderServiceImpl;
import com.paul.logisticsmanagementsystem.util.FileManager;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/15/2018
 * Time: 10:14 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;



    // 进入下订单页面
    @RequestMapping(value = "/toPlaceOrder")
    public String toPlaceOrder() {
        return "/generaluser/order/placeOrder";
    }
    // 进入下订单页面
    @RequestMapping(value = "/toSendExpress")
    public String toSendExpress() {
        return "/generaluser/order/sendExpress";
    }

    // 进入下订单页面(测试)
    @RequestMapping(value = "/test")
    public String test() {
        return "/generaluser/order/test";
    }


    // 进入查询订单页面(测试)
    @RequestMapping(value = "/toTestQueryOrder")
    public String totestQueryOrder() {
        return "/generaluser/order/testQueryOrder";
    }

    // 进入查询订单页面(正式)
    @RequestMapping(value = "/toQueryOrder")
    public String toQueryOrder() {
        return "/generaluser/order/queryOrder";
    }

    // 去订单详情页
    @RequestMapping(value = "/toOrderDetail")
    public String toOrderDetail() {
        return "/generaluser/order/orderDetail";
    }

    // 去查询订单页
    @RequestMapping(value = "/toOrderRecord")
    public String toOrderRecord() {
        return "/generaluser/order/orderRecord";
    }

    // 去查询订单页
    @RequestMapping(value = "/toManageOrder")
    public String toManageOrder() {
        return "/admin/manageOrder/manageOrder";
    }

    // 去查询订单页
    @RequestMapping(value = "/toSingleOrder")
    public String toSingleOrder() {
        return "/admin/manageOrder/singleOrder";
    }

    // 去查询订单页
    @RequestMapping(value = "/toSingleOrderTraces")
    public String toSingleOrderTraces() {
        return "/admin/manageOrder/singleOrderTraces";
    }
    // 去查询订单页
    @RequestMapping(value = "/toManageOrderTraces")
    public String toManageOrderTraces() {
        return "/admin/manageOrder/manageOrderTraces";
    }

    // 去查询订单页
    @RequestMapping(value = "/toUpdateOrder")
    public String toUpdateOrder() {
        return "/admin/manageOrder/updateOrder";
    }

    // 去查询订单页
    @RequestMapping(value = "/toSingleTrace")
    public String toSingleTrace() {
        return "/admin/manageOrder/singleTrace";
    }

    //开始寄件
    @RequestMapping(value = "/sendExpress",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse sendExpress(HttpServletRequest request, MultipartFile file,Orders orders) throws  Exception {
         String allfilename= FileManager.uploadFile(request,file);
         orders.setGoodsphoto(allfilename);
        GeneralUserResponse generalUserResponse=orderServiceImpl.insert(orders);
        return generalUserResponse;
    }

    // 进入订单结果界面
    @RequestMapping(value = "/toSuccess")
    public String toSuccess() {
        return "/generaluser/order/result";
    }

    @RequestMapping(value = "/deleteOrders",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteOrders( Orders orders) throws  Exception {
        GeneralUserResponse generalUserResponse=orderServiceImpl.deleteByPrimaryKey(orders);
        return generalUserResponse;
    }

    // 获取对应订单
    @RequestMapping(value = "/updateOrders",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateOrders(Orders orders) {
        GeneralUserResponse generalUserResponse=orderServiceImpl.updateByPrimaryKeySelective(orders);
        return generalUserResponse;
    }


    // 获取对应订单
    @RequestMapping(value = "/deleteTraces",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteTraces(Traces traces) throws  Exception {
        GeneralUserResponse generalUserResponse=orderServiceImpl.deleteTraces(traces);
        return generalUserResponse;
    }
    // 获取对应订单
    @RequestMapping(value = "/deleteTracesByOrderId",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteTracesByOrderId(Orders orders) throws  Exception {
        GeneralUserResponse generalUserResponse=orderServiceImpl.deleteTracesByOrderId(orders);
        return generalUserResponse;
    }
    // 获取对应订单
    @RequestMapping(value = "/getOrders",method = {RequestMethod.POST})
        @ResponseBody
        public GeneralUserResponse getOrders(GeneralUserRequest generalUserRequest, Orders orders) throws  Exception {
            GeneralUserResponse generalUserResponse=orderServiceImpl.getSelectiveOrders(generalUserRequest,orders);
            return generalUserResponse;
    }

    @RequestMapping(value = "/getOrdersByOrderId",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getOrdersByOrderId(HttpServletRequest generalUserRequest, Orders orders) throws  Exception {
        GeneralUserResponse generalUserResponse=orderServiceImpl.selectByPrimaryKey(generalUserRequest,orders);
        return generalUserResponse;
    }

    @RequestMapping(value = "/addTraces",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse addTraces(Traces traces){
        GeneralUserResponse generalUserResponse=orderServiceImpl.insertTraces(traces);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getTrace",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getTrace(Traces traces){
        GeneralUserResponse generalUserResponse=orderServiceImpl.getTrace(traces);
        return generalUserResponse;
    }

    @RequestMapping(value = "/updateTrace",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updateTrace(Traces traces){
        GeneralUserResponse generalUserResponse=orderServiceImpl.updateTrace(traces);
        return generalUserResponse;
    }


    @RequestMapping(value = "/getOrderTraces",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getOrderTraces(GeneralUserRequest generalUserRequest,Orders orders){
        GeneralUserResponse generalUserResponse=orderServiceImpl.getTracesByOrderId(generalUserRequest,orders);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getAllOrders",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getAllOrders(GeneralUserRequest generalUserRequest,Orders  orders){
        GeneralUserResponse generalUserResponse=orderServiceImpl.getAllOrders(generalUserRequest,orders);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getAllCompleteOrders",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getAllCompleteOrders(GeneralUserRequest generalUserRequest){
        GeneralUserResponse generalUserResponse=orderServiceImpl.getAllCompleteOrders(generalUserRequest);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getAllCompleteOrdersByOrderid",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getAllCompleteOrdersByOrderid(GeneralUserRequest generalUserRequest,Orders orders){
        GeneralUserResponse generalUserResponse=orderServiceImpl.getAllCompleteOrdersByOrderid(orders);
        return generalUserResponse;
    }

    @RequestMapping(value = "/getSelectiveTraces",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse getSelectiveTraces(CompleteOrder completeOrder){
        GeneralUserResponse generalUserResponse=orderServiceImpl.getSelectiveTraces(completeOrder);
        return generalUserResponse;
    }


    @RequestMapping(value = "/deleteOrderByState",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse deleteOrderByState(Orders orders){
        GeneralUserResponse generalUserResponse=orderServiceImpl.deleteOrderByState(orders);
        return generalUserResponse;
    }

    @RequestMapping(value = "/updataOrderState",method = {RequestMethod.POST})
    @ResponseBody
    public GeneralUserResponse updataOrderState(Orders orders){
        GeneralUserResponse generalUserResponse=orderServiceImpl.updataOrderState(orders);
        return generalUserResponse;
    }

}


