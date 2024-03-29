package com.paul.logisticsmanagementsystem.entity;

public class TransactionLocation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transactionlocation.tlid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private Integer tlid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transactionlocation.eid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private Integer eid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transactionlocation.manager
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String manager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transactionlocation.phoneNumber
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String phonenumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transactionlocation.loactionName
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String loactionname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column transactionlocation.address
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String address;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactionlocation
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public TransactionLocation(Integer tlid, Integer eid, String manager, String phonenumber, String loactionname, String address) {
        this.tlid = tlid;
        this.eid = eid;
        this.manager = manager;
        this.phonenumber = phonenumber;
        this.loactionname = loactionname;
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table transactionlocation
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public TransactionLocation() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transactionlocation.tlid
     *
     * @return the value of transactionlocation.tlid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public Integer getTlid() {
        return tlid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transactionlocation.tlid
     *
     * @param tlid the value for transactionlocation.tlid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setTlid(Integer tlid) {
        this.tlid = tlid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transactionlocation.eid
     *
     * @return the value of transactionlocation.eid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transactionlocation.eid
     *
     * @param eid the value for transactionlocation.eid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transactionlocation.manager
     *
     * @return the value of transactionlocation.manager
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getManager() {
        return manager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transactionlocation.manager
     *
     * @param manager the value for transactionlocation.manager
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transactionlocation.phoneNumber
     *
     * @return the value of transactionlocation.phoneNumber
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transactionlocation.phoneNumber
     *
     * @param phonenumber the value for transactionlocation.phoneNumber
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transactionlocation.loactionName
     *
     * @return the value of transactionlocation.loactionName
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getLoactionname() {
        return loactionname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transactionlocation.loactionName
     *
     * @param loactionname the value for transactionlocation.loactionName
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setLoactionname(String loactionname) {
        this.loactionname = loactionname == null ? null : loactionname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column transactionlocation.address
     *
     * @return the value of transactionlocation.address
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column transactionlocation.address
     *
     * @param address the value for transactionlocation.address
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}