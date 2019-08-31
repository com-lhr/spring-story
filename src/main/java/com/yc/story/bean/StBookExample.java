package com.yc.story.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StBookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StBookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andBFaceIsNull() {
            addCriterion("b_face is null");
            return (Criteria) this;
        }

        public Criteria andBFaceIsNotNull() {
            addCriterion("b_face is not null");
            return (Criteria) this;
        }

        public Criteria andBFaceEqualTo(String value) {
            addCriterion("b_face =", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceNotEqualTo(String value) {
            addCriterion("b_face <>", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceGreaterThan(String value) {
            addCriterion("b_face >", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceGreaterThanOrEqualTo(String value) {
            addCriterion("b_face >=", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceLessThan(String value) {
            addCriterion("b_face <", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceLessThanOrEqualTo(String value) {
            addCriterion("b_face <=", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceLike(String value) {
            addCriterion("b_face like", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceNotLike(String value) {
            addCriterion("b_face not like", value, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceIn(List<String> values) {
            addCriterion("b_face in", values, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceNotIn(List<String> values) {
            addCriterion("b_face not in", values, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceBetween(String value1, String value2) {
            addCriterion("b_face between", value1, value2, "bFace");
            return (Criteria) this;
        }

        public Criteria andBFaceNotBetween(String value1, String value2) {
            addCriterion("b_face not between", value1, value2, "bFace");
            return (Criteria) this;
        }

        public Criteria andBTimeIsNull() {
            addCriterion("b_time is null");
            return (Criteria) this;
        }

        public Criteria andBTimeIsNotNull() {
            addCriterion("b_time is not null");
            return (Criteria) this;
        }

        public Criteria andBTimeEqualTo(Date value) {
            addCriterion("b_time =", value, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeNotEqualTo(Date value) {
            addCriterion("b_time <>", value, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeGreaterThan(Date value) {
            addCriterion("b_time >", value, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("b_time >=", value, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeLessThan(Date value) {
            addCriterion("b_time <", value, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeLessThanOrEqualTo(Date value) {
            addCriterion("b_time <=", value, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeIn(List<Date> values) {
            addCriterion("b_time in", values, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeNotIn(List<Date> values) {
            addCriterion("b_time not in", values, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeBetween(Date value1, Date value2) {
            addCriterion("b_time between", value1, value2, "bTime");
            return (Criteria) this;
        }

        public Criteria andBTimeNotBetween(Date value1, Date value2) {
            addCriterion("b_time not between", value1, value2, "bTime");
            return (Criteria) this;
        }

        public Criteria andBCategoryIsNull() {
            addCriterion("b_category is null");
            return (Criteria) this;
        }

        public Criteria andBCategoryIsNotNull() {
            addCriterion("b_category is not null");
            return (Criteria) this;
        }

        public Criteria andBCategoryEqualTo(Integer value) {
            addCriterion("b_category =", value, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryNotEqualTo(Integer value) {
            addCriterion("b_category <>", value, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryGreaterThan(Integer value) {
            addCriterion("b_category >", value, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_category >=", value, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryLessThan(Integer value) {
            addCriterion("b_category <", value, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("b_category <=", value, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryIn(List<Integer> values) {
            addCriterion("b_category in", values, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryNotIn(List<Integer> values) {
            addCriterion("b_category not in", values, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryBetween(Integer value1, Integer value2) {
            addCriterion("b_category between", value1, value2, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("b_category not between", value1, value2, "bCategory");
            return (Criteria) this;
        }

        public Criteria andBPositionIsNull() {
            addCriterion("b_position is null");
            return (Criteria) this;
        }

        public Criteria andBPositionIsNotNull() {
            addCriterion("b_position is not null");
            return (Criteria) this;
        }

        public Criteria andBPositionEqualTo(String value) {
            addCriterion("b_position =", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionNotEqualTo(String value) {
            addCriterion("b_position <>", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionGreaterThan(String value) {
            addCriterion("b_position >", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionGreaterThanOrEqualTo(String value) {
            addCriterion("b_position >=", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionLessThan(String value) {
            addCriterion("b_position <", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionLessThanOrEqualTo(String value) {
            addCriterion("b_position <=", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionLike(String value) {
            addCriterion("b_position like", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionNotLike(String value) {
            addCriterion("b_position not like", value, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionIn(List<String> values) {
            addCriterion("b_position in", values, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionNotIn(List<String> values) {
            addCriterion("b_position not in", values, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionBetween(String value1, String value2) {
            addCriterion("b_position between", value1, value2, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBPositionNotBetween(String value1, String value2) {
            addCriterion("b_position not between", value1, value2, "bPosition");
            return (Criteria) this;
        }

        public Criteria andBIntroduceIsNull() {
            addCriterion("b_introduce is null");
            return (Criteria) this;
        }

        public Criteria andBIntroduceIsNotNull() {
            addCriterion("b_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andBIntroduceEqualTo(String value) {
            addCriterion("b_introduce =", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceNotEqualTo(String value) {
            addCriterion("b_introduce <>", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceGreaterThan(String value) {
            addCriterion("b_introduce >", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("b_introduce >=", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceLessThan(String value) {
            addCriterion("b_introduce <", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceLessThanOrEqualTo(String value) {
            addCriterion("b_introduce <=", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceLike(String value) {
            addCriterion("b_introduce like", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceNotLike(String value) {
            addCriterion("b_introduce not like", value, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceIn(List<String> values) {
            addCriterion("b_introduce in", values, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceNotIn(List<String> values) {
            addCriterion("b_introduce not in", values, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceBetween(String value1, String value2) {
            addCriterion("b_introduce between", value1, value2, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBIntroduceNotBetween(String value1, String value2) {
            addCriterion("b_introduce not between", value1, value2, "bIntroduce");
            return (Criteria) this;
        }

        public Criteria andBNumIsNull() {
            addCriterion("b_num is null");
            return (Criteria) this;
        }

        public Criteria andBNumIsNotNull() {
            addCriterion("b_num is not null");
            return (Criteria) this;
        }

        public Criteria andBNumEqualTo(Integer value) {
            addCriterion("b_num =", value, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumNotEqualTo(Integer value) {
            addCriterion("b_num <>", value, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumGreaterThan(Integer value) {
            addCriterion("b_num >", value, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_num >=", value, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumLessThan(Integer value) {
            addCriterion("b_num <", value, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumLessThanOrEqualTo(Integer value) {
            addCriterion("b_num <=", value, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumIn(List<Integer> values) {
            addCriterion("b_num in", values, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumNotIn(List<Integer> values) {
            addCriterion("b_num not in", values, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumBetween(Integer value1, Integer value2) {
            addCriterion("b_num between", value1, value2, "bNum");
            return (Criteria) this;
        }

        public Criteria andBNumNotBetween(Integer value1, Integer value2) {
            addCriterion("b_num not between", value1, value2, "bNum");
            return (Criteria) this;
        }

        public Criteria andBCountIsNull() {
            addCriterion("b_count is null");
            return (Criteria) this;
        }

        public Criteria andBCountIsNotNull() {
            addCriterion("b_count is not null");
            return (Criteria) this;
        }

        public Criteria andBCountEqualTo(Integer value) {
            addCriterion("b_count =", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountNotEqualTo(Integer value) {
            addCriterion("b_count <>", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountGreaterThan(Integer value) {
            addCriterion("b_count >", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_count >=", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountLessThan(Integer value) {
            addCriterion("b_count <", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountLessThanOrEqualTo(Integer value) {
            addCriterion("b_count <=", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountIn(List<Integer> values) {
            addCriterion("b_count in", values, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountNotIn(List<Integer> values) {
            addCriterion("b_count not in", values, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountBetween(Integer value1, Integer value2) {
            addCriterion("b_count between", value1, value2, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountNotBetween(Integer value1, Integer value2) {
            addCriterion("b_count not between", value1, value2, "bCount");
            return (Criteria) this;
        }

        public Criteria andBStatusIsNull() {
            addCriterion("b_status is null");
            return (Criteria) this;
        }

        public Criteria andBStatusIsNotNull() {
            addCriterion("b_status is not null");
            return (Criteria) this;
        }

        public Criteria andBStatusEqualTo(Integer value) {
            addCriterion("b_status =", value, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusNotEqualTo(Integer value) {
            addCriterion("b_status <>", value, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusGreaterThan(Integer value) {
            addCriterion("b_status >", value, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_status >=", value, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusLessThan(Integer value) {
            addCriterion("b_status <", value, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusLessThanOrEqualTo(Integer value) {
            addCriterion("b_status <=", value, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusIn(List<Integer> values) {
            addCriterion("b_status in", values, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusNotIn(List<Integer> values) {
            addCriterion("b_status not in", values, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusBetween(Integer value1, Integer value2) {
            addCriterion("b_status between", value1, value2, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("b_status not between", value1, value2, "bStatus");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNull() {
            addCriterion("b_price is null");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNotNull() {
            addCriterion("b_price is not null");
            return (Criteria) this;
        }

        public Criteria andBPriceEqualTo(Float value) {
            addCriterion("b_price =", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotEqualTo(Float value) {
            addCriterion("b_price <>", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThan(Float value) {
            addCriterion("b_price >", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("b_price >=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThan(Float value) {
            addCriterion("b_price <", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThanOrEqualTo(Float value) {
            addCriterion("b_price <=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceIn(List<Float> values) {
            addCriterion("b_price in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotIn(List<Float> values) {
            addCriterion("b_price not in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceBetween(Float value1, Float value2) {
            addCriterion("b_price between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotBetween(Float value1, Float value2) {
            addCriterion("b_price not between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBNameIsNull() {
            addCriterion("b_name is null");
            return (Criteria) this;
        }

        public Criteria andBNameIsNotNull() {
            addCriterion("b_name is not null");
            return (Criteria) this;
        }

        public Criteria andBNameEqualTo(String value) {
            addCriterion("b_name =", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotEqualTo(String value) {
            addCriterion("b_name <>", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThan(String value) {
            addCriterion("b_name >", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_name >=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThan(String value) {
            addCriterion("b_name <", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThanOrEqualTo(String value) {
            addCriterion("b_name <=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLike(String value) {
            addCriterion("b_name like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotLike(String value) {
            addCriterion("b_name not like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameIn(List<String> values) {
            addCriterion("b_name in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotIn(List<String> values) {
            addCriterion("b_name not in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameBetween(String value1, String value2) {
            addCriterion("b_name between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotBetween(String value1, String value2) {
            addCriterion("b_name not between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNull() {
            addCriterion("b_author is null");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNotNull() {
            addCriterion("b_author is not null");
            return (Criteria) this;
        }

        public Criteria andBAuthorEqualTo(String value) {
            addCriterion("b_author =", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotEqualTo(String value) {
            addCriterion("b_author <>", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThan(String value) {
            addCriterion("b_author >", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("b_author >=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThan(String value) {
            addCriterion("b_author <", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThanOrEqualTo(String value) {
            addCriterion("b_author <=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLike(String value) {
            addCriterion("b_author like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotLike(String value) {
            addCriterion("b_author not like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorIn(List<String> values) {
            addCriterion("b_author in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotIn(List<String> values) {
            addCriterion("b_author not in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorBetween(String value1, String value2) {
            addCriterion("b_author between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotBetween(String value1, String value2) {
            addCriterion("b_author not between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBReadcntIsNull() {
            addCriterion("b_readCnt is null");
            return (Criteria) this;
        }

        public Criteria andBReadcntIsNotNull() {
            addCriterion("b_readCnt is not null");
            return (Criteria) this;
        }

        public Criteria andBReadcntEqualTo(Integer value) {
            addCriterion("b_readCnt =", value, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntNotEqualTo(Integer value) {
            addCriterion("b_readCnt <>", value, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntGreaterThan(Integer value) {
            addCriterion("b_readCnt >", value, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_readCnt >=", value, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntLessThan(Integer value) {
            addCriterion("b_readCnt <", value, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntLessThanOrEqualTo(Integer value) {
            addCriterion("b_readCnt <=", value, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntIn(List<Integer> values) {
            addCriterion("b_readCnt in", values, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntNotIn(List<Integer> values) {
            addCriterion("b_readCnt not in", values, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntBetween(Integer value1, Integer value2) {
            addCriterion("b_readCnt between", value1, value2, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBReadcntNotBetween(Integer value1, Integer value2) {
            addCriterion("b_readCnt not between", value1, value2, "bReadcnt");
            return (Criteria) this;
        }

        public Criteria andBCommcountIsNull() {
            addCriterion("b_commCount is null");
            return (Criteria) this;
        }

        public Criteria andBCommcountIsNotNull() {
            addCriterion("b_commCount is not null");
            return (Criteria) this;
        }

        public Criteria andBCommcountEqualTo(Integer value) {
            addCriterion("b_commCount =", value, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountNotEqualTo(Integer value) {
            addCriterion("b_commCount <>", value, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountGreaterThan(Integer value) {
            addCriterion("b_commCount >", value, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_commCount >=", value, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountLessThan(Integer value) {
            addCriterion("b_commCount <", value, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountLessThanOrEqualTo(Integer value) {
            addCriterion("b_commCount <=", value, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountIn(List<Integer> values) {
            addCriterion("b_commCount in", values, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountNotIn(List<Integer> values) {
            addCriterion("b_commCount not in", values, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountBetween(Integer value1, Integer value2) {
            addCriterion("b_commCount between", value1, value2, "bCommcount");
            return (Criteria) this;
        }

        public Criteria andBCommcountNotBetween(Integer value1, Integer value2) {
            addCriterion("b_commCount not between", value1, value2, "bCommcount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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