package com.paul.logisticsmanagementsystem.entity;

public class Receiver {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.receiverid
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private Integer receiverid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.userid
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.mark
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private String mark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.receiverName
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private String receivername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.receiverPhone
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private String receiverphone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.receiverLocation
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private String receiverlocation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column receiver.receiverAddress
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    private String receiveraddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public Receiver(Integer receiverid, Integer userid, String mark, String receivername, String receiverphone, String receiverlocation, String receiveraddress) {
        this.receiverid = receiverid;
        this.userid = userid;
        this.mark = mark;
        this.receivername = receivername;
        this.receiverphone = receiverphone;
        this.receiverlocation = receiverlocation;
        this.receiveraddress = receiveraddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table receiver
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public Receiver() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.receiverid
     *
     * @return the value of receiver.receiverid
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public Integer getReceiverid() {
        return receiverid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.receiverid
     *
     * @param receiverid the value for receiver.receiverid
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setReceiverid(Integer receiverid) {
        this.receiverid = receiverid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.userid
     *
     * @return the value of receiver.userid
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.userid
     *
     * @param userid the value for receiver.userid
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.mark
     *
     * @return the value of receiver.mark
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public String getMark() {
        return mark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.mark
     *
     * @param mark the value for receiver.mark
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.receiverName
     *
     * @return the value of receiver.receiverName
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public String getReceivername() {
        return receivername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.receiverName
     *
     * @param receivername the value for receiver.receiverName
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.receiverPhone
     *
     * @return the value of receiver.receiverPhone
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public String getReceiverphone() {
        return receiverphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.receiverPhone
     *
     * @param receiverphone the value for receiver.receiverPhone
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone == null ? null : receiverphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.receiverLocation
     *
     * @return the value of receiver.receiverLocation
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public String getReceiverlocation() {
        return receiverlocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.receiverLocation
     *
     * @param receiverlocation the value for receiver.receiverLocation
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setReceiverlocation(String receiverlocation) {
        this.receiverlocation = receiverlocation == null ? null : receiverlocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receiver.receiverAddress
     *
     * @return the value of receiver.receiverAddress
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public String getReceiveraddress() {
        return receiveraddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receiver.receiverAddress
     *
     * @param receiveraddress the value for receiver.receiverAddress
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress == null ? null : receiveraddress.trim();
    }
}