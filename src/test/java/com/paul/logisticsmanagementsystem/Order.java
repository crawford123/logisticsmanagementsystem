package com.paul.logisticsmanagementsystem;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/19/2018
 * Time: 2:19 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class Order {
    private  String OrderCode;
    private  String ShipperCode ;
    private  String LogisticCode ;

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }
}
