package com.paul.logisticsmanagementsystem.util.Request;

import com.paul.logisticsmanagementsystem.entity.GeneralUser;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/7/2018
 * Time: 5:24 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class GeneralUserRequest extends  Request {

    private GeneralUser generalUser;
    private String limit;
    private String startDate;
    private String endDate;
    private String startFetchDate;
    private String endFetchDate;

    public GeneralUser getGeneralUser() {
        return generalUser;
    }

    public void setGeneralUser(GeneralUser generalUser) {
        this.generalUser = generalUser;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartFetchDate() {
        return startFetchDate;
    }

    public void setStartFetchDate(String startFetchDate) {
        this.startFetchDate = startFetchDate;
    }

    public String getEndFetchDate() {
        return endFetchDate;
    }

    public void setEndFetchDate(String endFetchDate) {
        this.endFetchDate = endFetchDate;
    }
}
