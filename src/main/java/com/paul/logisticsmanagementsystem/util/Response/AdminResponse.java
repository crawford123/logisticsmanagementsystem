package com.paul.logisticsmanagementsystem.util.Response;

import com.github.pagehelper.PageInfo;
import com.paul.logisticsmanagementsystem.entity.Admin;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/7/2018
 * Time: 5:07 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class AdminResponse extends  Response{

    private Admin admin;

    private PageInfo<Admin> page;


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public PageInfo<Admin> getPage() {
        return page;
    }

    public void setPage(PageInfo<Admin> page) {
        this.page = page;
    }
}
