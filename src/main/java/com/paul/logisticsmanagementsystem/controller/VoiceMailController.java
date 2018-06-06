package com.paul.logisticsmanagementsystem.controller;

import com.paul.logisticsmanagementsystem.entity.VoiceMail;
import com.paul.logisticsmanagementsystem.entity.VoiceMailDetail;
import com.paul.logisticsmanagementsystem.service.impl.VoicemailServiceImpl;
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

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/15/2018
 * Time: 3:08 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Controller
@RequestMapping("/voicemail")
public class
VoiceMailController {
    @Autowired
    private VoicemailServiceImpl voicemailServiceImpl;


    // 进入评价页面
    @RequestMapping(value = "/toVoicemail")
    public  String toVoicemail(){
        return "/generaluser/voicemail/voicemail";
    }

    // 进入评价页面
    @RequestMapping(value = "/toVoicemailRecord")
    public  String toVoicemailRecorcd(){
        return "/generaluser/voicemail/voicemailRecord";
    }

    // 执行评价操作
    @RequestMapping(value = "/voicemail", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse voicemail(MultipartFile file, VoiceMail voiceMail, HttpServletRequest httpServletRequest) throws Exception{
        if(file.getOriginalFilename().length()>0){
            String allfilename = FileManager.uploadFile(httpServletRequest, file);
            voiceMail.setPhoto(allfilename);
        }
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.insertSelective(voiceMail);
        return  generalUserResponse;
    }

    // 进入管理评价页面
    @RequestMapping(value = "/toManageVoicemail")
    public  String toManageVoicemail(){
        return "/admin/manageVoiceMail/manageVoiceMail";
    }

    @RequestMapping(value = "/toSingleManageVoicemail")
    public  String toSingleManageVoicemail(){
        return "/admin/manageVoiceMail/singleVoiceMail";
    }

    @RequestMapping(value = "/getSingleVoicemail", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getSingleVoicemail(VoiceMailDetail voiceMailDetail, GeneralUserRequest generalUserRequest){
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.getVoiceMailByPrimaryKey(voiceMailDetail,generalUserRequest);
        return  generalUserResponse;

    }

    @RequestMapping(value = "/getVoicemail", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getVoicemail(VoiceMail voiceMail){
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.selectByPrimaryKey(voiceMail);
        return  generalUserResponse;

    }


    @RequestMapping(value = "/updateVoicemail", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse updateVoicemail(VoiceMail voiceMail){
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.updateByPrimaryKeySelective(voiceMail);
        return  generalUserResponse;

    }

    @RequestMapping(value = "/deleteSingleVoicemail", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse deleteSingleVoicemail(VoiceMailDetail voiceMailDetail, GeneralUserRequest generalUserRequest){
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.deleteByPrimaryKey(voiceMailDetail);
        return  generalUserResponse;

    }
    @RequestMapping(value = "/getAllVocieMails", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getAllVocieMails(VoiceMailDetail voiceMailDetail, GeneralUserRequest generalUserRequest){
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.getAllVocieMails(voiceMailDetail,generalUserRequest);
        return  generalUserResponse;

    }

    @RequestMapping(value = "/getSelectiveVocieMails", method = { RequestMethod.POST })
    @ResponseBody
    public GeneralUserResponse getSelectiveVocieMails(VoiceMail voiceMail, GeneralUserRequest generalUserRequest){
        GeneralUserResponse generalUserResponse=voicemailServiceImpl.getSelectiveVocieMails(voiceMail,generalUserRequest);
        return  generalUserResponse;

    }
}
