package com.paul.logisticsmanagementsystem.entity;

public class Company {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.companyId
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private Integer companyid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.companyname
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String companyname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.companytype
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String companytype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.establishtime
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String establishtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.legalrepresentative
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String legalrepresentative;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.registeredcapital
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String registeredcapital;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.introducion
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String introducion;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.companyaddress
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String companyaddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.companyemail
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    private String companyemail;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public Company(Integer companyid, String companyname, String companytype, String establishtime, String legalrepresentative, String registeredcapital, String introducion, String companyaddress, String companyemail) {
        this.companyid = companyid;
        this.companyname = companyname;
        this.companytype = companytype;
        this.establishtime = establishtime;
        this.legalrepresentative = legalrepresentative;
        this.registeredcapital = registeredcapital;
        this.introducion = introducion;
        this.companyaddress = companyaddress;
        this.companyemail = companyemail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public Company() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.companyId
     *
     * @return the value of company.companyId
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public Integer getCompanyid() {
        return companyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.companyId
     *
     * @param companyid the value for company.companyId
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.companyname
     *
     * @return the value of company.companyname
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getCompanyname() {
        return companyname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.companyname
     *
     * @param companyname the value for company.companyname
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.companytype
     *
     * @return the value of company.companytype
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getCompanytype() {
        return companytype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.companytype
     *
     * @param companytype the value for company.companytype
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setCompanytype(String companytype) {
        this.companytype = companytype == null ? null : companytype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.establishtime
     *
     * @return the value of company.establishtime
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getEstablishtime() {
        return establishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.establishtime
     *
     * @param establishtime the value for company.establishtime
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setEstablishtime(String establishtime) {
        this.establishtime = establishtime == null ? null : establishtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.legalrepresentative
     *
     * @return the value of company.legalrepresentative
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getLegalrepresentative() {
        return legalrepresentative;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.legalrepresentative
     *
     * @param legalrepresentative the value for company.legalrepresentative
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setLegalrepresentative(String legalrepresentative) {
        this.legalrepresentative = legalrepresentative == null ? null : legalrepresentative.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.registeredcapital
     *
     * @return the value of company.registeredcapital
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getRegisteredcapital() {
        return registeredcapital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.registeredcapital
     *
     * @param registeredcapital the value for company.registeredcapital
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setRegisteredcapital(String registeredcapital) {
        this.registeredcapital = registeredcapital == null ? null : registeredcapital.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.introducion
     *
     * @return the value of company.introducion
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getIntroducion() {
        return introducion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.introducion
     *
     * @param introducion the value for company.introducion
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setIntroducion(String introducion) {
        this.introducion = introducion == null ? null : introducion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.companyaddress
     *
     * @return the value of company.companyaddress
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getCompanyaddress() {
        return companyaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.companyaddress
     *
     * @param companyaddress the value for company.companyaddress
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress == null ? null : companyaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.companyemail
     *
     * @return the value of company.companyemail
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public String getCompanyemail() {
        return companyemail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column company.companyemail
     *
     * @param companyemail the value for company.companyemail
     *
     * @mbg.generated Tue Apr 03 13:54:02 CST 2018
     */
    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail == null ? null : companyemail.trim();
    }
}