package com.drc.zfgc.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInfoExample() {
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

        public Criteria andCorptelIsNull() {
            addCriterion("corpTel is null");
            return (Criteria) this;
        }

        public Criteria andCorptelIsNotNull() {
            addCriterion("corpTel is not null");
            return (Criteria) this;
        }

        public Criteria andCorptelEqualTo(String value) {
            addCriterion("corpTel =", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelNotEqualTo(String value) {
            addCriterion("corpTel <>", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelGreaterThan(String value) {
            addCriterion("corpTel >", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelGreaterThanOrEqualTo(String value) {
            addCriterion("corpTel >=", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelLessThan(String value) {
            addCriterion("corpTel <", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelLessThanOrEqualTo(String value) {
            addCriterion("corpTel <=", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelLike(String value) {
            addCriterion("corpTel like", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelNotLike(String value) {
            addCriterion("corpTel not like", value, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelIn(List<String> values) {
            addCriterion("corpTel in", values, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelNotIn(List<String> values) {
            addCriterion("corpTel not in", values, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelBetween(String value1, String value2) {
            addCriterion("corpTel between", value1, value2, "corptel");
            return (Criteria) this;
        }

        public Criteria andCorptelNotBetween(String value1, String value2) {
            addCriterion("corpTel not between", value1, value2, "corptel");
            return (Criteria) this;
        }

        public Criteria andAuditplaceIsNull() {
            addCriterion("auditPlace is null");
            return (Criteria) this;
        }

        public Criteria andAuditplaceIsNotNull() {
            addCriterion("auditPlace is not null");
            return (Criteria) this;
        }

        public Criteria andAuditplaceEqualTo(String value) {
            addCriterion("auditPlace =", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceNotEqualTo(String value) {
            addCriterion("auditPlace <>", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceGreaterThan(String value) {
            addCriterion("auditPlace >", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceGreaterThanOrEqualTo(String value) {
            addCriterion("auditPlace >=", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceLessThan(String value) {
            addCriterion("auditPlace <", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceLessThanOrEqualTo(String value) {
            addCriterion("auditPlace <=", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceLike(String value) {
            addCriterion("auditPlace like", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceNotLike(String value) {
            addCriterion("auditPlace not like", value, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceIn(List<String> values) {
            addCriterion("auditPlace in", values, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceNotIn(List<String> values) {
            addCriterion("auditPlace not in", values, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceBetween(String value1, String value2) {
            addCriterion("auditPlace between", value1, value2, "auditplace");
            return (Criteria) this;
        }

        public Criteria andAuditplaceNotBetween(String value1, String value2) {
            addCriterion("auditPlace not between", value1, value2, "auditplace");
            return (Criteria) this;
        }

        public Criteria andContactnmIsNull() {
            addCriterion("contactNm is null");
            return (Criteria) this;
        }

        public Criteria andContactnmIsNotNull() {
            addCriterion("contactNm is not null");
            return (Criteria) this;
        }

        public Criteria andContactnmEqualTo(String value) {
            addCriterion("contactNm =", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmNotEqualTo(String value) {
            addCriterion("contactNm <>", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmGreaterThan(String value) {
            addCriterion("contactNm >", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmGreaterThanOrEqualTo(String value) {
            addCriterion("contactNm >=", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmLessThan(String value) {
            addCriterion("contactNm <", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmLessThanOrEqualTo(String value) {
            addCriterion("contactNm <=", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmLike(String value) {
            addCriterion("contactNm like", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmNotLike(String value) {
            addCriterion("contactNm not like", value, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmIn(List<String> values) {
            addCriterion("contactNm in", values, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmNotIn(List<String> values) {
            addCriterion("contactNm not in", values, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmBetween(String value1, String value2) {
            addCriterion("contactNm between", value1, value2, "contactnm");
            return (Criteria) this;
        }

        public Criteria andContactnmNotBetween(String value1, String value2) {
            addCriterion("contactNm not between", value1, value2, "contactnm");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoIsNull() {
            addCriterion("bizLicRegNo is null");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoIsNotNull() {
            addCriterion("bizLicRegNo is not null");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoEqualTo(String value) {
            addCriterion("bizLicRegNo =", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoNotEqualTo(String value) {
            addCriterion("bizLicRegNo <>", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoGreaterThan(String value) {
            addCriterion("bizLicRegNo >", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoGreaterThanOrEqualTo(String value) {
            addCriterion("bizLicRegNo >=", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoLessThan(String value) {
            addCriterion("bizLicRegNo <", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoLessThanOrEqualTo(String value) {
            addCriterion("bizLicRegNo <=", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoLike(String value) {
            addCriterion("bizLicRegNo like", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoNotLike(String value) {
            addCriterion("bizLicRegNo not like", value, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoIn(List<String> values) {
            addCriterion("bizLicRegNo in", values, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoNotIn(List<String> values) {
            addCriterion("bizLicRegNo not in", values, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoBetween(String value1, String value2) {
            addCriterion("bizLicRegNo between", value1, value2, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andBizlicregnoNotBetween(String value1, String value2) {
            addCriterion("bizLicRegNo not between", value1, value2, "bizlicregno");
            return (Criteria) this;
        }

        public Criteria andAgentnmIsNull() {
            addCriterion("agentNm is null");
            return (Criteria) this;
        }

        public Criteria andAgentnmIsNotNull() {
            addCriterion("agentNm is not null");
            return (Criteria) this;
        }

        public Criteria andAgentnmEqualTo(String value) {
            addCriterion("agentNm =", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmNotEqualTo(String value) {
            addCriterion("agentNm <>", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmGreaterThan(String value) {
            addCriterion("agentNm >", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmGreaterThanOrEqualTo(String value) {
            addCriterion("agentNm >=", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmLessThan(String value) {
            addCriterion("agentNm <", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmLessThanOrEqualTo(String value) {
            addCriterion("agentNm <=", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmLike(String value) {
            addCriterion("agentNm like", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmNotLike(String value) {
            addCriterion("agentNm not like", value, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmIn(List<String> values) {
            addCriterion("agentNm in", values, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmNotIn(List<String> values) {
            addCriterion("agentNm not in", values, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmBetween(String value1, String value2) {
            addCriterion("agentNm between", value1, value2, "agentnm");
            return (Criteria) this;
        }

        public Criteria andAgentnmNotBetween(String value1, String value2) {
            addCriterion("agentNm not between", value1, value2, "agentnm");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrIsNull() {
            addCriterion("officeAddr is null");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrIsNotNull() {
            addCriterion("officeAddr is not null");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrEqualTo(String value) {
            addCriterion("officeAddr =", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrNotEqualTo(String value) {
            addCriterion("officeAddr <>", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrGreaterThan(String value) {
            addCriterion("officeAddr >", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrGreaterThanOrEqualTo(String value) {
            addCriterion("officeAddr >=", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrLessThan(String value) {
            addCriterion("officeAddr <", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrLessThanOrEqualTo(String value) {
            addCriterion("officeAddr <=", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrLike(String value) {
            addCriterion("officeAddr like", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrNotLike(String value) {
            addCriterion("officeAddr not like", value, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrIn(List<String> values) {
            addCriterion("officeAddr in", values, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrNotIn(List<String> values) {
            addCriterion("officeAddr not in", values, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrBetween(String value1, String value2) {
            addCriterion("officeAddr between", value1, value2, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andOfficeaddrNotBetween(String value1, String value2) {
            addCriterion("officeAddr not between", value1, value2, "officeaddr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrIsNull() {
            addCriterion("regValidDateStr is null");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrIsNotNull() {
            addCriterion("regValidDateStr is not null");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrEqualTo(String value) {
            addCriterion("regValidDateStr =", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrNotEqualTo(String value) {
            addCriterion("regValidDateStr <>", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrGreaterThan(String value) {
            addCriterion("regValidDateStr >", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrGreaterThanOrEqualTo(String value) {
            addCriterion("regValidDateStr >=", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrLessThan(String value) {
            addCriterion("regValidDateStr <", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrLessThanOrEqualTo(String value) {
            addCriterion("regValidDateStr <=", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrLike(String value) {
            addCriterion("regValidDateStr like", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrNotLike(String value) {
            addCriterion("regValidDateStr not like", value, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrIn(List<String> values) {
            addCriterion("regValidDateStr in", values, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrNotIn(List<String> values) {
            addCriterion("regValidDateStr not in", values, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrBetween(String value1, String value2) {
            addCriterion("regValidDateStr between", value1, value2, "regvaliddatestr");
            return (Criteria) this;
        }

        public Criteria andRegvaliddatestrNotBetween(String value1, String value2) {
            addCriterion("regValidDateStr not between", value1, value2, "regvaliddatestr");
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
