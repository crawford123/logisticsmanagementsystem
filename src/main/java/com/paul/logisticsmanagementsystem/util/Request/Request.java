package com.paul.logisticsmanagementsystem.util.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/7/2018
 * Time: 5:20 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class Request implements Serializable {

    private int pageSize;
    private int pageNum;


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


}