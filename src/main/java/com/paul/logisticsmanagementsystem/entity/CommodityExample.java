package com.paul.logisticsmanagementsystem.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommodityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public CommodityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
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
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
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

        public Criteria andCommodityidIsNull() {
            addCriterion("commodityid is null");
            return (Criteria) this;
        }

        public Criteria andCommodityidIsNotNull() {
            addCriterion("commodityid is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityidEqualTo(Integer value) {
            addCriterion("commodityid =", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotEqualTo(Integer value) {
            addCriterion("commodityid <>", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidGreaterThan(Integer value) {
            addCriterion("commodityid >", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodityid >=", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLessThan(Integer value) {
            addCriterion("commodityid <", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidLessThanOrEqualTo(Integer value) {
            addCriterion("commodityid <=", value, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidIn(List<Integer> values) {
            addCriterion("commodityid in", values, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotIn(List<Integer> values) {
            addCriterion("commodityid not in", values, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidBetween(Integer value1, Integer value2) {
            addCriterion("commodityid between", value1, value2, "commodityid");
            return (Criteria) this;
        }

        public Criteria andCommodityidNotBetween(Integer value1, Integer value2) {
            addCriterion("commodityid not between", value1, value2, "commodityid");
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

        public Criteria andGoodsnameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("goodsName like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoIsNull() {
            addCriterion("goodsPhoto is null");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoIsNotNull() {
            addCriterion("goodsPhoto is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoEqualTo(String value) {
            addCriterion("goodsPhoto =", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoNotEqualTo(String value) {
            addCriterion("goodsPhoto <>", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoGreaterThan(String value) {
            addCriterion("goodsPhoto >", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoGreaterThanOrEqualTo(String value) {
            addCriterion("goodsPhoto >=", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoLessThan(String value) {
            addCriterion("goodsPhoto <", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoLessThanOrEqualTo(String value) {
            addCriterion("goodsPhoto <=", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoLike(String value) {
            addCriterion("goodsPhoto like", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoNotLike(String value) {
            addCriterion("goodsPhoto not like", value, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoIn(List<String> values) {
            addCriterion("goodsPhoto in", values, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoNotIn(List<String> values) {
            addCriterion("goodsPhoto not in", values, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoBetween(String value1, String value2) {
            addCriterion("goodsPhoto between", value1, value2, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsphotoNotBetween(String value1, String value2) {
            addCriterion("goodsPhoto not between", value1, value2, "goodsphoto");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityIsNull() {
            addCriterion("goodsQuantity is null");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityIsNotNull() {
            addCriterion("goodsQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityEqualTo(Integer value) {
            addCriterion("goodsQuantity =", value, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityNotEqualTo(Integer value) {
            addCriterion("goodsQuantity <>", value, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityGreaterThan(Integer value) {
            addCriterion("goodsQuantity >", value, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsQuantity >=", value, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityLessThan(Integer value) {
            addCriterion("goodsQuantity <", value, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityLessThanOrEqualTo(Integer value) {
            addCriterion("goodsQuantity <=", value, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityIn(List<Integer> values) {
            addCriterion("goodsQuantity in", values, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityNotIn(List<Integer> values) {
            addCriterion("goodsQuantity not in", values, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityBetween(Integer value1, Integer value2) {
            addCriterion("goodsQuantity between", value1, value2, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsquantityNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsQuantity not between", value1, value2, "goodsquantity");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIsNull() {
            addCriterion("goodsWeight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIsNotNull() {
            addCriterion("goodsWeight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsweightEqualTo(BigDecimal value) {
            addCriterion("goodsWeight =", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotEqualTo(BigDecimal value) {
            addCriterion("goodsWeight <>", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightGreaterThan(BigDecimal value) {
            addCriterion("goodsWeight >", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsWeight >=", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLessThan(BigDecimal value) {
            addCriterion("goodsWeight <", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goodsWeight <=", value, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightIn(List<BigDecimal> values) {
            addCriterion("goodsWeight in", values, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotIn(List<BigDecimal> values) {
            addCriterion("goodsWeight not in", values, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsWeight between", value1, value2, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsweightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goodsWeight not between", value1, value2, "goodsweight");
            return (Criteria) this;
        }

        public Criteria andGoodsdescIsNull() {
            addCriterion("goodsDesc is null");
            return (Criteria) this;
        }

        public Criteria andGoodsdescIsNotNull() {
            addCriterion("goodsDesc is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsdescEqualTo(String value) {
            addCriterion("goodsDesc =", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescNotEqualTo(String value) {
            addCriterion("goodsDesc <>", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescGreaterThan(String value) {
            addCriterion("goodsDesc >", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescGreaterThanOrEqualTo(String value) {
            addCriterion("goodsDesc >=", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescLessThan(String value) {
            addCriterion("goodsDesc <", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescLessThanOrEqualTo(String value) {
            addCriterion("goodsDesc <=", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescLike(String value) {
            addCriterion("goodsDesc like", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescNotLike(String value) {
            addCriterion("goodsDesc not like", value, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescIn(List<String> values) {
            addCriterion("goodsDesc in", values, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescNotIn(List<String> values) {
            addCriterion("goodsDesc not in", values, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescBetween(String value1, String value2) {
            addCriterion("goodsDesc between", value1, value2, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andGoodsdescNotBetween(String value1, String value2) {
            addCriterion("goodsDesc not between", value1, value2, "goodsdesc");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNull() {
            addCriterion("orderCode is null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIsNotNull() {
            addCriterion("orderCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercodeEqualTo(String value) {
            addCriterion("orderCode =", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotEqualTo(String value) {
            addCriterion("orderCode <>", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThan(String value) {
            addCriterion("orderCode >", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeGreaterThanOrEqualTo(String value) {
            addCriterion("orderCode >=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThan(String value) {
            addCriterion("orderCode <", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLessThanOrEqualTo(String value) {
            addCriterion("orderCode <=", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeLike(String value) {
            addCriterion("orderCode like", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotLike(String value) {
            addCriterion("orderCode not like", value, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeIn(List<String> values) {
            addCriterion("orderCode in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotIn(List<String> values) {
            addCriterion("orderCode not in", values, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeBetween(String value1, String value2) {
            addCriterion("orderCode between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andOrdercodeNotBetween(String value1, String value2) {
            addCriterion("orderCode not between", value1, value2, "ordercode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIsNull() {
            addCriterion("logisticCode is null");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIsNotNull() {
            addCriterion("logisticCode is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeEqualTo(String value) {
            addCriterion("logisticCode =", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotEqualTo(String value) {
            addCriterion("logisticCode <>", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeGreaterThan(String value) {
            addCriterion("logisticCode >", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeGreaterThanOrEqualTo(String value) {
            addCriterion("logisticCode >=", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLessThan(String value) {
            addCriterion("logisticCode <", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLessThanOrEqualTo(String value) {
            addCriterion("logisticCode <=", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeLike(String value) {
            addCriterion("logisticCode like", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotLike(String value) {
            addCriterion("logisticCode not like", value, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeIn(List<String> values) {
            addCriterion("logisticCode in", values, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotIn(List<String> values) {
            addCriterion("logisticCode not in", values, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeBetween(String value1, String value2) {
            addCriterion("logisticCode between", value1, value2, "logisticcode");
            return (Criteria) this;
        }

        public Criteria andLogisticcodeNotBetween(String value1, String value2) {
            addCriterion("logisticCode not between", value1, value2, "logisticcode");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table commodity
     *
     * @mbg.generated do_not_delete_during_merge Wed May 09 20:28:25 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table commodity
     *
     * @mbg.generated Wed May 09 20:28:25 CST 2018
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