package com.paul.logisticsmanagementsystem.entity;

import java.io.Serializable;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 4/10/2018
 * Time: 11:36 AM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
public class VoiceMailDetail implements Serializable{
    private Integer vid;

    private String photo;

    private String content;

    private String state;

    private String reply;

    private String voicemaildate;

    private String replydate;

    private Integer userid;

    private String username;

    private String password;

    private Integer age;

    private String sex;

    private String phone;

    private String email;

    private String idnumber;

    private String photos;
    private String logintype;

    public VoiceMailDetail(Integer vid, String photo, String content, String state, String reply, String voicemaildate, String replydate, Integer userid, String username, String password, Integer age, String sex, String phone, String email, String idnumber,String photos,String logintype) {
        this.vid = vid;
        this.photo = photo;
        this.content = content;
        this.state = state;
        this.reply = reply;
        this.voicemaildate = voicemaildate;
        this.replydate = replydate;
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.idnumber = idnumber;
        this.photos = photos;
        this.logintype = logintype;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getVoicemaildate() {
        return voicemaildate;
    }

    public void setVoicemaildate(String voicemaildate) {
        this.voicemaildate = voicemaildate;
    }

    public String getReplydate() {
        return replydate;
    }

    public void setReplydate(String replydate) {
        this.replydate = replydate;
    }
}



