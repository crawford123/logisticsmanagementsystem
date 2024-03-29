package com.paul.logisticsmanagementsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class SenderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public SenderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSenderidIsNull() {
            addCriterion("senderid is null");
            return (Criteria) this;
        }

        public Criteria andSenderidIsNotNull() {
            addCriterion("senderid is not null");
            return (Criteria) this;
        }

        public Criteria andSenderidEqualTo(Integer value) {
            addCriterion("senderid =", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotEqualTo(Integer value) {
            addCriterion("senderid <>", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThan(Integer value) {
            addCriterion("senderid >", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("senderid >=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThan(Integer value) {
            addCriterion("senderid <", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidLessThanOrEqualTo(Integer value) {
            addCriterion("senderid <=", value, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidIn(List<Integer> values) {
            addCriterion("senderid in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotIn(List<Integer> values) {
            addCriterion("senderid not in", values, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidBetween(Integer value1, Integer value2) {
            addCriterion("senderid between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andSenderidNotBetween(Integer value1, Integer value2) {
            addCriterion("senderid not between", value1, value2, "senderid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNull() {
            addCriterion("senderName is null");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNotNull() {
            addCriterion("senderName is not null");
            return (Criteria) this;
        }

        public Criteria andSendernameEqualTo(String value) {
            addCriterion("senderName =", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotEqualTo(String value) {
            addCriterion("senderName <>", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThan(String value) {
            addCriterion("senderName >", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThanOrEqualTo(String value) {
            addCriterion("senderName >=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThan(String value) {
            addCriterion("senderName <", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThanOrEqualTo(String value) {
            addCriterion("senderName <=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLike(String value) {
            addCriterion("senderName like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotLike(String value) {
            addCriterion("senderName not like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameIn(List<String> values) {
            addCriterion("senderName in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotIn(List<String> values) {
            addCriterion("senderName not in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameBetween(String value1, String value2) {
            addCriterion("senderName between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotBetween(String value1, String value2) {
            addCriterion("senderName not between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIsNull() {
            addCriterion("senderPhone is null");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIsNotNull() {
            addCriterion("senderPhone is not null");
            return (Criteria) this;
        }

        public Criteria andSenderphoneEqualTo(String value) {
            addCriterion("senderPhone =", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotEqualTo(String value) {
            addCriterion("senderPhone <>", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneGreaterThan(String value) {
            addCriterion("senderPhone >", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneGreaterThanOrEqualTo(String value) {
            addCriterion("senderPhone >=", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLessThan(String value) {
            addCriterion("senderPhone <", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLessThanOrEqualTo(String value) {
            addCriterion("senderPhone <=", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLike(String value) {
            addCriterion("senderPhone like", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotLike(String value) {
            addCriterion("senderPhone not like", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIn(List<String> values) {
            addCriterion("senderPhone in", values, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotIn(List<String> values) {
            addCriterion("senderPhone not in", values, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneBetween(String value1, String value2) {
            addCriterion("senderPhone between", value1, value2, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotBetween(String value1, String value2) {
            addCriterion("senderPhone not between", value1, value2, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderlocationIsNull() {
            addCriterion("senderLocation is null");
            return (Criteria) this;
        }

        public Criteria andSenderlocationIsNotNull() {
            addCriterion("senderLocation is not null");
            return (Criteria) this;
        }

        public Criteria andSenderlocationEqualTo(String value) {
            addCriterion("senderLocation =", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationNotEqualTo(String value) {
            addCriterion("senderLocation <>", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationGreaterThan(String value) {
            addCriterion("senderLocation >", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationGreaterThanOrEqualTo(String value) {
            addCriterion("senderLocation >=", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationLessThan(String value) {
            addCriterion("senderLocation <", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationLessThanOrEqualTo(String value) {
            addCriterion("senderLocation <=", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationLike(String value) {
            addCriterion("senderLocation like", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationNotLike(String value) {
            addCriterion("senderLocation not like", value, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationIn(List<String> values) {
            addCriterion("senderLocation in", values, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationNotIn(List<String> values) {
            addCriterion("senderLocation not in", values, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationBetween(String value1, String value2) {
            addCriterion("senderLocation between", value1, value2, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderlocationNotBetween(String value1, String value2) {
            addCriterion("senderLocation not between", value1, value2, "senderlocation");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIsNull() {
            addCriterion("senderAddress is null");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIsNotNull() {
            addCriterion("senderAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSenderaddressEqualTo(String value) {
            addCriterion("senderAddress =", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotEqualTo(String value) {
            addCriterion("senderAddress <>", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressGreaterThan(String value) {
            addCriterion("senderAddress >", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressGreaterThanOrEqualTo(String value) {
            addCriterion("senderAddress >=", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLessThan(String value) {
            addCriterion("senderAddress <", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLessThanOrEqualTo(String value) {
            addCriterion("senderAddress <=", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLike(String value) {
            addCriterion("senderAddress like", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotLike(String value) {
            addCriterion("senderAddress not like", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIn(List<String> values) {
            addCriterion("senderAddress in", values, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotIn(List<String> values) {
            addCriterion("senderAddress not in", values, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressBetween(String value1, String value2) {
            addCriterion("senderAddress between", value1, value2, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotBetween(String value1, String value2) {
            addCriterion("senderAddress not between", value1, value2, "senderaddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sender
     *
     * @mbg.generated do_not_delete_during_merge Thu Apr 19 20:22:55 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sender
     *
     * @mbg.generated Thu Apr 19 20:22:55 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}