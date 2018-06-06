package com.paul.logisticsmanagementsystem.service.impl;

import com.paul.logisticsmanagementsystem.entity.Receiver;
import com.paul.logisticsmanagementsystem.mapper.ReceiverMapper;
import com.paul.logisticsmanagementsystem.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 8:34 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class ReceiverServiceImpl  implements ReceiverService {


    @Autowired
    ReceiverMapper receiverMapper;
    @Override
    public int insert(Receiver receiver) {
        int result=receiverMapper.insert(receiver);
        return  result;
    }

    @Override
    public int selectReceiveridIdByMark(String mark) {
       int receiverid=receiverMapper.selectReceiveridIdByMark(mark);
       return receiverid;
    }
}
