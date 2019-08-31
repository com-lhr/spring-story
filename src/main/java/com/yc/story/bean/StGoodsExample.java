package com.yc.story.bean;

import java.util.ArrayList;
import java.util.List;

public class StGoodsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public StGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
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
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGNameIsNull() {
            addCriterion("g_name is null");
            return (Criteria) this;
        }

        public Criteria andGNameIsNotNull() {
            addCriterion("g_name is not null");
            return (Criteria) this;
        }

        public Criteria andGNameEqualTo(String value) {
            addCriterion("g_name =", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotEqualTo(String value) {
            addCriterion("g_name <>", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThan(String value) {
            addCriterion("g_name >", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameGreaterThanOrEqualTo(String value) {
            addCriterion("g_name >=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThan(String value) {
            addCriterion("g_name <", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLessThanOrEqualTo(String value) {
            addCriterion("g_name <=", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameLike(String value) {
            addCriterion("g_name like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotLike(String value) {
            addCriterion("g_name not like", value, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameIn(List<String> values) {
            addCriterion("g_name in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotIn(List<String> values) {
            addCriterion("g_name not in", values, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameBetween(String value1, String value2) {
            addCriterion("g_name between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGNameNotBetween(String value1, String value2) {
            addCriterion("g_name not between", value1, value2, "gName");
            return (Criteria) this;
        }

        public Criteria andGPriceIsNull() {
            addCriterion("g_price is null");
            return (Criteria) this;
        }

        public Criteria andGPriceIsNotNull() {
            addCriterion("g_price is not null");
            return (Criteria) this;
        }

        public Criteria andGPriceEqualTo(Float value) {
            addCriterion("g_price =", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotEqualTo(Float value) {
            addCriterion("g_price <>", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceGreaterThan(Float value) {
            addCriterion("g_price >", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("g_price >=", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceLessThan(Float value) {
            addCriterion("g_price <", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceLessThanOrEqualTo(Float value) {
            addCriterion("g_price <=", value, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceIn(List<Float> values) {
            addCriterion("g_price in", values, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotIn(List<Float> values) {
            addCriterion("g_price not in", values, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceBetween(Float value1, Float value2) {
            addCriterion("g_price between", value1, value2, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGPriceNotBetween(Float value1, Float value2) {
            addCriterion("g_price not between", value1, value2, "gPrice");
            return (Criteria) this;
        }

        public Criteria andGDescIsNull() {
            addCriterion("g_desc is null");
            return (Criteria) this;
        }

        public Criteria andGDescIsNotNull() {
            addCriterion("g_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGDescEqualTo(String value) {
            addCriterion("g_desc =", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescNotEqualTo(String value) {
            addCriterion("g_desc <>", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescGreaterThan(String value) {
            addCriterion("g_desc >", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescGreaterThanOrEqualTo(String value) {
            addCriterion("g_desc >=", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescLessThan(String value) {
            addCriterion("g_desc <", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescLessThanOrEqualTo(String value) {
            addCriterion("g_desc <=", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescLike(String value) {
            addCriterion("g_desc like", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescNotLike(String value) {
            addCriterion("g_desc not like", value, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescIn(List<String> values) {
            addCriterion("g_desc in", values, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescNotIn(List<String> values) {
            addCriterion("g_desc not in", values, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescBetween(String value1, String value2) {
            addCriterion("g_desc between", value1, value2, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGDescNotBetween(String value1, String value2) {
            addCriterion("g_desc not between", value1, value2, "gDesc");
            return (Criteria) this;
        }

        public Criteria andGCostIsNull() {
            addCriterion("g_cost is null");
            return (Criteria) this;
        }

        public Criteria andGCostIsNotNull() {
            addCriterion("g_cost is not null");
            return (Criteria) this;
        }

        public Criteria andGCostEqualTo(Double value) {
            addCriterion("g_cost =", value, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostNotEqualTo(Double value) {
            addCriterion("g_cost <>", value, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostGreaterThan(Double value) {
            addCriterion("g_cost >", value, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostGreaterThanOrEqualTo(Double value) {
            addCriterion("g_cost >=", value, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostLessThan(Double value) {
            addCriterion("g_cost <", value, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostLessThanOrEqualTo(Double value) {
            addCriterion("g_cost <=", value, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostIn(List<Double> values) {
            addCriterion("g_cost in", values, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostNotIn(List<Double> values) {
            addCriterion("g_cost not in", values, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostBetween(Double value1, Double value2) {
            addCriterion("g_cost between", value1, value2, "gCost");
            return (Criteria) this;
        }

        public Criteria andGCostNotBetween(Double value1, Double value2) {
            addCriterion("g_cost not between", value1, value2, "gCost");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table st_goods
     *
     * @mbg.generated do_not_delete_during_merge Thu Aug 29 11:23:15 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table st_goods
     *
     * @mbg.generated Thu Aug 29 11:23:15 CST 2019
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