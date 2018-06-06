package com.paul.logisticsmanagementsystem;

import com.paul.logisticsmanagementsystem.util.api.KdApiCreateOrderDemo;
import com.paul.logisticsmanagementsystem.util.api.KdniaoSubscribeAPI;
import com.paul.logisticsmanagementsystem.util.api.KdniaoTrackQueryAPI;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/13/2018
 * Time: 10:23 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class test {

    public static void  KdniaoTrackQuery() {

        /*快递鸟物流轨迹即时查询接口*/
        KdniaoTrackQueryAPI api = new KdniaoTrackQueryAPI();
        try {
            //第一个参数是快递公司简称（YD -- 韵达速递）
            //第二个参数是需要查询的快递单号
            String result = api.getOrderTracesByJson("YD", "5042260908504");
            JSONObject jsonObject = JSONObject.fromObject(result);
            String ShipperCode = jsonObject.getString("ShipperCode");
            String LogisticCode = jsonObject.getString("LogisticCode");
            JSONArray Traces = jsonObject.getJSONArray("Traces");
            System.out.print(result + "\n");
            System.out.println("快递名称" + ShipperCode);
            System.out.println("快递单号" + LogisticCode);
            System.out.println("输出结果为：" + jsonObject);
            for (int i = 0; i < Traces.size(); i++) {
                JSONObject object = (JSONObject) Traces.get(i);
                String AcceptTime = object.getString("OrderCode");
                String AcceptStation = object.getString("AcceptStation");
                System.out.println("时间：" + AcceptTime + "\t" + AcceptStation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        /*快递鸟订阅推送2.0接口*/
        public static  void KdniaoSubscribe() {
            KdniaoSubscribeAPI api = new KdniaoSubscribeAPI();
            try {
                String result = api.orderTracesSubByJson();
                JSONObject jsonObject = JSONObject.fromObject(result);
                String EBusinessID = jsonObject.getString("EBusinessID");
                String UpdateTime = jsonObject.getString("UpdateTime");
                Boolean Success = jsonObject.getBoolean("Success");
                System.out.print("用户ID:" + EBusinessID + "\n");
                System.out.print("更新时间:" + UpdateTime + "\n");
                System.out.print("请求结果:" + Success + "\n");
                System.out.println("输出结果为：" + jsonObject);
                // System.out.print("用户ID:" + Reason+"\n");
                //System.out.print("用户ID:" + EstimatedDeliveryTime+"\n");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     /*快递鸟在线下单接口*/
    public static  void KdApiCreateOrder() {
        KdApiCreateOrderDemo api=new KdApiCreateOrderDemo();
        try {
            String result = api.orderOnlineByJson();
            JSONObject jsonObject = JSONObject.fromObject(result);
            String EBusinessID = jsonObject.getString("EBusinessID");
            Boolean Success = jsonObject.getBoolean("Success");
            //String  Order = jsonObject.getString("Order");
            String ResultCode = jsonObject.getString("ResultCode");
            String Reason = jsonObject.getString("Reason");
           // String UniquerRequestNumber = jsonObject.getString("UniquerRequestNumber");
            System.out.print("用户ID:" + EBusinessID + "\n");
            System.out.print("成功与否:" + Success + "\n");
            System.out.print("结果编码:" + ResultCode + "\n");
            System.out.print("失败原因:" + Reason + "\n");
            //System.out.print("订单信息:" + Order + "\n");
            System.out.print("输出结果为:" + jsonObject + "\n");
           // System.out.print("唯一标识:" + UniquerRequestNumber + "\n");
           /* for (int i = 0; i < order.; i++) {
                JSONObject object = (JSONObject) Order.get(i);
                String OrderCode = object.getString("OrderCode");
                String ShipperCode = object.getString("ShipperCode");
                String LogisticCode = object.getString("LogisticCode");
                System.out.println("订单编号：" + OrderCode + "\t" + "快递公司编码"+ShipperCode+ "\t"+"快递单号:"+LogisticCode);
            }
*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {

        KdniaoTrackQuery();
        //KdniaoSubscribe();
       // KdApiCreateOrder();
    }

}
