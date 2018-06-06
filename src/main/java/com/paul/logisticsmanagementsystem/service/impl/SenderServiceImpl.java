package com.paul.logisticsmanagementsystem.service.impl;

import com.paul.logisticsmanagementsystem.entity.Sender;
import com.paul.logisticsmanagementsystem.mapper.SenderMapper;
import com.paul.logisticsmanagementsystem.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 7:58 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class SenderServiceImpl implements SenderService {

    @Autowired
    SenderMapper senderMapper;
    @Override
    public int insert(Sender sender) {
        int result=senderMapper.insert(sender);
        return result;
    }

    @Override
    public int selectSenderIdByMark(String mark) {
        int senderid=senderMapper.selectSenderIdByMark(mark);
        return senderid;
    }
}
