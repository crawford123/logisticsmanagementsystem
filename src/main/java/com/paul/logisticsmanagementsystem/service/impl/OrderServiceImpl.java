package com.paul.logisticsmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.*;
import com.paul.logisticsmanagementsystem.mapper.*;
import com.paul.logisticsmanagementsystem.service.OrderService;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/16/2018
 * Time: 10:57 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class OrderServiceImpl  implements OrderService{
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private SenderMapper senderMapper;
    @Autowired
    private ReceiverMapper receiverMapper;
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private TracesMapper tracesMapper;


    @Override
    public GeneralUserResponse deleteOrderByState(Orders orders) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        HashMap<String,String>  hashMap=ordersMapper.selectStateById(orders.getOrderid());
        String state=hashMap.get("state");
        String orderState=hashMap.get("orderState");
        if(state.equals("3")||orderState.equals("1")||state.equals("4")||orderState.equals("3")){
            int result = ordersMapper.deleteByPrimaryKey(orders.getOrderid());
            if (result > 0){
                generalUserResponse.setCode("0000");
                generalUserResponse.setMsg("删除订单成功！！");
            } else {
                generalUserResponse.setCode("0001");
                generalUserResponse.setMsg("删除订单失败！！");
            }
        }else if(state.equals("0")||state.equals("2")||orderState.equals("0")||orderState.equals("2")){
            generalUserResponse.setCode("0002");
            generalUserResponse.setMsg("您的订单处于正常状态，不能删除订单！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updataOrderState(Orders orders) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        HashMap<String,String>  hashMap=ordersMapper.selectStateById(orders.getOrderid());
        String state=hashMap.get("state");
        String orderState=hashMap.get("orderState");
        if(state.equals("0")||orderState.equals("0")){
            orders.setOrderstate("1");
            int result = ordersMapper.updateByPrimaryKeySelective(orders);
            if (result > 0){
                generalUserResponse.setCode("0000");
                generalUserResponse.setMsg("取消订单成功！！");
            } else {
                generalUserResponse.setCode("0001");
                generalUserResponse.setMsg("取消订单失败！！");
            }
        }else if(orderState.equals("1")){
            generalUserResponse.setCode("0002");
            generalUserResponse.setMsg("您已取消订单，不能重复取消！！");
        }else if(state.equals("2")||orderState.equals("2")){
                    generalUserResponse.setCode("0003");
                    generalUserResponse.setMsg("您的订单正在进行中，不能取消订单，如果您想要取消订单，请联系客服人员！");
                }else if(state.equals("3")||orderState.equals("3")){
            generalUserResponse.setCode("0004");
            generalUserResponse.setMsg("订单已完成，不能再取消订单！");

        }else if(state.equals("4")){
            generalUserResponse.setCode("0005");
            generalUserResponse.setMsg("您的订单已出现问题，系统已帮您自动取消订单！");
        }

        return  generalUserResponse;
    }

    @Override
    public GeneralUserResponse getSelectiveTraces(CompleteOrder completeOrder) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        List<CompleteOrder> allCompleteOrders=ordersMapper.getSelectiveTraces(completeOrder.getLogisticcode(),completeOrder.getOrdercode(),completeOrder.getSenderphone(),completeOrder.getReceiverphone());
        if(allCompleteOrders!=null){
            generalUserResponse.setAllCompleteOrders(allCompleteOrders);
            generalUserResponse.setCode("0000");
            //generalUserResponse.setMsg("查询成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }

        return generalUserResponse;
    }


    @Override
    public GeneralUserResponse deleteTracesByOrderId(Orders orders) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        /*int result=tracesMapper.deleteTracesByOrderId(orders.getOrderid());
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("删除成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("删除失败！！");
        }*/
        return  generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteTraces(Traces traces) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=tracesMapper.deleteByPrimaryKey(traces.getTracesid());
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("删除成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("删除失败！！");
        }
        return  generalUserResponse;
    }

    @Override
    public GeneralUserResponse insertTraces(Traces traces) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int  result=tracesMapper.insert(traces);
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("增加成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("增加失败！！");
        }

        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updateByPrimaryKeySelective(Orders record) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=ordersMapper.updateByPrimaryKeySelective(record);
        if(result>0){
            String state=record.getState();
            if(state.equals("2")||state.equals("1")){
                record.setOrderstate("2");
                record.setLogisticcode(Uuid.getOrderIdByUUId());
                ordersMapper.updateOrderStateByState(record);
            }else if(state.equals("3")){
                record.setOrderstate("3");
                ordersMapper.updateOrderStateByState(record);
            }else if(state.equals("4"))
            {
                record.setOrderstate("1");
                ordersMapper.updateOrderStateByState(record);
            }else if(state.equals("0"))
            {
                record.setOrderstate("0");
                ordersMapper.updateOrderStateByState(record);
            }
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改失败！！");
        }
        return generalUserResponse;
}


    @Override
    public GeneralUserResponse deleteByPrimaryKey(Orders orders) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=ordersMapper.deleteByPrimaryKey(orders.getOrderid());
        tracesMapper.deleteTracesByOrderId(orders.getOrderid());
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
    public GeneralUserResponse getAllCompleteOrders(GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<CompleteOrder> allOrders=ordersMapper.getAllCompleteOrders();
        if(allOrders==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单信息！！");
        }else {
            Page<CompleteOrder> page = (Page<CompleteOrder>) allOrders;
            PageInfo<CompleteOrder> pageInfo = new PageInfo<CompleteOrder>(allOrders, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageCompleteOrders(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getAllCompleteOrdersByOrderid(Orders order) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        CompleteOrder completeOrder=ordersMapper.getAllCompleteOrdersByOrderid(order.getOrderid());
        if(completeOrder!=null){
            generalUserResponse.setCompleteOrder(completeOrder);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
}

    @Override
    public GeneralUserResponse getSelectiveOrders(GeneralUserRequest generalUserRequest, Orders orders) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<Orders> allOrders=ordersMapper.getSelectiveOrders(orders.getOrdercode(),orders.getLogisticcode(),orders.getState(),orders.getOrderstate(),orders.getGoodsname(),orders.getUserid(),generalUserRequest.getStartDate(),generalUserRequest.getEndDate());
            if(allOrders==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单信息！！");
        }else {
            Page<Orders> page = (Page<Orders>) allOrders;
            PageInfo<Orders> pageInfo = new PageInfo<Orders>(allOrders, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageOrders(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
}

    @Override
    public GeneralUserResponse insert(Orders record) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        Commodity commodity=new Commodity();
        record.setOrdercode(Uuid.getOrderNo());
                int  result=ordersMapper.insert(record);
                commodity.setGoodsphoto(record.getGoodsphoto());
                commodity.setGoodsdesc(record.getGoodsdesc());
                commodity.setGoodsname(record.getGoodsname());
                commodity.setGoodsquantity(record.getGoodsquantity());
                commodity.setGoodsweight(record.getGoodsweight());
                commodity.setOrdercode(record.getOrdercode());
                commodity.setLogisticcode(record.getLogisticcode());
                commodity.setUserid(record.getUserid());
                commodity.setCost(record.getCost());
                commodityMapper.insert(commodity);
                if(result>0){
                    generalUserResponse.setCode("0000");
                    generalUserResponse.setMsg("下单成功！！");
                }else{
                    generalUserResponse.setCode("0001");
                    generalUserResponse.setMsg("下单失败！！");
                }

        return generalUserResponse;
    }


    @Override
    public GeneralUserResponse selectByPrimaryKey(HttpServletRequest httpServletRequest, Orders order) {
         GeneralUserResponse generalUserResponse=new GeneralUserResponse();
            Orders orders = ordersMapper.selectByPrimaryKey(order.getOrderid());
        if(orders!=null){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
            generalUserResponse.setOrders(orders);
            httpServletRequest.getSession().setAttribute("orders",orders);
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;

    }


    @Override
    public GeneralUserResponse getTracesByOrderId(GeneralUserRequest generalUserRequest,Orders order) {
        GeneralUserResponse generalUserResponse = new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<Traces> allTraces = tracesMapper.selectByOrderId(order.getOrderid());
        if (allTraces != null){
            generalUserResponse.setAllTraces(allTraces);
            Page<Traces> page = (Page<Traces>) allTraces;
            PageInfo<Traces> pageInfo = new PageInfo<Traces>(allTraces, page.getPages());


            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageTraces(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        } else {
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getAllOrders(GeneralUserRequest generalUserRequest,Orders orders) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<Orders> allOrders=ordersMapper.getAllOrders(orders.getOrdercode(),orders.getLogisticcode(),orders.getState(),orders.getOrderstate(),orders.getGoodsname(),generalUserRequest.getStartDate(),generalUserRequest.getEndDate());
        if(allOrders==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无任何订单信息！！");
        }else {
            Page<Orders> page = (Page<Orders>) allOrders;
            PageInfo<Orders> pageInfo = new PageInfo<Orders>(allOrders, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageOrders(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询订单成功！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getTrace(Traces trace) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        Traces traces = tracesMapper.selectByPrimaryKey(trace.getTracesid());
        if(traces!=null){
            generalUserResponse.setCode("0000");
            //generalUserResponse.setMsg("查询成功！！");
            generalUserResponse.setTraces(traces);
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse updateTrace(Traces traces) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=tracesMapper.updateByPrimaryKeySelective(traces);
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改失败！！");
        }
        return generalUserResponse;
    }


}
