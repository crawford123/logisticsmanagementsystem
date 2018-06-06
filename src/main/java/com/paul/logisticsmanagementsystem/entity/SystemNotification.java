package com.paul.logisticsmanagementsystem.entity;

public class SystemNotification {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column systemnotification.sid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private Integer sid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column systemnotification.adminid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String adminid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column systemnotification.content
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column systemnotification.date
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    private String date;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table systemnotification
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public SystemNotification(Integer sid, String adminid, String content, String date) {
        this.sid = sid;
        this.adminid = adminid;
        this.content = content;
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table systemnotification
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public SystemNotification() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column systemnotification.sid
     *
     * @return the value of systemnotification.sid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column systemnotification.sid
     *
     * @param sid the value for systemnotification.sid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column systemnotification.adminid
     *
     * @return the value of systemnotification.adminid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getAdminid() {
        return adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column systemnotification.adminid
     *
     * @param adminid the value for systemnotification.adminid
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setAdminid(String adminid) {
        this.adminid = adminid == null ? null : adminid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column systemnotification.content
     *
     * @return the value of systemnotification.content
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column systemnotification.content
     *
     * @param content the value for systemnotification.content
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column systemnotification.date
     *
     * @return the value of systemnotification.date
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column systemnotification.date
     *
     * @param date the value for systemnotification.date
     *
     * @mbg.generated Thu Apr 19 19:44:15 CST 2018
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}