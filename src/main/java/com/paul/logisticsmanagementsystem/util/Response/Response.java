package com.paul.logisticsmanagementsystem.util.Response;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/13/2018
 * Time: 11:13 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class Response implements Serializable {

    private String code;
    private String msg;


    public Response() {
        code = "0000";
        msg = "Success!!";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}