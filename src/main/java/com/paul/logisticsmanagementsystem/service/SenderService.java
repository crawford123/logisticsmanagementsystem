package com.paul.logisticsmanagementsystem.service;

import com.paul.logisticsmanagementsystem.entity.Sender;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 7:57 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public interface SenderService {

      int insert(Sender sender);

      int selectSenderIdByMark(String mark);

}
