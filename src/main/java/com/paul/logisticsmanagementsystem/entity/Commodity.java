package com.paul.logisticsmanagementsystem.entity;

import java.math.BigDecimal;

public class Commodity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.commodityid
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private Integer commodityid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.userid
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.goodsName
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private String goodsname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.goodsPhoto
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private String goodsphoto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.goodsQuantity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private Integer goodsquantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.goodsWeight
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private BigDecimal goodsweight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.goodsDesc
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private String goodsdesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.cost
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private BigDecimal cost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.orderCode
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private String ordercode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column commodity.logisticCode
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    private String logisticcode;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public Commodity(Integer commodityid, Integer userid, String goodsname, String goodsphoto, Integer goodsquantity, BigDecimal goodsweight, String goodsdesc, BigDecimal cost, String ordercode, String logisticcode) {
        this.commodityid = commodityid;
        this.userid = userid;
        this.goodsname = goodsname;
        this.goodsphoto = goodsphoto;
        this.goodsquantity = goodsquantity;
        this.goodsweight = goodsweight;
        this.goodsdesc = goodsdesc;
        this.cost = cost;
        this.ordercode = ordercode;
        this.logisticcode = logisticcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public Commodity() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.commodityid
     *
     * @return the value of commodity.commodityid
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public Integer getCommodityid() {
        return commodityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.commodityid
     *
     * @param commodityid the value for commodity.commodityid
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.userid
     *
     * @return the value of commodity.userid
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.userid
     *
     * @param userid the value for commodity.userid
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.goodsName
     *
     * @return the value of commodity.goodsName
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public String getGoodsname() {
        return goodsname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.goodsName
     *
     * @param goodsname the value for commodity.goodsName
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.goodsPhoto
     *
     * @return the value of commodity.goodsPhoto
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public String getGoodsphoto() {
        return goodsphoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.goodsPhoto
     *
     * @param goodsphoto the value for commodity.goodsPhoto
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setGoodsphoto(String goodsphoto) {
        this.goodsphoto = goodsphoto == null ? null : goodsphoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.goodsQuantity
     *
     * @return the value of commodity.goodsQuantity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public Integer getGoodsquantity() {
        return goodsquantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.goodsQuantity
     *
     * @param goodsquantity the value for commodity.goodsQuantity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setGoodsquantity(Integer goodsquantity) {
        this.goodsquantity = goodsquantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.goodsWeight
     *
     * @return the value of commodity.goodsWeight
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public BigDecimal getGoodsweight() {
        return goodsweight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.goodsWeight
     *
     * @param goodsweight the value for commodity.goodsWeight
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setGoodsweight(BigDecimal goodsweight) {
        this.goodsweight = goodsweight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.goodsDesc
     *
     * @return the value of commodity.goodsDesc
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public String getGoodsdesc() {
        return goodsdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.goodsDesc
     *
     * @param goodsdesc the value for commodity.goodsDesc
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc == null ? null : goodsdesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.cost
     *
     * @return the value of commodity.cost
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.cost
     *
     * @param cost the value for commodity.cost
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.orderCode
     *
     * @return the value of commodity.orderCode
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public String getOrdercode() {
        return ordercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.orderCode
     *
     * @param ordercode the value for commodity.orderCode
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode == null ? null : ordercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column commodity.logisticCode
     *
     * @return the value of commodity.logisticCode
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public String getLogisticcode() {
        return logisticcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column commodity.logisticCode
     *
     * @param logisticcode the value for commodity.logisticCode
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode == null ? null : logisticcode.trim();
    }
}