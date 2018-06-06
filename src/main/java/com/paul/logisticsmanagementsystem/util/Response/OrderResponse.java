package com.paul.logisticsmanagementsystem.util.Response;

import com.paul.logisticsmanagementsystem.entity.Orders;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/16/2018
 * Time: 11:14 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class OrderResponse  extends Response{

    private Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
