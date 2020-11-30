package com.drc.zfgc.model;

import java.util.ArrayList;
import java.util.List;

public class ItemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemsExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andParentItemIdIsNull() {
            addCriterion("parent_item_id is null");
            return (Criteria) this;
        }

        public Criteria andParentItemIdIsNotNull() {
            addCriterion("parent_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentItemIdEqualTo(String value) {
            addCriterion("parent_item_id =", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdNotEqualTo(String value) {
            addCriterion("parent_item_id <>", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdGreaterThan(String value) {
            addCriterion("parent_item_id >", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_item_id >=", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdLessThan(String value) {
            addCriterion("parent_item_id <", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdLessThanOrEqualTo(String value) {
            addCriterion("parent_item_id <=", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdLike(String value) {
            addCriterion("parent_item_id like", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdNotLike(String value) {
            addCriterion("parent_item_id not like", value, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdIn(List<String> values) {
            addCriterion("parent_item_id in", values, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdNotIn(List<String> values) {
            addCriterion("parent_item_id not in", values, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdBetween(String value1, String value2) {
            addCriterion("parent_item_id between", value1, value2, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andParentItemIdNotBetween(String value1, String value2) {
            addCriterion("parent_item_id not between", value1, value2, "parentItemId");
            return (Criteria) this;
        }

        public Criteria andItemLevelIsNull() {
            addCriterion("item_level is null");
            return (Criteria) this;
        }

        public Criteria andItemLevelIsNotNull() {
            addCriterion("item_level is not null");
            return (Criteria) this;
        }

        public Criteria andItemLevelEqualTo(String value) {
            addCriterion("item_level =", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelNotEqualTo(String value) {
            addCriterion("item_level <>", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelGreaterThan(String value) {
            addCriterion("item_level >", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelGreaterThanOrEqualTo(String value) {
            addCriterion("item_level >=", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelLessThan(String value) {
            addCriterion("item_level <", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelLessThanOrEqualTo(String value) {
            addCriterion("item_level <=", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelLike(String value) {
            addCriterion("item_level like", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelNotLike(String value) {
            addCriterion("item_level not like", value, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelIn(List<String> values) {
            addCriterion("item_level in", values, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelNotIn(List<String> values) {
            addCriterion("item_level not in", values, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelBetween(String value1, String value2) {
            addCriterion("item_level between", value1, value2, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemLevelNotBetween(String value1, String value2) {
            addCriterion("item_level not between", value1, value2, "itemLevel");
            return (Criteria) this;
        }

        public Criteria andItemFullpathIsNull() {
            addCriterion("item_fullpath is null");
            return (Criteria) this;
        }

        public Criteria andItemFullpathIsNotNull() {
            addCriterion("item_fullpath is not null");
            return (Criteria) this;
        }

        public Criteria andItemFullpathEqualTo(String value) {
            addCriterion("item_fullpath =", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathNotEqualTo(String value) {
            addCriterion("item_fullpath <>", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathGreaterThan(String value) {
            addCriterion("item_fullpath >", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathGreaterThanOrEqualTo(String value) {
            addCriterion("item_fullpath >=", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathLessThan(String value) {
            addCriterion("item_fullpath <", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathLessThanOrEqualTo(String value) {
            addCriterion("item_fullpath <=", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathLike(String value) {
            addCriterion("item_fullpath like", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathNotLike(String value) {
            addCriterion("item_fullpath not like", value, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathIn(List<String> values) {
            addCriterion("item_fullpath in", values, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathNotIn(List<String> values) {
            addCriterion("item_fullpath not in", values, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathBetween(String value1, String value2) {
            addCriterion("item_fullpath between", value1, value2, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullpathNotBetween(String value1, String value2) {
            addCriterion("item_fullpath not between", value1, value2, "itemFullpath");
            return (Criteria) this;
        }

        public Criteria andItemFullnameIsNull() {
            addCriterion("item_fullname is null");
            return (Criteria) this;
        }

        public Criteria andItemFullnameIsNotNull() {
            addCriterion("item_fullname is not null");
            return (Criteria) this;
        }

        public Criteria andItemFullnameEqualTo(String value) {
            addCriterion("item_fullname =", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameNotEqualTo(String value) {
            addCriterion("item_fullname <>", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameGreaterThan(String value) {
            addCriterion("item_fullname >", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("item_fullname >=", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameLessThan(String value) {
            addCriterion("item_fullname <", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameLessThanOrEqualTo(String value) {
            addCriterion("item_fullname <=", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameLike(String value) {
            addCriterion("item_fullname like", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameNotLike(String value) {
            addCriterion("item_fullname not like", value, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameIn(List<String> values) {
            addCriterion("item_fullname in", values, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameNotIn(List<String> values) {
            addCriterion("item_fullname not in", values, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameBetween(String value1, String value2) {
            addCriterion("item_fullname between", value1, value2, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andItemFullnameNotBetween(String value1, String value2) {
            addCriterion("item_fullname not between", value1, value2, "itemFullname");
            return (Criteria) this;
        }

        public Criteria andIsvaluedIsNull() {
            addCriterion("isvalued is null");
            return (Criteria) this;
        }

        public Criteria andIsvaluedIsNotNull() {
            addCriterion("isvalued is not null");
            return (Criteria) this;
        }

        public Criteria andIsvaluedEqualTo(String value) {
            addCriterion("isvalued =", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedNotEqualTo(String value) {
            addCriterion("isvalued <>", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedGreaterThan(String value) {
            addCriterion("isvalued >", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedGreaterThanOrEqualTo(String value) {
            addCriterion("isvalued >=", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedLessThan(String value) {
            addCriterion("isvalued <", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedLessThanOrEqualTo(String value) {
            addCriterion("isvalued <=", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedLike(String value) {
            addCriterion("isvalued like", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedNotLike(String value) {
            addCriterion("isvalued not like", value, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedIn(List<String> values) {
            addCriterion("isvalued in", values, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedNotIn(List<String> values) {
            addCriterion("isvalued not in", values, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedBetween(String value1, String value2) {
            addCriterion("isvalued between", value1, value2, "isvalued");
            return (Criteria) this;
        }

        public Criteria andIsvaluedNotBetween(String value1, String value2) {
            addCriterion("isvalued not between", value1, value2, "isvalued");
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
