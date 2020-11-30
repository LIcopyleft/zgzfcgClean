package com.drc.zfgc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CNGovCleanDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CNGovCleanDataExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andUrlIdIsNull() {
            addCriterion("url_id is null");
            return (Criteria) this;
        }

        public Criteria andUrlIdIsNotNull() {
            addCriterion("url_id is not null");
            return (Criteria) this;
        }

        public Criteria andUrlIdEqualTo(Integer value) {
            addCriterion("url_id =", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotEqualTo(Integer value) {
            addCriterion("url_id <>", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdGreaterThan(Integer value) {
            addCriterion("url_id >", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("url_id >=", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLessThan(Integer value) {
            addCriterion("url_id <", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdLessThanOrEqualTo(Integer value) {
            addCriterion("url_id <=", value, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdIn(List<Integer> values) {
            addCriterion("url_id in", values, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotIn(List<Integer> values) {
            addCriterion("url_id not in", values, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdBetween(Integer value1, Integer value2) {
            addCriterion("url_id between", value1, value2, "urlId");
            return (Criteria) this;
        }

        public Criteria andUrlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("url_id not between", value1, value2, "urlId");
            return (Criteria) this;
        }

        public Criteria andPurchaserIsNull() {
            addCriterion("purchaser is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserIsNotNull() {
            addCriterion("purchaser is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserEqualTo(String value) {
            addCriterion("purchaser =", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotEqualTo(String value) {
            addCriterion("purchaser <>", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserGreaterThan(String value) {
            addCriterion("purchaser >", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserGreaterThanOrEqualTo(String value) {
            addCriterion("purchaser >=", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserLessThan(String value) {
            addCriterion("purchaser <", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserLessThanOrEqualTo(String value) {
            addCriterion("purchaser <=", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserLike(String value) {
            addCriterion("purchaser like", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotLike(String value) {
            addCriterion("purchaser not like", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserIn(List<String> values) {
            addCriterion("purchaser in", values, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotIn(List<String> values) {
            addCriterion("purchaser not in", values, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserBetween(String value1, String value2) {
            addCriterion("purchaser between", value1, value2, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotBetween(String value1, String value2) {
            addCriterion("purchaser not between", value1, value2, "purchaser");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodIsNull() {
            addCriterion(" purchasing_method is null");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodIsNotNull() {
            addCriterion(" purchasing_method is not null");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodEqualTo(String value) {
            addCriterion(" purchasing_method =", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodNotEqualTo(String value) {
            addCriterion(" purchasing_method <>", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodGreaterThan(String value) {
            addCriterion(" purchasing_method >", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodGreaterThanOrEqualTo(String value) {
            addCriterion(" purchasing_method >=", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodLessThan(String value) {
            addCriterion(" purchasing_method <", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodLessThanOrEqualTo(String value) {
            addCriterion(" purchasing_method <=", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodLike(String value) {
            addCriterion(" purchasing_method like", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodNotLike(String value) {
            addCriterion(" purchasing_method not like", value, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodIn(List<String> values) {
            addCriterion(" purchasing_method in", values, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodNotIn(List<String> values) {
            addCriterion(" purchasing_method not in", values, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodBetween(String value1, String value2) {
            addCriterion(" purchasing_method between", value1, value2, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andpurchasingMethodNotBetween(String value1, String value2) {
            addCriterion(" purchasing_method not between", value1, value2, " purchasingMethod");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNull() {
            addCriterion("notice is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNotNull() {
            addCriterion("notice is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEqualTo(String value) {
            addCriterion("notice =", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotEqualTo(String value) {
            addCriterion("notice <>", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThan(String value) {
            addCriterion("notice >", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("notice >=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThan(String value) {
            addCriterion("notice <", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThanOrEqualTo(String value) {
            addCriterion("notice <=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLike(String value) {
            addCriterion("notice like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotLike(String value) {
            addCriterion("notice not like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeIn(List<String> values) {
            addCriterion("notice in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotIn(List<String> values) {
            addCriterion("notice not in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeBetween(String value1, String value2) {
            addCriterion("notice between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotBetween(String value1, String value2) {
            addCriterion("notice not between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(String value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(String value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(String value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(String value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(String value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLike(String value) {
            addCriterion("pub_time like", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotLike(String value) {
            addCriterion("pub_time not like", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<String> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<String> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(String value1, String value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(String value1, String value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(String value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(String value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(String value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(String value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(String value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(String value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLike(String value) {
            addCriterion("region_id like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotLike(String value) {
            addCriterion("region_id not like", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<String> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<String> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(String value1, String value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(String value1, String value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegion1IsNull() {
            addCriterion("region_1 is null");
            return (Criteria) this;
        }

        public Criteria andRegion1IsNotNull() {
            addCriterion("region_1 is not null");
            return (Criteria) this;
        }

        public Criteria andRegion1EqualTo(String value) {
            addCriterion("region_1 =", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1NotEqualTo(String value) {
            addCriterion("region_1 <>", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1GreaterThan(String value) {
            addCriterion("region_1 >", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1GreaterThanOrEqualTo(String value) {
            addCriterion("region_1 >=", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1LessThan(String value) {
            addCriterion("region_1 <", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1LessThanOrEqualTo(String value) {
            addCriterion("region_1 <=", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1Like(String value) {
            addCriterion("region_1 like", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1NotLike(String value) {
            addCriterion("region_1 not like", value, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1In(List<String> values) {
            addCriterion("region_1 in", values, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1NotIn(List<String> values) {
            addCriterion("region_1 not in", values, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1Between(String value1, String value2) {
            addCriterion("region_1 between", value1, value2, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion1NotBetween(String value1, String value2) {
            addCriterion("region_1 not between", value1, value2, "region1");
            return (Criteria) this;
        }

        public Criteria andRegion2IsNull() {
            addCriterion("region_2 is null");
            return (Criteria) this;
        }

        public Criteria andRegion2IsNotNull() {
            addCriterion("region_2 is not null");
            return (Criteria) this;
        }

        public Criteria andRegion2EqualTo(String value) {
            addCriterion("region_2 =", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2NotEqualTo(String value) {
            addCriterion("region_2 <>", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2GreaterThan(String value) {
            addCriterion("region_2 >", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2GreaterThanOrEqualTo(String value) {
            addCriterion("region_2 >=", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2LessThan(String value) {
            addCriterion("region_2 <", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2LessThanOrEqualTo(String value) {
            addCriterion("region_2 <=", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2Like(String value) {
            addCriterion("region_2 like", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2NotLike(String value) {
            addCriterion("region_2 not like", value, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2In(List<String> values) {
            addCriterion("region_2 in", values, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2NotIn(List<String> values) {
            addCriterion("region_2 not in", values, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2Between(String value1, String value2) {
            addCriterion("region_2 between", value1, value2, "region2");
            return (Criteria) this;
        }

        public Criteria andRegion2NotBetween(String value1, String value2) {
            addCriterion("region_2 not between", value1, value2, "region2");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRegion3IsNull() {
            addCriterion("region_3 is null");
            return (Criteria) this;
        }

        public Criteria andRegion3IsNotNull() {
            addCriterion("region_3 is not null");
            return (Criteria) this;
        }

        public Criteria andRegion3EqualTo(String value) {
            addCriterion("region_3 =", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3NotEqualTo(String value) {
            addCriterion("region_3 <>", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3GreaterThan(String value) {
            addCriterion("region_3 >", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3GreaterThanOrEqualTo(String value) {
            addCriterion("region_3 >=", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3LessThan(String value) {
            addCriterion("region_3 <", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3LessThanOrEqualTo(String value) {
            addCriterion("region_3 <=", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3Like(String value) {
            addCriterion("region_3 like", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3NotLike(String value) {
            addCriterion("region_3 not like", value, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3In(List<String> values) {
            addCriterion("region_3 in", values, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3NotIn(List<String> values) {
            addCriterion("region_3 not in", values, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3Between(String value1, String value2) {
            addCriterion("region_3 between", value1, value2, "region3");
            return (Criteria) this;
        }

        public Criteria andRegion3NotBetween(String value1, String value2) {
            addCriterion("region_3 not between", value1, value2, "region3");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andProNameIsNull() {
            addCriterion("pro_name is null");
            return (Criteria) this;
        }

        public Criteria andProNameIsNotNull() {
            addCriterion("pro_name is not null");
            return (Criteria) this;
        }

        public Criteria andProNameEqualTo(String value) {
            addCriterion("pro_name =", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotEqualTo(String value) {
            addCriterion("pro_name <>", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThan(String value) {
            addCriterion("pro_name >", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameGreaterThanOrEqualTo(String value) {
            addCriterion("pro_name >=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThan(String value) {
            addCriterion("pro_name <", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLessThanOrEqualTo(String value) {
            addCriterion("pro_name <=", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameLike(String value) {
            addCriterion("pro_name like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotLike(String value) {
            addCriterion("pro_name not like", value, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameIn(List<String> values) {
            addCriterion("pro_name in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotIn(List<String> values) {
            addCriterion("pro_name not in", values, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameBetween(String value1, String value2) {
            addCriterion("pro_name between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andProNameNotBetween(String value1, String value2) {
            addCriterion("pro_name not between", value1, value2, "proName");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNull() {
            addCriterion("agency is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIsNotNull() {
            addCriterion("agency is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyEqualTo(String value) {
            addCriterion("agency =", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotEqualTo(String value) {
            addCriterion("agency <>", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThan(String value) {
            addCriterion("agency >", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyGreaterThanOrEqualTo(String value) {
            addCriterion("agency >=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThan(String value) {
            addCriterion("agency <", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLessThanOrEqualTo(String value) {
            addCriterion("agency <=", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyLike(String value) {
            addCriterion("agency like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotLike(String value) {
            addCriterion("agency not like", value, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyIn(List<String> values) {
            addCriterion("agency in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotIn(List<String> values) {
            addCriterion("agency not in", values, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyBetween(String value1, String value2) {
            addCriterion("agency between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andAgencyNotBetween(String value1, String value2) {
            addCriterion("agency not between", value1, value2, "agency");
            return (Criteria) this;
        }

        public Criteria andHashcodeIsNull() {
            addCriterion("hashcode is null");
            return (Criteria) this;
        }

        public Criteria andHashcodeIsNotNull() {
            addCriterion("hashcode is not null");
            return (Criteria) this;
        }

        public Criteria andHashcodeEqualTo(String value) {
            addCriterion("hashcode =", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotEqualTo(String value) {
            addCriterion("hashcode <>", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeGreaterThan(String value) {
            addCriterion("hashcode >", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeGreaterThanOrEqualTo(String value) {
            addCriterion("hashcode >=", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeLessThan(String value) {
            addCriterion("hashcode <", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeLessThanOrEqualTo(String value) {
            addCriterion("hashcode <=", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeLike(String value) {
            addCriterion("hashcode like", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotLike(String value) {
            addCriterion("hashcode not like", value, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeIn(List<String> values) {
            addCriterion("hashcode in", values, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotIn(List<String> values) {
            addCriterion("hashcode not in", values, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeBetween(String value1, String value2) {
            addCriterion("hashcode between", value1, value2, "hashcode");
            return (Criteria) this;
        }

        public Criteria andHashcodeNotBetween(String value1, String value2) {
            addCriterion("hashcode not between", value1, value2, "hashcode");
            return (Criteria) this;
        }

        public Criteria andItemsIsNull() {
            addCriterion("items is null");
            return (Criteria) this;
        }

        public Criteria andItemsIsNotNull() {
            addCriterion("items is not null");
            return (Criteria) this;
        }

        public Criteria andItemsEqualTo(String value) {
            addCriterion("items =", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotEqualTo(String value) {
            addCriterion("items <>", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsGreaterThan(String value) {
            addCriterion("items >", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsGreaterThanOrEqualTo(String value) {
            addCriterion("items >=", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsLessThan(String value) {
            addCriterion("items <", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsLessThanOrEqualTo(String value) {
            addCriterion("items <=", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsLike(String value) {
            addCriterion("items like", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotLike(String value) {
            addCriterion("items not like", value, "items");
            return (Criteria) this;
        }

        public Criteria andItemsIn(List<String> values) {
            addCriterion("items in", values, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotIn(List<String> values) {
            addCriterion("items not in", values, "items");
            return (Criteria) this;
        }

        public Criteria andItemsBetween(String value1, String value2) {
            addCriterion("items between", value1, value2, "items");
            return (Criteria) this;
        }

        public Criteria andItemsNotBetween(String value1, String value2) {
            addCriterion("items not between", value1, value2, "items");
            return (Criteria) this;
        }

        public Criteria andProNoIsNull() {
            addCriterion("pro_no is null");
            return (Criteria) this;
        }

        public Criteria andProNoIsNotNull() {
            addCriterion("pro_no is not null");
            return (Criteria) this;
        }

        public Criteria andProNoEqualTo(String value) {
            addCriterion("pro_no =", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotEqualTo(String value) {
            addCriterion("pro_no <>", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoGreaterThan(String value) {
            addCriterion("pro_no >", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoGreaterThanOrEqualTo(String value) {
            addCriterion("pro_no >=", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLessThan(String value) {
            addCriterion("pro_no <", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLessThanOrEqualTo(String value) {
            addCriterion("pro_no <=", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLike(String value) {
            addCriterion("pro_no like", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotLike(String value) {
            addCriterion("pro_no not like", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoIn(List<String> values) {
            addCriterion("pro_no in", values, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotIn(List<String> values) {
            addCriterion("pro_no not in", values, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoBetween(String value1, String value2) {
            addCriterion("pro_no between", value1, value2, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotBetween(String value1, String value2) {
            addCriterion("pro_no not between", value1, value2, "proNo");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeIsNull() {
            addCriterion("agency_code is null");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeIsNotNull() {
            addCriterion("agency_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeEqualTo(String value) {
            addCriterion("agency_code =", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeNotEqualTo(String value) {
            addCriterion("agency_code <>", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeGreaterThan(String value) {
            addCriterion("agency_code >", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("agency_code >=", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeLessThan(String value) {
            addCriterion("agency_code <", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeLessThanOrEqualTo(String value) {
            addCriterion("agency_code <=", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeLike(String value) {
            addCriterion("agency_code like", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeNotLike(String value) {
            addCriterion("agency_code not like", value, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeIn(List<String> values) {
            addCriterion("agency_code in", values, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeNotIn(List<String> values) {
            addCriterion("agency_code not in", values, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeBetween(String value1, String value2) {
            addCriterion("agency_code between", value1, value2, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyCodeNotBetween(String value1, String value2) {
            addCriterion("agency_code not between", value1, value2, "agencyCode");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNull() {
            addCriterion("agency_id is null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIsNotNull() {
            addCriterion("agency_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyIdEqualTo(Integer value) {
            addCriterion("agency_id =", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotEqualTo(Integer value) {
            addCriterion("agency_id <>", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThan(Integer value) {
            addCriterion("agency_id >", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agency_id >=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThan(Integer value) {
            addCriterion("agency_id <", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdLessThanOrEqualTo(Integer value) {
            addCriterion("agency_id <=", value, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdIn(List<Integer> values) {
            addCriterion("agency_id in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotIn(List<Integer> values) {
            addCriterion("agency_id not in", values, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdBetween(Integer value1, Integer value2) {
            addCriterion("agency_id between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andAgencyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agency_id not between", value1, value2, "agencyId");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIsNull() {
            addCriterion("supplier_code is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIsNotNull() {
            addCriterion("supplier_code is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeEqualTo(String value) {
            addCriterion("supplier_code =", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotEqualTo(String value) {
            addCriterion("supplier_code <>", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThan(String value) {
            addCriterion("supplier_code >", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_code >=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThan(String value) {
            addCriterion("supplier_code <", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThanOrEqualTo(String value) {
            addCriterion("supplier_code <=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLike(String value) {
            addCriterion("supplier_code like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotLike(String value) {
            addCriterion("supplier_code not like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIn(List<String> values) {
            addCriterion("supplier_code in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotIn(List<String> values) {
            addCriterion("supplier_code not in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeBetween(String value1, String value2) {
            addCriterion("supplier_code between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotBetween(String value1, String value2) {
            addCriterion("supplier_code not between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNull() {
            addCriterion("supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIsNotNull() {
            addCriterion("supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierIdEqualTo(Integer value) {
            addCriterion("supplier_id =", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotEqualTo(Integer value) {
            addCriterion("supplier_id <>", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThan(Integer value) {
            addCriterion("supplier_id >", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplier_id >=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThan(Integer value) {
            addCriterion("supplier_id <", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("supplier_id <=", value, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdIn(List<Integer> values) {
            addCriterion("supplier_id in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotIn(List<Integer> values) {
            addCriterion("supplier_id not in", values, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("supplier_id between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("supplier_id not between", value1, value2, "supplierId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andReTypeIsNull() {
            addCriterion("re_type is null");
            return (Criteria) this;
        }

        public Criteria andReTypeIsNotNull() {
            addCriterion("re_type is not null");
            return (Criteria) this;
        }

        public Criteria andReTypeEqualTo(String value) {
            addCriterion("re_type =", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeNotEqualTo(String value) {
            addCriterion("re_type <>", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeGreaterThan(String value) {
            addCriterion("re_type >", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeGreaterThanOrEqualTo(String value) {
            addCriterion("re_type >=", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeLessThan(String value) {
            addCriterion("re_type <", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeLessThanOrEqualTo(String value) {
            addCriterion("re_type <=", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeLike(String value) {
            addCriterion("re_type like", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeNotLike(String value) {
            addCriterion("re_type not like", value, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeIn(List<String> values) {
            addCriterion("re_type in", values, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeNotIn(List<String> values) {
            addCriterion("re_type not in", values, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeBetween(String value1, String value2) {
            addCriterion("re_type between", value1, value2, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeNotBetween(String value1, String value2) {
            addCriterion("re_type not between", value1, value2, "reType");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusIsNull() {
            addCriterion("re_type_status is null");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusIsNotNull() {
            addCriterion("re_type_status is not null");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusEqualTo(String value) {
            addCriterion("re_type_status =", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusNotEqualTo(String value) {
            addCriterion("re_type_status <>", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusGreaterThan(String value) {
            addCriterion("re_type_status >", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("re_type_status >=", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusLessThan(String value) {
            addCriterion("re_type_status <", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusLessThanOrEqualTo(String value) {
            addCriterion("re_type_status <=", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusLike(String value) {
            addCriterion("re_type_status like", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusNotLike(String value) {
            addCriterion("re_type_status not like", value, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusIn(List<String> values) {
            addCriterion("re_type_status in", values, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusNotIn(List<String> values) {
            addCriterion("re_type_status not in", values, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusBetween(String value1, String value2) {
            addCriterion("re_type_status between", value1, value2, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andReTypeStatusNotBetween(String value1, String value2) {
            addCriterion("re_type_status not between", value1, value2, "reTypeStatus");
            return (Criteria) this;
        }

        public Criteria andTransactionStageIsNull() {
            addCriterion("transaction_stage is null");
            return (Criteria) this;
        }

        public Criteria andTransactionStageIsNotNull() {
            addCriterion("transaction_stage is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionStageEqualTo(String value) {
            addCriterion("transaction_stage =", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageNotEqualTo(String value) {
            addCriterion("transaction_stage <>", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageGreaterThan(String value) {
            addCriterion("transaction_stage >", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_stage >=", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageLessThan(String value) {
            addCriterion("transaction_stage <", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageLessThanOrEqualTo(String value) {
            addCriterion("transaction_stage <=", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageLike(String value) {
            addCriterion("transaction_stage like", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageNotLike(String value) {
            addCriterion("transaction_stage not like", value, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageIn(List<String> values) {
            addCriterion("transaction_stage in", values, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageNotIn(List<String> values) {
            addCriterion("transaction_stage not in", values, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageBetween(String value1, String value2) {
            addCriterion("transaction_stage between", value1, value2, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andTransactionStageNotBetween(String value1, String value2) {
            addCriterion("transaction_stage not between", value1, value2, "transactionStage");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIsNull() {
            addCriterion("process_type is null");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIsNotNull() {
            addCriterion("process_type is not null");
            return (Criteria) this;
        }

        public Criteria andProcessTypeEqualTo(String value) {
            addCriterion("process_type =", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotEqualTo(String value) {
            addCriterion("process_type <>", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeGreaterThan(String value) {
            addCriterion("process_type >", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("process_type >=", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLessThan(String value) {
            addCriterion("process_type <", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLessThanOrEqualTo(String value) {
            addCriterion("process_type <=", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLike(String value) {
            addCriterion("process_type like", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotLike(String value) {
            addCriterion("process_type not like", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIn(List<String> values) {
            addCriterion("process_type in", values, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotIn(List<String> values) {
            addCriterion("process_type not in", values, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeBetween(String value1, String value2) {
            addCriterion("process_type between", value1, value2, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotBetween(String value1, String value2) {
            addCriterion("process_type not between", value1, value2, "processType");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrIsNull() {
            addCriterion("obtain_purchasing_file_addr is null");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrIsNotNull() {
            addCriterion("obtain_purchasing_file_addr is not null");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrEqualTo(String value) {
            addCriterion("obtain_purchasing_file_addr =", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrNotEqualTo(String value) {
            addCriterion("obtain_purchasing_file_addr <>", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrGreaterThan(String value) {
            addCriterion("obtain_purchasing_file_addr >", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_purchasing_file_addr >=", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrLessThan(String value) {
            addCriterion("obtain_purchasing_file_addr <", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrLessThanOrEqualTo(String value) {
            addCriterion("obtain_purchasing_file_addr <=", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrLike(String value) {
            addCriterion("obtain_purchasing_file_addr like", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrNotLike(String value) {
            addCriterion("obtain_purchasing_file_addr not like", value, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrIn(List<String> values) {
            addCriterion("obtain_purchasing_file_addr in", values, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrNotIn(List<String> values) {
            addCriterion("obtain_purchasing_file_addr not in", values, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrBetween(String value1, String value2) {
            addCriterion("obtain_purchasing_file_addr between", value1, value2, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileAddrNotBetween(String value1, String value2) {
            addCriterion("obtain_purchasing_file_addr not between", value1, value2, "obtainPurchasingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeIsNull() {
            addCriterion("obtain_purchasing_file_time is null");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeIsNotNull() {
            addCriterion("obtain_purchasing_file_time is not null");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeEqualTo(String value) {
            addCriterion("obtain_purchasing_file_time =", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeNotEqualTo(String value) {
            addCriterion("obtain_purchasing_file_time <>", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeGreaterThan(String value) {
            addCriterion("obtain_purchasing_file_time >", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_purchasing_file_time >=", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeLessThan(String value) {
            addCriterion("obtain_purchasing_file_time <", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeLessThanOrEqualTo(String value) {
            addCriterion("obtain_purchasing_file_time <=", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeLike(String value) {
            addCriterion("obtain_purchasing_file_time like", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeNotLike(String value) {
            addCriterion("obtain_purchasing_file_time not like", value, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeIn(List<String> values) {
            addCriterion("obtain_purchasing_file_time in", values, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeNotIn(List<String> values) {
            addCriterion("obtain_purchasing_file_time not in", values, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeBetween(String value1, String value2) {
            addCriterion("obtain_purchasing_file_time between", value1, value2, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainPurchasingFileTimeNotBetween(String value1, String value2) {
            addCriterion("obtain_purchasing_file_time not between", value1, value2, "obtainPurchasingFileTime");
            return (Criteria) this;
        }

        public Criteria andOther1IsNull() {
            addCriterion("other1 is null");
            return (Criteria) this;
        }

        public Criteria andOther1IsNotNull() {
            addCriterion("other1 is not null");
            return (Criteria) this;
        }

        public Criteria andOther1EqualTo(String value) {
            addCriterion("other1 =", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotEqualTo(String value) {
            addCriterion("other1 <>", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThan(String value) {
            addCriterion("other1 >", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1GreaterThanOrEqualTo(String value) {
            addCriterion("other1 >=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThan(String value) {
            addCriterion("other1 <", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1LessThanOrEqualTo(String value) {
            addCriterion("other1 <=", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Like(String value) {
            addCriterion("other1 like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotLike(String value) {
            addCriterion("other1 not like", value, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1In(List<String> values) {
            addCriterion("other1 in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotIn(List<String> values) {
            addCriterion("other1 not in", values, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1Between(String value1, String value2) {
            addCriterion("other1 between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther1NotBetween(String value1, String value2) {
            addCriterion("other1 not between", value1, value2, "other1");
            return (Criteria) this;
        }

        public Criteria andOther2IsNull() {
            addCriterion("other2 is null");
            return (Criteria) this;
        }

        public Criteria andOther2IsNotNull() {
            addCriterion("other2 is not null");
            return (Criteria) this;
        }

        public Criteria andOther2EqualTo(String value) {
            addCriterion("other2 =", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotEqualTo(String value) {
            addCriterion("other2 <>", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThan(String value) {
            addCriterion("other2 >", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2GreaterThanOrEqualTo(String value) {
            addCriterion("other2 >=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThan(String value) {
            addCriterion("other2 <", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2LessThanOrEqualTo(String value) {
            addCriterion("other2 <=", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Like(String value) {
            addCriterion("other2 like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotLike(String value) {
            addCriterion("other2 not like", value, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2In(List<String> values) {
            addCriterion("other2 in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotIn(List<String> values) {
            addCriterion("other2 not in", values, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2Between(String value1, String value2) {
            addCriterion("other2 between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther2NotBetween(String value1, String value2) {
            addCriterion("other2 not between", value1, value2, "other2");
            return (Criteria) this;
        }

        public Criteria andOther3IsNull() {
            addCriterion("other3 is null");
            return (Criteria) this;
        }

        public Criteria andOther3IsNotNull() {
            addCriterion("other3 is not null");
            return (Criteria) this;
        }

        public Criteria andOther3EqualTo(String value) {
            addCriterion("other3 =", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotEqualTo(String value) {
            addCriterion("other3 <>", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThan(String value) {
            addCriterion("other3 >", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3GreaterThanOrEqualTo(String value) {
            addCriterion("other3 >=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThan(String value) {
            addCriterion("other3 <", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3LessThanOrEqualTo(String value) {
            addCriterion("other3 <=", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Like(String value) {
            addCriterion("other3 like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotLike(String value) {
            addCriterion("other3 not like", value, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3In(List<String> values) {
            addCriterion("other3 in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotIn(List<String> values) {
            addCriterion("other3 not in", values, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3Between(String value1, String value2) {
            addCriterion("other3 between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther3NotBetween(String value1, String value2) {
            addCriterion("other3 not between", value1, value2, "other3");
            return (Criteria) this;
        }

        public Criteria andOther4IsNull() {
            addCriterion("other4 is null");
            return (Criteria) this;
        }

        public Criteria andOther4IsNotNull() {
            addCriterion("other4 is not null");
            return (Criteria) this;
        }

        public Criteria andOther4EqualTo(String value) {
            addCriterion("other4 =", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotEqualTo(String value) {
            addCriterion("other4 <>", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThan(String value) {
            addCriterion("other4 >", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4GreaterThanOrEqualTo(String value) {
            addCriterion("other4 >=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThan(String value) {
            addCriterion("other4 <", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4LessThanOrEqualTo(String value) {
            addCriterion("other4 <=", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Like(String value) {
            addCriterion("other4 like", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotLike(String value) {
            addCriterion("other4 not like", value, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4In(List<String> values) {
            addCriterion("other4 in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotIn(List<String> values) {
            addCriterion("other4 not in", values, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4Between(String value1, String value2) {
            addCriterion("other4 between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andOther4NotBetween(String value1, String value2) {
            addCriterion("other4 not between", value1, value2, "other4");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeIsNull() {
            addCriterion("res_file_open_time is null");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeIsNotNull() {
            addCriterion("res_file_open_time is not null");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeEqualTo(String value) {
            addCriterion("res_file_open_time =", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeNotEqualTo(String value) {
            addCriterion("res_file_open_time <>", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeGreaterThan(String value) {
            addCriterion("res_file_open_time >", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("res_file_open_time >=", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeLessThan(String value) {
            addCriterion("res_file_open_time <", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("res_file_open_time <=", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeLike(String value) {
            addCriterion("res_file_open_time like", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeNotLike(String value) {
            addCriterion("res_file_open_time not like", value, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeIn(List<String> values) {
            addCriterion("res_file_open_time in", values, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeNotIn(List<String> values) {
            addCriterion("res_file_open_time not in", values, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeBetween(String value1, String value2) {
            addCriterion("res_file_open_time between", value1, value2, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenTimeNotBetween(String value1, String value2) {
            addCriterion("res_file_open_time not between", value1, value2, "resFileOpenTime");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrIsNull() {
            addCriterion("res_file_open_addr is null");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrIsNotNull() {
            addCriterion("res_file_open_addr is not null");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrEqualTo(String value) {
            addCriterion("res_file_open_addr =", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrNotEqualTo(String value) {
            addCriterion("res_file_open_addr <>", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrGreaterThan(String value) {
            addCriterion("res_file_open_addr >", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrGreaterThanOrEqualTo(String value) {
            addCriterion("res_file_open_addr >=", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrLessThan(String value) {
            addCriterion("res_file_open_addr <", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrLessThanOrEqualTo(String value) {
            addCriterion("res_file_open_addr <=", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrLike(String value) {
            addCriterion("res_file_open_addr like", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrNotLike(String value) {
            addCriterion("res_file_open_addr not like", value, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrIn(List<String> values) {
            addCriterion("res_file_open_addr in", values, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrNotIn(List<String> values) {
            addCriterion("res_file_open_addr not in", values, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrBetween(String value1, String value2) {
            addCriterion("res_file_open_addr between", value1, value2, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileOpenAddrNotBetween(String value1, String value2) {
            addCriterion("res_file_open_addr not between", value1, value2, "resFileOpenAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrIsNull() {
            addCriterion("res_file_sub_addr is null");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrIsNotNull() {
            addCriterion("res_file_sub_addr is not null");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrEqualTo(String value) {
            addCriterion("res_file_sub_addr =", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrNotEqualTo(String value) {
            addCriterion("res_file_sub_addr <>", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrGreaterThan(String value) {
            addCriterion("res_file_sub_addr >", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrGreaterThanOrEqualTo(String value) {
            addCriterion("res_file_sub_addr >=", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrLessThan(String value) {
            addCriterion("res_file_sub_addr <", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrLessThanOrEqualTo(String value) {
            addCriterion("res_file_sub_addr <=", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrLike(String value) {
            addCriterion("res_file_sub_addr like", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrNotLike(String value) {
            addCriterion("res_file_sub_addr not like", value, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrIn(List<String> values) {
            addCriterion("res_file_sub_addr in", values, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrNotIn(List<String> values) {
            addCriterion("res_file_sub_addr not in", values, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrBetween(String value1, String value2) {
            addCriterion("res_file_sub_addr between", value1, value2, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andResFileSubAddrNotBetween(String value1, String value2) {
            addCriterion("res_file_sub_addr not between", value1, value2, "resFileSubAddr");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeIsNull() {
            addCriterion("sub_file_dead_time is null");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeIsNotNull() {
            addCriterion("sub_file_dead_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeEqualTo(String value) {
            addCriterion("sub_file_dead_time =", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeNotEqualTo(String value) {
            addCriterion("sub_file_dead_time <>", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeGreaterThan(String value) {
            addCriterion("sub_file_dead_time >", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sub_file_dead_time >=", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeLessThan(String value) {
            addCriterion("sub_file_dead_time <", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeLessThanOrEqualTo(String value) {
            addCriterion("sub_file_dead_time <=", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeLike(String value) {
            addCriterion("sub_file_dead_time like", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeNotLike(String value) {
            addCriterion("sub_file_dead_time not like", value, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeIn(List<String> values) {
            addCriterion("sub_file_dead_time in", values, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeNotIn(List<String> values) {
            addCriterion("sub_file_dead_time not in", values, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeBetween(String value1, String value2) {
            addCriterion("sub_file_dead_time between", value1, value2, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andSubFileDeadTimeNotBetween(String value1, String value2) {
            addCriterion("sub_file_dead_time not between", value1, value2, "subFileDeadTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeIsNull() {
            addCriterion(" prequalification_time is null");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeIsNotNull() {
            addCriterion(" prequalification_time is not null");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeEqualTo(String value) {
            addCriterion(" prequalification_time =", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeNotEqualTo(String value) {
            addCriterion(" prequalification_time <>", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeGreaterThan(String value) {
            addCriterion(" prequalification_time >", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeGreaterThanOrEqualTo(String value) {
            addCriterion(" prequalification_time >=", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeLessThan(String value) {
            addCriterion(" prequalification_time <", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeLessThanOrEqualTo(String value) {
            addCriterion(" prequalification_time <=", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeLike(String value) {
            addCriterion(" prequalification_time like", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeNotLike(String value) {
            addCriterion(" prequalification_time not like", value, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeIn(List<String> values) {
            addCriterion(" prequalification_time in", values, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeNotIn(List<String> values) {
            addCriterion(" prequalification_time not in", values, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeBetween(String value1, String value2) {
            addCriterion(" prequalification_time between", value1, value2, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andprequalificationTimeNotBetween(String value1, String value2) {
            addCriterion(" prequalification_time not between", value1, value2, " prequalificationTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeIsNull() {
            addCriterion("frist_pub_time is null");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeIsNotNull() {
            addCriterion("frist_pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeEqualTo(String value) {
            addCriterion("frist_pub_time =", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeNotEqualTo(String value) {
            addCriterion("frist_pub_time <>", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeGreaterThan(String value) {
            addCriterion("frist_pub_time >", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeGreaterThanOrEqualTo(String value) {
            addCriterion("frist_pub_time >=", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeLessThan(String value) {
            addCriterion("frist_pub_time <", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeLessThanOrEqualTo(String value) {
            addCriterion("frist_pub_time <=", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeLike(String value) {
            addCriterion("frist_pub_time like", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeNotLike(String value) {
            addCriterion("frist_pub_time not like", value, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeIn(List<String> values) {
            addCriterion("frist_pub_time in", values, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeNotIn(List<String> values) {
            addCriterion("frist_pub_time not in", values, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeBetween(String value1, String value2) {
            addCriterion("frist_pub_time between", value1, value2, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andFristPubTimeNotBetween(String value1, String value2) {
            addCriterion("frist_pub_time not between", value1, value2, "fristPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeIsNull() {
            addCriterion("pro_pub_time is null");
            return (Criteria) this;
        }

        public Criteria andProPubTimeIsNotNull() {
            addCriterion("pro_pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andProPubTimeEqualTo(String value) {
            addCriterion("pro_pub_time =", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeNotEqualTo(String value) {
            addCriterion("pro_pub_time <>", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeGreaterThan(String value) {
            addCriterion("pro_pub_time >", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_pub_time >=", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeLessThan(String value) {
            addCriterion("pro_pub_time <", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeLessThanOrEqualTo(String value) {
            addCriterion("pro_pub_time <=", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeLike(String value) {
            addCriterion("pro_pub_time like", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeNotLike(String value) {
            addCriterion("pro_pub_time not like", value, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeIn(List<String> values) {
            addCriterion("pro_pub_time in", values, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeNotIn(List<String> values) {
            addCriterion("pro_pub_time not in", values, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeBetween(String value1, String value2) {
            addCriterion("pro_pub_time between", value1, value2, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andProPubTimeNotBetween(String value1, String value2) {
            addCriterion("pro_pub_time not between", value1, value2, "proPubTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeIsNull() {
            addCriterion("obtain_bidding_file_time is null");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeIsNotNull() {
            addCriterion("obtain_bidding_file_time is not null");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeEqualTo(String value) {
            addCriterion("obtain_bidding_file_time =", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeNotEqualTo(String value) {
            addCriterion("obtain_bidding_file_time <>", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeGreaterThan(String value) {
            addCriterion("obtain_bidding_file_time >", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_bidding_file_time >=", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeLessThan(String value) {
            addCriterion("obtain_bidding_file_time <", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeLessThanOrEqualTo(String value) {
            addCriterion("obtain_bidding_file_time <=", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeLike(String value) {
            addCriterion("obtain_bidding_file_time like", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeNotLike(String value) {
            addCriterion("obtain_bidding_file_time not like", value, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeIn(List<String> values) {
            addCriterion("obtain_bidding_file_time in", values, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeNotIn(List<String> values) {
            addCriterion("obtain_bidding_file_time not in", values, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeBetween(String value1, String value2) {
            addCriterion("obtain_bidding_file_time between", value1, value2, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileTimeNotBetween(String value1, String value2) {
            addCriterion("obtain_bidding_file_time not between", value1, value2, "obtainBiddingFileTime");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrIsNull() {
            addCriterion("obtain_bidding_file_addr is null");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrIsNotNull() {
            addCriterion("obtain_bidding_file_addr is not null");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrEqualTo(String value) {
            addCriterion("obtain_bidding_file_addr =", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrNotEqualTo(String value) {
            addCriterion("obtain_bidding_file_addr <>", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrGreaterThan(String value) {
            addCriterion("obtain_bidding_file_addr >", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrGreaterThanOrEqualTo(String value) {
            addCriterion("obtain_bidding_file_addr >=", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrLessThan(String value) {
            addCriterion("obtain_bidding_file_addr <", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrLessThanOrEqualTo(String value) {
            addCriterion("obtain_bidding_file_addr <=", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrLike(String value) {
            addCriterion("obtain_bidding_file_addr like", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrNotLike(String value) {
            addCriterion("obtain_bidding_file_addr not like", value, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrIn(List<String> values) {
            addCriterion("obtain_bidding_file_addr in", values, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrNotIn(List<String> values) {
            addCriterion("obtain_bidding_file_addr not in", values, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrBetween(String value1, String value2) {
            addCriterion("obtain_bidding_file_addr between", value1, value2, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andObtainBiddingFileAddrNotBetween(String value1, String value2) {
            addCriterion("obtain_bidding_file_addr not between", value1, value2, "obtainBiddingFileAddr");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceIsNull() {
            addCriterion("bidding_file_price is null");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceIsNotNull() {
            addCriterion("bidding_file_price is not null");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceEqualTo(BigDecimal value) {
            addCriterion("bidding_file_price =", value, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceNotEqualTo(BigDecimal value) {
            addCriterion("bidding_file_price <>", value, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceGreaterThan(BigDecimal value) {
            addCriterion("bidding_file_price >", value, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bidding_file_price >=", value, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceLessThan(BigDecimal value) {
            addCriterion("bidding_file_price <", value, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bidding_file_price <=", value, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceIn(List<BigDecimal> values) {
            addCriterion("bidding_file_price in", values, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceNotIn(List<BigDecimal> values) {
            addCriterion("bidding_file_price not in", values, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bidding_file_price between", value1, value2, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andBiddingFilePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bidding_file_price not between", value1, value2, "biddingFilePrice");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeIsNull() {
            addCriterion("open_bidding_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeIsNotNull() {
            addCriterion("open_bidding_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeEqualTo(Date value) {
            addCriterion("open_bidding_time =", value, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeNotEqualTo(Date value) {
            addCriterion("open_bidding_time <>", value, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeGreaterThan(Date value) {
            addCriterion("open_bidding_time >", value, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_bidding_time >=", value, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeLessThan(Date value) {
            addCriterion("open_bidding_time <", value, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_bidding_time <=", value, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeIn(List<Date> values) {
            addCriterion("open_bidding_time in", values, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeNotIn(List<Date> values) {
            addCriterion("open_bidding_time not in", values, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeBetween(Date value1, Date value2) {
            addCriterion("open_bidding_time between", value1, value2, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_bidding_time not between", value1, value2, "openBiddingTime");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrIsNull() {
            addCriterion("open_bidding_addr is null");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrIsNotNull() {
            addCriterion("open_bidding_addr is not null");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrEqualTo(String value) {
            addCriterion("open_bidding_addr =", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrNotEqualTo(String value) {
            addCriterion("open_bidding_addr <>", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrGreaterThan(String value) {
            addCriterion("open_bidding_addr >", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrGreaterThanOrEqualTo(String value) {
            addCriterion("open_bidding_addr >=", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrLessThan(String value) {
            addCriterion("open_bidding_addr <", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrLessThanOrEqualTo(String value) {
            addCriterion("open_bidding_addr <=", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrLike(String value) {
            addCriterion("open_bidding_addr like", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrNotLike(String value) {
            addCriterion("open_bidding_addr not like", value, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrIn(List<String> values) {
            addCriterion("open_bidding_addr in", values, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrNotIn(List<String> values) {
            addCriterion("open_bidding_addr not in", values, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrBetween(String value1, String value2) {
            addCriterion("open_bidding_addr between", value1, value2, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andOpenBiddingAddrNotBetween(String value1, String value2) {
            addCriterion("open_bidding_addr not between", value1, value2, "openBiddingAddr");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeIsNull() {
            addCriterion("win_bidding_time is null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeIsNotNull() {
            addCriterion("win_bidding_time is not null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeEqualTo(String value) {
            addCriterion("win_bidding_time =", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeNotEqualTo(String value) {
            addCriterion("win_bidding_time <>", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeGreaterThan(String value) {
            addCriterion("win_bidding_time >", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("win_bidding_time >=", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeLessThan(String value) {
            addCriterion("win_bidding_time <", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeLessThanOrEqualTo(String value) {
            addCriterion("win_bidding_time <=", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeLike(String value) {
            addCriterion("win_bidding_time like", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeNotLike(String value) {
            addCriterion("win_bidding_time not like", value, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeIn(List<String> values) {
            addCriterion("win_bidding_time in", values, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeNotIn(List<String> values) {
            addCriterion("win_bidding_time not in", values, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeBetween(String value1, String value2) {
            addCriterion("win_bidding_time between", value1, value2, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTimeNotBetween(String value1, String value2) {
            addCriterion("win_bidding_time not between", value1, value2, "winBiddingTime");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNull() {
            addCriterion("expert_name is null");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNotNull() {
            addCriterion("expert_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpertNameEqualTo(String value) {
            addCriterion("expert_name =", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotEqualTo(String value) {
            addCriterion("expert_name <>", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThan(String value) {
            addCriterion("expert_name >", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThanOrEqualTo(String value) {
            addCriterion("expert_name >=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThan(String value) {
            addCriterion("expert_name <", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThanOrEqualTo(String value) {
            addCriterion("expert_name <=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLike(String value) {
            addCriterion("expert_name like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotLike(String value) {
            addCriterion("expert_name not like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameIn(List<String> values) {
            addCriterion("expert_name in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotIn(List<String> values) {
            addCriterion("expert_name not in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameBetween(String value1, String value2) {
            addCriterion("expert_name between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotBetween(String value1, String value2) {
            addCriterion("expert_name not between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andIsPppIsNull() {
            addCriterion("is_ppp is null");
            return (Criteria) this;
        }

        public Criteria andIsPppIsNotNull() {
            addCriterion("is_ppp is not null");
            return (Criteria) this;
        }

        public Criteria andIsPppEqualTo(Boolean value) {
            addCriterion("is_ppp =", value, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppNotEqualTo(Boolean value) {
            addCriterion("is_ppp <>", value, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppGreaterThan(Boolean value) {
            addCriterion("is_ppp >", value, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_ppp >=", value, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppLessThan(Boolean value) {
            addCriterion("is_ppp <", value, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppLessThanOrEqualTo(Boolean value) {
            addCriterion("is_ppp <=", value, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppIn(List<Boolean> values) {
            addCriterion("is_ppp in", values, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppNotIn(List<Boolean> values) {
            addCriterion("is_ppp not in", values, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppBetween(Boolean value1, Boolean value2) {
            addCriterion("is_ppp between", value1, value2, "isPpp");
            return (Criteria) this;
        }

        public Criteria andIsPppNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_ppp not between", value1, value2, "isPpp");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountIsNull() {
            addCriterion("budget_amount is null");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountIsNotNull() {
            addCriterion("budget_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountEqualTo(String value) {
            addCriterion("budget_amount =", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountNotEqualTo(String value) {
            addCriterion("budget_amount <>", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountGreaterThan(String value) {
            addCriterion("budget_amount >", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountGreaterThanOrEqualTo(String value) {
            addCriterion("budget_amount >=", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountLessThan(String value) {
            addCriterion("budget_amount <", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountLessThanOrEqualTo(String value) {
            addCriterion("budget_amount <=", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountLike(String value) {
            addCriterion("budget_amount like", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountNotLike(String value) {
            addCriterion("budget_amount not like", value, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountIn(List<String> values) {
            addCriterion("budget_amount in", values, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountNotIn(List<String> values) {
            addCriterion("budget_amount not in", values, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountBetween(String value1, String value2) {
            addCriterion("budget_amount between", value1, value2, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountNotBetween(String value1, String value2) {
            addCriterion("budget_amount not between", value1, value2, "budgetAmount");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyIsNull() {
            addCriterion("budget_amount_currency is null");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyIsNotNull() {
            addCriterion("budget_amount_currency is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyEqualTo(String value) {
            addCriterion("budget_amount_currency =", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyNotEqualTo(String value) {
            addCriterion("budget_amount_currency <>", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyGreaterThan(String value) {
            addCriterion("budget_amount_currency >", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("budget_amount_currency >=", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyLessThan(String value) {
            addCriterion("budget_amount_currency <", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyLessThanOrEqualTo(String value) {
            addCriterion("budget_amount_currency <=", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyLike(String value) {
            addCriterion("budget_amount_currency like", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyNotLike(String value) {
            addCriterion("budget_amount_currency not like", value, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyIn(List<String> values) {
            addCriterion("budget_amount_currency in", values, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyNotIn(List<String> values) {
            addCriterion("budget_amount_currency not in", values, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyBetween(String value1, String value2) {
            addCriterion("budget_amount_currency between", value1, value2, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountCurrencyNotBetween(String value1, String value2) {
            addCriterion("budget_amount_currency not between", value1, value2, "budgetAmountCurrency");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitIsNull() {
            addCriterion("budget_amount_unit is null");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitIsNotNull() {
            addCriterion("budget_amount_unit is not null");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitEqualTo(String value) {
            addCriterion("budget_amount_unit =", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitNotEqualTo(String value) {
            addCriterion("budget_amount_unit <>", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitGreaterThan(String value) {
            addCriterion("budget_amount_unit >", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitGreaterThanOrEqualTo(String value) {
            addCriterion("budget_amount_unit >=", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitLessThan(String value) {
            addCriterion("budget_amount_unit <", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitLessThanOrEqualTo(String value) {
            addCriterion("budget_amount_unit <=", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitLike(String value) {
            addCriterion("budget_amount_unit like", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitNotLike(String value) {
            addCriterion("budget_amount_unit not like", value, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitIn(List<String> values) {
            addCriterion("budget_amount_unit in", values, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitNotIn(List<String> values) {
            addCriterion("budget_amount_unit not in", values, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitBetween(String value1, String value2) {
            addCriterion("budget_amount_unit between", value1, value2, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andBudgetAmountUnitNotBetween(String value1, String value2) {
            addCriterion("budget_amount_unit not between", value1, value2, "budgetAmountUnit");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeIsNull() {
            addCriterion("contract_signing_time is null");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeIsNotNull() {
            addCriterion("contract_signing_time is not null");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeEqualTo(String value) {
            addCriterion("contract_signing_time =", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeNotEqualTo(String value) {
            addCriterion("contract_signing_time <>", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeGreaterThan(String value) {
            addCriterion("contract_signing_time >", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_signing_time >=", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeLessThan(String value) {
            addCriterion("contract_signing_time <", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeLessThanOrEqualTo(String value) {
            addCriterion("contract_signing_time <=", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeLike(String value) {
            addCriterion("contract_signing_time like", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeNotLike(String value) {
            addCriterion("contract_signing_time not like", value, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeIn(List<String> values) {
            addCriterion("contract_signing_time in", values, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeNotIn(List<String> values) {
            addCriterion("contract_signing_time not in", values, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeBetween(String value1, String value2) {
            addCriterion("contract_signing_time between", value1, value2, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andContractSigningTimeNotBetween(String value1, String value2) {
            addCriterion("contract_signing_time not between", value1, value2, "contractSigningTime");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountIsNull() {
            addCriterion("win_bidding_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountIsNotNull() {
            addCriterion("win_bidding_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountEqualTo(String value) {
            addCriterion("win_bidding_total_amount =", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountNotEqualTo(String value) {
            addCriterion("win_bidding_total_amount <>", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountGreaterThan(String value) {
            addCriterion("win_bidding_total_amount >", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountGreaterThanOrEqualTo(String value) {
            addCriterion("win_bidding_total_amount >=", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountLessThan(String value) {
            addCriterion("win_bidding_total_amount <", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountLessThanOrEqualTo(String value) {
            addCriterion("win_bidding_total_amount <=", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountLike(String value) {
            addCriterion("win_bidding_total_amount like", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountNotLike(String value) {
            addCriterion("win_bidding_total_amount not like", value, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountIn(List<String> values) {
            addCriterion("win_bidding_total_amount in", values, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountNotIn(List<String> values) {
            addCriterion("win_bidding_total_amount not in", values, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountBetween(String value1, String value2) {
            addCriterion("win_bidding_total_amount between", value1, value2, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountNotBetween(String value1, String value2) {
            addCriterion("win_bidding_total_amount not between", value1, value2, "winBiddingTotalAmount");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitIsNull() {
            addCriterion("win_bidding_total_amount_unit is null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitIsNotNull() {
            addCriterion("win_bidding_total_amount_unit is not null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitEqualTo(String value) {
            addCriterion("win_bidding_total_amount_unit =", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitNotEqualTo(String value) {
            addCriterion("win_bidding_total_amount_unit <>", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitGreaterThan(String value) {
            addCriterion("win_bidding_total_amount_unit >", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitGreaterThanOrEqualTo(String value) {
            addCriterion("win_bidding_total_amount_unit >=", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitLessThan(String value) {
            addCriterion("win_bidding_total_amount_unit <", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitLessThanOrEqualTo(String value) {
            addCriterion("win_bidding_total_amount_unit <=", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitLike(String value) {
            addCriterion("win_bidding_total_amount_unit like", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitNotLike(String value) {
            addCriterion("win_bidding_total_amount_unit not like", value, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitIn(List<String> values) {
            addCriterion("win_bidding_total_amount_unit in", values, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitNotIn(List<String> values) {
            addCriterion("win_bidding_total_amount_unit not in", values, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitBetween(String value1, String value2) {
            addCriterion("win_bidding_total_amount_unit between", value1, value2, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andWinBiddingTotalAmountUnitNotBetween(String value1, String value2) {
            addCriterion("win_bidding_total_amount_unit not between", value1, value2, "winBiddingTotalAmountUnit");
            return (Criteria) this;
        }

        public Criteria andProConnectIsNull() {
            addCriterion("pro_connect is null");
            return (Criteria) this;
        }

        public Criteria andProConnectIsNotNull() {
            addCriterion("pro_connect is not null");
            return (Criteria) this;
        }

        public Criteria andProConnectEqualTo(String value) {
            addCriterion("pro_connect =", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectNotEqualTo(String value) {
            addCriterion("pro_connect <>", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectGreaterThan(String value) {
            addCriterion("pro_connect >", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectGreaterThanOrEqualTo(String value) {
            addCriterion("pro_connect >=", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectLessThan(String value) {
            addCriterion("pro_connect <", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectLessThanOrEqualTo(String value) {
            addCriterion("pro_connect <=", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectLike(String value) {
            addCriterion("pro_connect like", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectNotLike(String value) {
            addCriterion("pro_connect not like", value, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectIn(List<String> values) {
            addCriterion("pro_connect in", values, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectNotIn(List<String> values) {
            addCriterion("pro_connect not in", values, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectBetween(String value1, String value2) {
            addCriterion("pro_connect between", value1, value2, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectNotBetween(String value1, String value2) {
            addCriterion("pro_connect not between", value1, value2, "proConnect");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneIsNull() {
            addCriterion("pro_connect_phone is null");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneIsNotNull() {
            addCriterion("pro_connect_phone is not null");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneEqualTo(String value) {
            addCriterion("pro_connect_phone =", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneNotEqualTo(String value) {
            addCriterion("pro_connect_phone <>", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneGreaterThan(String value) {
            addCriterion("pro_connect_phone >", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("pro_connect_phone >=", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneLessThan(String value) {
            addCriterion("pro_connect_phone <", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneLessThanOrEqualTo(String value) {
            addCriterion("pro_connect_phone <=", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneLike(String value) {
            addCriterion("pro_connect_phone like", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneNotLike(String value) {
            addCriterion("pro_connect_phone not like", value, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneIn(List<String> values) {
            addCriterion("pro_connect_phone in", values, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneNotIn(List<String> values) {
            addCriterion("pro_connect_phone not in", values, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneBetween(String value1, String value2) {
            addCriterion("pro_connect_phone between", value1, value2, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andProConnectPhoneNotBetween(String value1, String value2) {
            addCriterion("pro_connect_phone not between", value1, value2, "proConnectPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrIsNull() {
            addCriterion("purchaser_addr is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrIsNotNull() {
            addCriterion("purchaser_addr is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrEqualTo(String value) {
            addCriterion("purchaser_addr =", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrNotEqualTo(String value) {
            addCriterion("purchaser_addr <>", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrGreaterThan(String value) {
            addCriterion("purchaser_addr >", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrGreaterThanOrEqualTo(String value) {
            addCriterion("purchaser_addr >=", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrLessThan(String value) {
            addCriterion("purchaser_addr <", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrLessThanOrEqualTo(String value) {
            addCriterion("purchaser_addr <=", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrLike(String value) {
            addCriterion("purchaser_addr like", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrNotLike(String value) {
            addCriterion("purchaser_addr not like", value, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrIn(List<String> values) {
            addCriterion("purchaser_addr in", values, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrNotIn(List<String> values) {
            addCriterion("purchaser_addr not in", values, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrBetween(String value1, String value2) {
            addCriterion("purchaser_addr between", value1, value2, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserAddrNotBetween(String value1, String value2) {
            addCriterion("purchaser_addr not between", value1, value2, "purchaserAddr");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneIsNull() {
            addCriterion("purchaser_phone is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneIsNotNull() {
            addCriterion("purchaser_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneEqualTo(String value) {
            addCriterion("purchaser_phone =", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneNotEqualTo(String value) {
            addCriterion("purchaser_phone <>", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneGreaterThan(String value) {
            addCriterion("purchaser_phone >", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("purchaser_phone >=", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneLessThan(String value) {
            addCriterion("purchaser_phone <", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneLessThanOrEqualTo(String value) {
            addCriterion("purchaser_phone <=", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneLike(String value) {
            addCriterion("purchaser_phone like", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneNotLike(String value) {
            addCriterion("purchaser_phone not like", value, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneIn(List<String> values) {
            addCriterion("purchaser_phone in", values, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneNotIn(List<String> values) {
            addCriterion("purchaser_phone not in", values, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneBetween(String value1, String value2) {
            addCriterion("purchaser_phone between", value1, value2, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andPurchaserPhoneNotBetween(String value1, String value2) {
            addCriterion("purchaser_phone not between", value1, value2, "purchaserPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrIsNull() {
            addCriterion("agency_addr is null");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrIsNotNull() {
            addCriterion("agency_addr is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrEqualTo(String value) {
            addCriterion("agency_addr =", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrNotEqualTo(String value) {
            addCriterion("agency_addr <>", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrGreaterThan(String value) {
            addCriterion("agency_addr >", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrGreaterThanOrEqualTo(String value) {
            addCriterion("agency_addr >=", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrLessThan(String value) {
            addCriterion("agency_addr <", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrLessThanOrEqualTo(String value) {
            addCriterion("agency_addr <=", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrLike(String value) {
            addCriterion("agency_addr like", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrNotLike(String value) {
            addCriterion("agency_addr not like", value, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrIn(List<String> values) {
            addCriterion("agency_addr in", values, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrNotIn(List<String> values) {
            addCriterion("agency_addr not in", values, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrBetween(String value1, String value2) {
            addCriterion("agency_addr between", value1, value2, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyAddrNotBetween(String value1, String value2) {
            addCriterion("agency_addr not between", value1, value2, "agencyAddr");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIsNull() {
            addCriterion("agency_phone is null");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIsNotNull() {
            addCriterion("agency_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneEqualTo(String value) {
            addCriterion("agency_phone =", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotEqualTo(String value) {
            addCriterion("agency_phone <>", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneGreaterThan(String value) {
            addCriterion("agency_phone >", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("agency_phone >=", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLessThan(String value) {
            addCriterion("agency_phone <", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLessThanOrEqualTo(String value) {
            addCriterion("agency_phone <=", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneLike(String value) {
            addCriterion("agency_phone like", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotLike(String value) {
            addCriterion("agency_phone not like", value, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneIn(List<String> values) {
            addCriterion("agency_phone in", values, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotIn(List<String> values) {
            addCriterion("agency_phone not in", values, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneBetween(String value1, String value2) {
            addCriterion("agency_phone between", value1, value2, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andAgencyPhoneNotBetween(String value1, String value2) {
            addCriterion("agency_phone not between", value1, value2, "agencyPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierIsNull() {
            addCriterion("win_bidding_supplier is null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierIsNotNull() {
            addCriterion("win_bidding_supplier is not null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierEqualTo(String value) {
            addCriterion("win_bidding_supplier =", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierNotEqualTo(String value) {
            addCriterion("win_bidding_supplier <>", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierGreaterThan(String value) {
            addCriterion("win_bidding_supplier >", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("win_bidding_supplier >=", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierLessThan(String value) {
            addCriterion("win_bidding_supplier <", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierLessThanOrEqualTo(String value) {
            addCriterion("win_bidding_supplier <=", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierLike(String value) {
            addCriterion("win_bidding_supplier like", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierNotLike(String value) {
            addCriterion("win_bidding_supplier not like", value, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierIn(List<String> values) {
            addCriterion("win_bidding_supplier in", values, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierNotIn(List<String> values) {
            addCriterion("win_bidding_supplier not in", values, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierBetween(String value1, String value2) {
            addCriterion("win_bidding_supplier between", value1, value2, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierNotBetween(String value1, String value2) {
            addCriterion("win_bidding_supplier not between", value1, value2, "winBiddingSupplier");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneIsNull() {
            addCriterion("win_bidding_supplier_phone is null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneIsNotNull() {
            addCriterion("win_bidding_supplier_phone is not null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneEqualTo(String value) {
            addCriterion("win_bidding_supplier_phone =", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneNotEqualTo(String value) {
            addCriterion("win_bidding_supplier_phone <>", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneGreaterThan(String value) {
            addCriterion("win_bidding_supplier_phone >", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("win_bidding_supplier_phone >=", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneLessThan(String value) {
            addCriterion("win_bidding_supplier_phone <", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneLessThanOrEqualTo(String value) {
            addCriterion("win_bidding_supplier_phone <=", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneLike(String value) {
            addCriterion("win_bidding_supplier_phone like", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneNotLike(String value) {
            addCriterion("win_bidding_supplier_phone not like", value, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneIn(List<String> values) {
            addCriterion("win_bidding_supplier_phone in", values, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneNotIn(List<String> values) {
            addCriterion("win_bidding_supplier_phone not in", values, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneBetween(String value1, String value2) {
            addCriterion("win_bidding_supplier_phone between", value1, value2, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierPhoneNotBetween(String value1, String value2) {
            addCriterion("win_bidding_supplier_phone not between", value1, value2, "winBiddingSupplierPhone");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrIsNull() {
            addCriterion("win_bidding_supplier_addr is null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrIsNotNull() {
            addCriterion("win_bidding_supplier_addr is not null");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrEqualTo(String value) {
            addCriterion("win_bidding_supplier_addr =", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrNotEqualTo(String value) {
            addCriterion("win_bidding_supplier_addr <>", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrGreaterThan(String value) {
            addCriterion("win_bidding_supplier_addr >", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrGreaterThanOrEqualTo(String value) {
            addCriterion("win_bidding_supplier_addr >=", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrLessThan(String value) {
            addCriterion("win_bidding_supplier_addr <", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrLessThanOrEqualTo(String value) {
            addCriterion("win_bidding_supplier_addr <=", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrLike(String value) {
            addCriterion("win_bidding_supplier_addr like", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrNotLike(String value) {
            addCriterion("win_bidding_supplier_addr not like", value, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrIn(List<String> values) {
            addCriterion("win_bidding_supplier_addr in", values, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrNotIn(List<String> values) {
            addCriterion("win_bidding_supplier_addr not in", values, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrBetween(String value1, String value2) {
            addCriterion("win_bidding_supplier_addr between", value1, value2, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andWinBiddingSupplierAddrNotBetween(String value1, String value2) {
            addCriterion("win_bidding_supplier_addr not between", value1, value2, "winBiddingSupplierAddr");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexIsNull() {
            addCriterion("summary_annex is null");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexIsNotNull() {
            addCriterion("summary_annex is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexEqualTo(String value) {
            addCriterion("summary_annex =", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexNotEqualTo(String value) {
            addCriterion("summary_annex <>", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexGreaterThan(String value) {
            addCriterion("summary_annex >", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexGreaterThanOrEqualTo(String value) {
            addCriterion("summary_annex >=", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexLessThan(String value) {
            addCriterion("summary_annex <", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexLessThanOrEqualTo(String value) {
            addCriterion("summary_annex <=", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexLike(String value) {
            addCriterion("summary_annex like", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexNotLike(String value) {
            addCriterion("summary_annex not like", value, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexIn(List<String> values) {
            addCriterion("summary_annex in", values, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexNotIn(List<String> values) {
            addCriterion("summary_annex not in", values, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexBetween(String value1, String value2) {
            addCriterion("summary_annex between", value1, value2, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andSummaryAnnexNotBetween(String value1, String value2) {
            addCriterion("summary_annex not between", value1, value2, "summaryAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexIsNull() {
            addCriterion("text_annex is null");
            return (Criteria) this;
        }

        public Criteria andTextAnnexIsNotNull() {
            addCriterion("text_annex is not null");
            return (Criteria) this;
        }

        public Criteria andTextAnnexEqualTo(String value) {
            addCriterion("text_annex =", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexNotEqualTo(String value) {
            addCriterion("text_annex <>", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexGreaterThan(String value) {
            addCriterion("text_annex >", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexGreaterThanOrEqualTo(String value) {
            addCriterion("text_annex >=", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexLessThan(String value) {
            addCriterion("text_annex <", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexLessThanOrEqualTo(String value) {
            addCriterion("text_annex <=", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexLike(String value) {
            addCriterion("text_annex like", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexNotLike(String value) {
            addCriterion("text_annex not like", value, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexIn(List<String> values) {
            addCriterion("text_annex in", values, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexNotIn(List<String> values) {
            addCriterion("text_annex not in", values, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexBetween(String value1, String value2) {
            addCriterion("text_annex between", value1, value2, "textAnnex");
            return (Criteria) this;
        }

        public Criteria andTextAnnexNotBetween(String value1, String value2) {
            addCriterion("text_annex not between", value1, value2, "textAnnex");
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
