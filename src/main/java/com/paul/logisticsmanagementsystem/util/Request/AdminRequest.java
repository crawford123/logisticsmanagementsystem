package com.paul.logisticsmanagementsystem.util.Request;

import com.paul.logisticsmanagementsystem.entity.Admin;
import com.paul.logisticsmanagementsystem.entity.GeneralUser;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/8/2018
 * Time: 12:06 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class AdminRequest extends  Request {

    private String limit;


    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
