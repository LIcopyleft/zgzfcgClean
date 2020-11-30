package com.drc.zfgc.model;

import java.util.ArrayList;
import java.util.List;

public class CNGovDataContentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CNGovDataContentExample() {
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
