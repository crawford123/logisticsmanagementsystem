package com.paul.logisticsmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.CompleteCommodity;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.entity.VoiceMailDetail;
import com.paul.logisticsmanagementsystem.mapper.CommodityMapper;
import com.paul.logisticsmanagementsystem.entity.Commodity;

import com.paul.logisticsmanagementsystem.service.CommodityService;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.loops.GeneralRenderer;

import java.util.List;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 8:43 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class CommodityServiceImpl implements CommodityService {


    @Autowired
    private CommodityMapper commodityMapper;


    @Override
    public GeneralUserResponse getCompleteCommodityById(CompleteCommodity completeCommodity) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        CompleteCommodity commoditys=commodityMapper.getCompleteCommodityById(completeCommodity.getCommodityid());
        if(commoditys!=null){
            generalUserResponse.setCompleteCommodity(commoditys);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse insert(Commodity commodity) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=commodityMapper.insert(commodity);
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("添加成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("添加失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteCommodityById(Commodity commodity) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=commodityMapper.deleteByPrimaryKey(commodity.getCommodityid());
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
    public GeneralUserResponse getCommodityById(Commodity commodity) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        Commodity commoditys=commodityMapper.selectByPrimaryKey(commodity.getCommodityid());
        if(commoditys!=null){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getAllCommodity(CompleteCommodity completeCommodity, GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<CompleteCommodity> allCommodity=commodityMapper.getAllCommodity(completeCommodity.getGoodsname(),completeCommodity.getOrdercode(),completeCommodity.getLogisticcode(),completeCommodity.getUsername());
        if(allCommodity==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无数据！！");
        }else {
            Page<CompleteCommodity> page = (Page<CompleteCommodity>) allCommodity;
            PageInfo<CompleteCommodity> pageInfo = new PageInfo<CompleteCommodity>(allCommodity, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageCompleteCommodity(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }


}
