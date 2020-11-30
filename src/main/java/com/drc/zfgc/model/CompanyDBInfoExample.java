package com.drc.zfgc.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyDBInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyDBInfoExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andConnectIsNull() {
            addCriterion("connect is null");
            return (Criteria) this;
        }

        public Criteria andConnectIsNotNull() {
            addCriterion("connect is not null");
            return (Criteria) this;
        }

        public Criteria andConnectEqualTo(String value) {
            addCriterion("connect =", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectNotEqualTo(String value) {
            addCriterion("connect <>", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectGreaterThan(String value) {
            addCriterion("connect >", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectGreaterThanOrEqualTo(String value) {
            addCriterion("connect >=", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectLessThan(String value) {
            addCriterion("connect <", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectLessThanOrEqualTo(String value) {
            addCriterion("connect <=", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectLike(String value) {
            addCriterion("connect like", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectNotLike(String value) {
            addCriterion("connect not like", value, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectIn(List<String> values) {
            addCriterion("connect in", values, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectNotIn(List<String> values) {
            addCriterion("connect not in", values, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectBetween(String value1, String value2) {
            addCriterion("connect between", value1, value2, "connect");
            return (Criteria) this;
        }

        public Criteria andConnectNotBetween(String value1, String value2) {
            addCriterion("connect not between", value1, value2, "connect");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phone_num like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phone_num not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrIsNull() {
            addCriterion("registered_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrIsNotNull() {
            addCriterion("registered_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrEqualTo(String value) {
            addCriterion("registered_addr =", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotEqualTo(String value) {
            addCriterion("registered_addr <>", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrGreaterThan(String value) {
            addCriterion("registered_addr >", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrGreaterThanOrEqualTo(String value) {
            addCriterion("registered_addr >=", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrLessThan(String value) {
            addCriterion("registered_addr <", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrLessThanOrEqualTo(String value) {
            addCriterion("registered_addr <=", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrLike(String value) {
            addCriterion("registered_addr like", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotLike(String value) {
            addCriterion("registered_addr not like", value, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrIn(List<String> values) {
            addCriterion("registered_addr in", values, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotIn(List<String> values) {
            addCriterion("registered_addr not in", values, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrBetween(String value1, String value2) {
            addCriterion("registered_addr between", value1, value2, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegisteredAddrNotBetween(String value1, String value2) {
            addCriterion("registered_addr not between", value1, value2, "registeredAddr");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNull() {
            addCriterion("reg_date is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("reg_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(String value) {
            addCriterion("reg_date =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(String value) {
            addCriterion("reg_date <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(String value) {
            addCriterion("reg_date >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(String value) {
            addCriterion("reg_date >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(String value) {
            addCriterion("reg_date <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(String value) {
            addCriterion("reg_date <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLike(String value) {
            addCriterion("reg_date like", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotLike(String value) {
            addCriterion("reg_date not like", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<String> values) {
            addCriterion("reg_date in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<String> values) {
            addCriterion("reg_date not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(String value1, String value2) {
            addCriterion("reg_date between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(String value1, String value2) {
            addCriterion("reg_date not between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNull() {
            addCriterion("reg_addr is null");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNotNull() {
            addCriterion("reg_addr is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddrEqualTo(String value) {
            addCriterion("reg_addr =", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotEqualTo(String value) {
            addCriterion("reg_addr <>", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThan(String value) {
            addCriterion("reg_addr >", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
            addCriterion("reg_addr >=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThan(String value) {
            addCriterion("reg_addr <", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThanOrEqualTo(String value) {
            addCriterion("reg_addr <=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLike(String value) {
            addCriterion("reg_addr like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotLike(String value) {
            addCriterion("reg_addr not like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIn(List<String> values) {
            addCriterion("reg_addr in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotIn(List<String> values) {
            addCriterion("reg_addr not in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrBetween(String value1, String value2) {
            addCriterion("reg_addr between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotBetween(String value1, String value2) {
            addCriterion("reg_addr not between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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
