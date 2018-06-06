package com.paul.logisticsmanagementsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;
import com.paul.logisticsmanagementsystem.entity.VoiceMail;
import com.paul.logisticsmanagementsystem.entity.VoiceMailDetail;
import com.paul.logisticsmanagementsystem.mapper.VoiceMailMapper;
import com.paul.logisticsmanagementsystem.service.VoicemailService;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.AdminResponse;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/16/2018
 * Time: 5:05 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Service
public class VoicemailServiceImpl implements VoicemailService {

    @Autowired
    private VoiceMailMapper voiceMailMapper;

    @Override
    public GeneralUserResponse getSelectiveVocieMails(VoiceMail voiceMail, GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<VoiceMail> allVocieMail=voiceMailMapper.getSelectiveVocieMails(voiceMail.getUserid(),voiceMail.getState(),generalUserRequest.getStartDate(),generalUserRequest.getEndDate());
        if(allVocieMail==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无数据！！");
        }else {
            Page<VoiceMail> page = (Page<VoiceMail>) allVocieMail;
            PageInfo<VoiceMail> pageInfo = new PageInfo<VoiceMail>(allVocieMail, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageVoiceMails(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse insertSelective(VoiceMail voiceMail) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int  result = voiceMailMapper.insertSelective(voiceMail);
        if (result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("留言成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("留言失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse getVoiceMailByPrimaryKey(VoiceMailDetail voiceMailDetail, GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        VoiceMailDetail voiceMailDetails=voiceMailMapper.getVoiceMailByPrimaryKey(voiceMailDetail.getVid());
        if(voiceMailDetails!=null){
            generalUserResponse.setVoiceMailDetail(voiceMailDetails);
            generalUserResponse.setCode("0000");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查询失败！！");
        }
        return generalUserResponse;
    }


    @Override
    public GeneralUserResponse getAllVocieMails(VoiceMailDetail voiceMailDetail, GeneralUserRequest generalUserRequest) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int pageSize=generalUserRequest.getPageSize();
        int pageNum=generalUserRequest.getPageNum();
        PageHelper.startPage(pageNum,pageSize,true);
        List<VoiceMailDetail> allVocieMail=voiceMailMapper.getAllVocieMails(voiceMailDetail.getUserid(),voiceMailDetail.getUsername(),voiceMailDetail.getState(),generalUserRequest.getStartDate(),generalUserRequest.getEndDate());
        if(allVocieMail==null){
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("无数据！！");
        }else {
            Page<VoiceMailDetail> page = (Page<VoiceMailDetail>) allVocieMail;
            PageInfo<VoiceMailDetail> pageInfo = new PageInfo<VoiceMailDetail>(allVocieMail, page.getPages());

            pageInfo.setPageNum(page.getPageNum());
            pageInfo.setTotal(page.getTotal());
            pageInfo.setPages(page.getPages());
            generalUserResponse.setPageVoiceMail(pageInfo);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查询成功！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse deleteByPrimaryKey(VoiceMailDetail record) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=voiceMailMapper.deleteByPrimaryKey(record.getVid());
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
    public GeneralUserResponse updateByPrimaryKeySelective(VoiceMail voiceMail) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        int result=voiceMailMapper.updateByPrimaryKeySelective(voiceMail);
        if(result>0){
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("修改成功！！");
        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("修改失败！！");
        }
        return generalUserResponse;
    }

    @Override
    public GeneralUserResponse selectByPrimaryKey(VoiceMail voiceMail) {
        GeneralUserResponse generalUserResponse=new GeneralUserResponse();
        VoiceMail voiceMails=voiceMailMapper.selectByPrimaryKey(voiceMail.getVid());
        if(voiceMails!=null){
            generalUserResponse.setVoiceMail(voiceMails);
            generalUserResponse.setCode("0000");
            generalUserResponse.setMsg("查找成功！！");

        }else{
            generalUserResponse.setCode("0001");
            generalUserResponse.setMsg("查找失败！！");
        }
        return generalUserResponse;
    }
}
