package com.paul.logisticsmanagementsystem.entity;

public class Menu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.menuid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    private Integer menuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.adminid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    private Integer adminid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.submenuid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    private Integer submenuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menu.menuname
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    private String menuname;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public Menu(Integer menuid, Integer adminid, Integer submenuid, String menuname) {
        this.menuid = menuid;
        this.adminid = adminid;
        this.submenuid = submenuid;
        this.menuname = menuname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public Menu() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.menuid
     *
     * @return the value of menu.menuid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public Integer getMenuid() {
        return menuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.menuid
     *
     * @param menuid the value for menu.menuid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.adminid
     *
     * @return the value of menu.adminid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.adminid
     *
     * @param adminid the value for menu.adminid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.submenuid
     *
     * @return the value of menu.submenuid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public Integer getSubmenuid() {
        return submenuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.submenuid
     *
     * @param submenuid the value for menu.submenuid
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public void setSubmenuid(Integer submenuid) {
        this.submenuid = submenuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.menuname
     *
     * @return the value of menu.menuname
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.menuname
     *
     * @param menuname the value for menu.menuname
     *
     * @mbg.generated Tue May 15 11:28:58 CST 2018
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }
}