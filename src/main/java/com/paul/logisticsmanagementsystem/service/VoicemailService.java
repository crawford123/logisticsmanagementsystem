package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.VoiceMail;
import com.paul.logisticsmanagementsystem.entity.VoiceMailDetail;
import com.paul.logisticsmanagementsystem.util.Request.GeneralUserRequest;
import com.paul.logisticsmanagementsystem.util.Response.GeneralUserResponse;
import com.paul.logisticsmanagementsystem.util.Response.Response;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/16/2018
 * Time: 5:05 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */

public interface VoicemailService {

    GeneralUserResponse getSelectiveVocieMails(VoiceMail voiceMail, GeneralUserRequest generalUserRequest);

    GeneralUserResponse insertSelective(VoiceMail record);

    GeneralUserResponse  getVoiceMailByPrimaryKey(VoiceMailDetail record, GeneralUserRequest generalUserRequest);

    GeneralUserResponse  getAllVocieMails(VoiceMailDetail voiceMailDetail, GeneralUserRequest generalUserRequest);

    GeneralUserResponse deleteByPrimaryKey(VoiceMailDetail record);

    GeneralUserResponse  updateByPrimaryKeySelective(VoiceMail voiceMail);

    GeneralUserResponse  selectByPrimaryKey(VoiceMail voiceMail);

}
