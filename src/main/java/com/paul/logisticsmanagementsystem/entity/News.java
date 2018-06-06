package com.paul.logisticsmanagementsystem.entity;

public class News {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.newsid
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    private Integer newsid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.title
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.type
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.content
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.photo
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    private String photo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.publishtime
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    private String publishtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public News(Integer newsid, String title, String type, String content, String photo, String publishtime) {
        this.newsid = newsid;
        this.title = title;
        this.type = type;
        this.content = content;
        this.photo = photo;
        this.publishtime = publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public News() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.newsid
     *
     * @return the value of news.newsid
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.newsid
     *
     * @param newsid the value for news.newsid
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.title
     *
     * @return the value of news.title
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.title
     *
     * @param title the value for news.title
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.type
     *
     * @return the value of news.type
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.type
     *
     * @param type the value for news.type
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.content
     *
     * @return the value of news.content
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.content
     *
     * @param content the value for news.content
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.photo
     *
     * @return the value of news.photo
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.photo
     *
     * @param photo the value for news.photo
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column news.publishtime
     *
     * @return the value of news.publishtime
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public String getPublishtime() {
        return publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column news.publishtime
     *
     * @param publishtime the value for news.publishtime
     *
     * @mbg.generated Sun May 13 16:37:07 CST 2018
     */
    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime == null ? null : publishtime.trim();
    }
}