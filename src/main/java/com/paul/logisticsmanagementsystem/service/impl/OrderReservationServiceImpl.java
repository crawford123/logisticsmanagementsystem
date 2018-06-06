package com.paul.logisticsmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.*;
import com.paul.logisticsmanagementsystem.mapper.CommodityMapper;
import com.paul.logisticsmanagementsystem.mapper.OrderReservationMapper;
import com.paul.logisticsmanagementsystem.mapper.TracesReservationMapper;
import com.paul.logisticsmanagementsystem.service.OrderReservationService;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/30/2018
 * Time: 1:22 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class OrderReservationServiceImpl implements OrderReservationService {
    @Autowired
    private OrderReservationMapper orderReservationMapper;

    @Autowired
    private TracesReservationMapper tracesReservationMapper;

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public GeneralUserResponse insert(OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        Commodity commodity=new Commodity();
        orderReservation.setOrdercode(Uuid.getOrderNo());
        int result = orderReservationMapper.insert(orderReservation);
        commodity.setGoodsphoto(orderReservation.getGoodsphoto());
        commodity.setGoodsdesc(orderReservation.getGoodsdesc());
        commodity.setGoodsname(orderReservation.getGoodsname());
        commodity.setGoodsquantity(orderReservation.getGoodsquantity());
        commodity.setGoodsweight(orderReservation.getGoodsweight());
        commodity.setOrdercode(orderReservation.getOrdercode());
        commodity.setLogisticcode(orderReservation.getLogisticcode());
        commodity.setUserid(orderReservation.getUserid());
        commodity.setCost(orderReservation.getCost());
        commodityMapper.insert(commodity);
        if (result > 0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("下订单成功！！");
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("下订单失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getOrderReservationbyId(OrderReservation orderReservation, HttpServletRequest httpServletRequest) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        OrderReservation orderReservations = orderReservationMapper.selectByPrimaryKey(orderReservation.getId());
        if (orderReservations != null){
            generalUserResponse.setOrderReservation(orderReservations);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
            httpServletRequest.getSession().setAttribute("orderreservations", orderReservations);
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单轨迹信息！！");

        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getSelectiveOrderReservations(GeneralUserRequest generalUserRequest, OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int pageSize = generalUserRequest.getPageSize();
        int pageNum = generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum, pageSize, true);
        List<OrderReservation> allOrderReservations = orderReservationMapper.getSelectiveOrderReservations(orderReservation.getOrdercode(),orderReservation.getLogisticcode(), orderReservation.getState(), orderReservation.getReservestate(),orderReservation.getGoodsname(),orderReservation.getUserid(), generalUserRequest.getStartDate(), generalUserRequest.getEndDate(),generalUserRequest.getStartFetchDate(),generalUserRequest.getEndFetchDate());
        if (allOrderReservations == null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单信息！！");
        } else {
            Page<OrderReservation> page = (Page<OrderReservation>) allOrderReservations;
            PageInfo<OrderReservation> pageInfo = new PageInfo<OrderReservation>(allOrderReservations, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageReservations(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getSelectiveManageOrderReservations(GeneralUserRequest generalUserRequest, OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int pageSize = generalUserRequest.getPageSize();
        int pageNum = generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum, pageSize, true);
        List<OrderReservation> allOrderReservations = orderReservationMapper.getSelectiveManageOrderReservations(orderReservation.getOrdercode(),orderReservation.getLogisticcode(), orderReservation.getState(), orderReservation.getReservestate(),orderReservation.getGoodsname(), generalUserRequest.getStartDate(), generalUserRequest.getEndDate(),generalUserRequest.getStartFetchDate(),generalUserRequest.getEndFetchDate());
        if (allOrderReservations == null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单信息！！");
        } else {
            Page<OrderReservation> page = (Page<OrderReservation>) allOrderReservations;
            PageInfo<OrderReservation> pageInfo = new PageInfo<OrderReservation>(allOrderReservations, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageReservations(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }


    @Override
    public GeneralUserResponse updateOrderReservationById(OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
            orderReservation.setLogisticcode(Uuid.getOrderIdByUUId());
            int result = orderReservationMapper.updateByPrimaryKeySelective(orderReservation);
            if (result > 0){
                generalUserResponse.setCode("0000");
                generalUserResponse.setMsg("修改成功！！");
            } else {
                generalUserResponse.setCode("0001");
                generalUserResponse.setMsg("修改失败！！");
            }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updateOrderReservation(OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        HashMap<String,String> hashMap=orderReservationMapper.selectStateById(orderReservation.getId());
        String state=hashMap.get("state");
        String reserveState=hashMap.get("reserveState");
        if(!state.equals("0")){
                generalUserResponse.setCode("0003");
                generalUserResponse.setMsg("您的货物已经处于正常物流状态，不能取消预约哦~");
        } else if(state.equals("0")){
            if(reserveState.equals("3")){
                generalUserResponse.setCode("0002");
                generalUserResponse.setMsg("您已取消预约，不能重复取消预约哦~");
            }else {
                orderReservation.setReservestate("3");
                int result = orderReservationMapper.updateByPrimaryKeySelective(orderReservation);
                if (result > 0){
                    generalUserResponse.setCode("0000");
                    generalUserResponse.setMsg("取消预约成功！！");
                } else {

                    generalUserResponse.setCode("0001");
                    generalUserResponse.setMsg("取消预约失败！！");
                }
            }
        }

        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updateTraceReservationById(TracesReservation tracesReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int result = tracesReservationMapper.updateByPrimaryKeySelective(tracesReservation);
        if (result > 0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("更新成功！！");
        } else {

            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("更新失败！！]");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteOrderReservationById(OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int result = orderReservationMapper.deleteByPrimaryKey(orderReservation.getId());
        if (result > 0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("删除成功！！");
        }else {
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("删除失败！！");
        }
       return generalUserResponse;

}

    @Override
    public GeneralUserResponse insertTraceReservation(TracesReservation tracesReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int result = tracesReservationMapper.insertSelective(tracesReservation);
        if (result > 0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("新增成功！！");
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("新增失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteTraceReservationById(TracesReservation tracesReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int result = tracesReservationMapper.deleteByPrimaryKey(tracesReservation.getTracesid());
        if (result > 0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("删除成功！！");
        }else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("删除失败！！");
        }
        return generalUserResponse;

    }

    @Override
    public GeneralUserResponse deleteOrderReservation(OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        HashMap<String,String> hashMap=orderReservationMapper.selectStateById(orderReservation.getId());
        String state=hashMap.get("state");
        String reserveState=hashMap.get("reserveState");
        if(reserveState.equals("3")||state.equals("3")||reserveState.equals("1")||state.equals("4")){
            int result = orderReservationMapper.deleteByPrimaryKey(orderReservation.getId());
            if (result > 0){
                generalUserResponse.setCode("0000");
                generalUserResponse.setMsg("删除成功！！");
            } else {
                generalUserResponse.setCode("0001");
                generalUserResponse.setMsg("删除失败！！");
            }
        }else{
           if((reserveState.equals("0")||reserveState.equals("2"))&&(state.equals("0"))){
               generalUserResponse.setCode("0002");
               generalUserResponse.setMsg("您当前订单已处于正常预约状态，请先取消预约后再删除订单哦~~");
           }else{
               generalUserResponse.setCode("0003");
               generalUserResponse.setMsg("您当前货物已处于正常物流状态，不能删除订单哦~~");
           }
        }
        return generalUserResponse;
    }


    @Override
    public GeneralUserResponse getTracesByOrderId(GeneralUserRequest generalUserRequest,OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<TracesReservation> allTracesReservation = tracesReservationMapper.selectByOrderId(orderReservation.getId());
        if (allTracesReservation != null){
            generalUserResponse.setAllTracesReservation(allTracesReservation);
            Page<TracesReservation> page = (Page<TracesReservation>) allTracesReservation;
            PageInfo<TracesReservation> pageInfo = new PageInfo<TracesReservation>(allTracesReservation, page.getPages());


            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageTraceReservations(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getTracesByOrderId(OrderReservation orderReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        List<TracesReservation> allTracesReservation  = tracesReservationMapper.selectByOrderId(orderReservation.getId());
        if (allTracesReservation != null){
            generalUserResponse.setAllTracesReservation(allTracesReservation);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单轨迹信息！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getTraceReservationbyId(TracesReservation tracesReservation) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        TracesReservation tracesReservations = tracesReservationMapper.selectByPrimaryKey(tracesReservation.getTracesid());
        if (tracesReservations != null){
            generalUserResponse.setTracesReservation(tracesReservations);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单轨迹信息！！");

        }
        return generalUserResponse;
    }


}
