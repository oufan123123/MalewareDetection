package com.firstMaven.pojo;

import java.util.ArrayList;
import java.util.List;

public class DregionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DregionExample() {
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

        public Criteria andCrrateIsNull() {
            addCriterion("CRrate is null");
            return (Criteria) this;
        }

        public Criteria andCrrateIsNotNull() {
            addCriterion("CRrate is not null");
            return (Criteria) this;
        }

        public Criteria andCrrateEqualTo(String value) {
            addCriterion("CRrate =", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateNotEqualTo(String value) {
            addCriterion("CRrate <>", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateGreaterThan(String value) {
            addCriterion("CRrate >", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateGreaterThanOrEqualTo(String value) {
            addCriterion("CRrate >=", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateLessThan(String value) {
            addCriterion("CRrate <", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateLessThanOrEqualTo(String value) {
            addCriterion("CRrate <=", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateLike(String value) {
            addCriterion("CRrate like", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateNotLike(String value) {
            addCriterion("CRrate not like", value, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateIn(List<String> values) {
            addCriterion("CRrate in", values, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateNotIn(List<String> values) {
            addCriterion("CRrate not in", values, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateBetween(String value1, String value2) {
            addCriterion("CRrate between", value1, value2, "crrate");
            return (Criteria) this;
        }

        public Criteria andCrrateNotBetween(String value1, String value2) {
            addCriterion("CRrate not between", value1, value2, "crrate");
            return (Criteria) this;
        }

        public Criteria andUseractionnumIsNull() {
            addCriterion("userActionNum is null");
            return (Criteria) this;
        }

        public Criteria andUseractionnumIsNotNull() {
            addCriterion("userActionNum is not null");
            return (Criteria) this;
        }

        public Criteria andUseractionnumEqualTo(Integer value) {
            addCriterion("userActionNum =", value, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumNotEqualTo(Integer value) {
            addCriterion("userActionNum <>", value, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumGreaterThan(Integer value) {
            addCriterion("userActionNum >", value, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("userActionNum >=", value, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumLessThan(Integer value) {
            addCriterion("userActionNum <", value, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumLessThanOrEqualTo(Integer value) {
            addCriterion("userActionNum <=", value, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumIn(List<Integer> values) {
            addCriterion("userActionNum in", values, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumNotIn(List<Integer> values) {
            addCriterion("userActionNum not in", values, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumBetween(Integer value1, Integer value2) {
            addCriterion("userActionNum between", value1, value2, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("userActionNum not between", value1, value2, "useractionnum");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeIsNull() {
            addCriterion("userActionType is null");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeIsNotNull() {
            addCriterion("userActionType is not null");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeEqualTo(Integer value) {
            addCriterion("userActionType =", value, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeNotEqualTo(Integer value) {
            addCriterion("userActionType <>", value, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeGreaterThan(Integer value) {
            addCriterion("userActionType >", value, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("userActionType >=", value, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeLessThan(Integer value) {
            addCriterion("userActionType <", value, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeLessThanOrEqualTo(Integer value) {
            addCriterion("userActionType <=", value, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeIn(List<Integer> values) {
            addCriterion("userActionType in", values, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeNotIn(List<Integer> values) {
            addCriterion("userActionType not in", values, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeBetween(Integer value1, Integer value2) {
            addCriterion("userActionType between", value1, value2, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractiontypeNotBetween(Integer value1, Integer value2) {
            addCriterion("userActionType not between", value1, value2, "useractiontype");
            return (Criteria) this;
        }

        public Criteria andUseractionIsNull() {
            addCriterion("userAction is null");
            return (Criteria) this;
        }

        public Criteria andUseractionIsNotNull() {
            addCriterion("userAction is not null");
            return (Criteria) this;
        }

        public Criteria andUseractionEqualTo(String value) {
            addCriterion("userAction =", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionNotEqualTo(String value) {
            addCriterion("userAction <>", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionGreaterThan(String value) {
            addCriterion("userAction >", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionGreaterThanOrEqualTo(String value) {
            addCriterion("userAction >=", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionLessThan(String value) {
            addCriterion("userAction <", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionLessThanOrEqualTo(String value) {
            addCriterion("userAction <=", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionLike(String value) {
            addCriterion("userAction like", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionNotLike(String value) {
            addCriterion("userAction not like", value, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionIn(List<String> values) {
            addCriterion("userAction in", values, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionNotIn(List<String> values) {
            addCriterion("userAction not in", values, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionBetween(String value1, String value2) {
            addCriterion("userAction between", value1, value2, "useraction");
            return (Criteria) this;
        }

        public Criteria andUseractionNotBetween(String value1, String value2) {
            addCriterion("userAction not between", value1, value2, "useraction");
            return (Criteria) this;
        }

        public Criteria andSenapinumIsNull() {
            addCriterion("senApiNum is null");
            return (Criteria) this;
        }

        public Criteria andSenapinumIsNotNull() {
            addCriterion("senApiNum is not null");
            return (Criteria) this;
        }

        public Criteria andSenapinumEqualTo(Integer value) {
            addCriterion("senApiNum =", value, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumNotEqualTo(Integer value) {
            addCriterion("senApiNum <>", value, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumGreaterThan(Integer value) {
            addCriterion("senApiNum >", value, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumGreaterThanOrEqualTo(Integer value) {
            addCriterion("senApiNum >=", value, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumLessThan(Integer value) {
            addCriterion("senApiNum <", value, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumLessThanOrEqualTo(Integer value) {
            addCriterion("senApiNum <=", value, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumIn(List<Integer> values) {
            addCriterion("senApiNum in", values, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumNotIn(List<Integer> values) {
            addCriterion("senApiNum not in", values, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumBetween(Integer value1, Integer value2) {
            addCriterion("senApiNum between", value1, value2, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapinumNotBetween(Integer value1, Integer value2) {
            addCriterion("senApiNum not between", value1, value2, "senapinum");
            return (Criteria) this;
        }

        public Criteria andSenapitypeIsNull() {
            addCriterion("senApiType is null");
            return (Criteria) this;
        }

        public Criteria andSenapitypeIsNotNull() {
            addCriterion("senApiType is not null");
            return (Criteria) this;
        }

        public Criteria andSenapitypeEqualTo(Integer value) {
            addCriterion("senApiType =", value, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeNotEqualTo(Integer value) {
            addCriterion("senApiType <>", value, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeGreaterThan(Integer value) {
            addCriterion("senApiType >", value, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("senApiType >=", value, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeLessThan(Integer value) {
            addCriterion("senApiType <", value, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeLessThanOrEqualTo(Integer value) {
            addCriterion("senApiType <=", value, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeIn(List<Integer> values) {
            addCriterion("senApiType in", values, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeNotIn(List<Integer> values) {
            addCriterion("senApiType not in", values, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeBetween(Integer value1, Integer value2) {
            addCriterion("senApiType between", value1, value2, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapitypeNotBetween(Integer value1, Integer value2) {
            addCriterion("senApiType not between", value1, value2, "senapitype");
            return (Criteria) this;
        }

        public Criteria andSenapiIsNull() {
            addCriterion("senApi is null");
            return (Criteria) this;
        }

        public Criteria andSenapiIsNotNull() {
            addCriterion("senApi is not null");
            return (Criteria) this;
        }

        public Criteria andSenapiEqualTo(String value) {
            addCriterion("senApi =", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiNotEqualTo(String value) {
            addCriterion("senApi <>", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiGreaterThan(String value) {
            addCriterion("senApi >", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiGreaterThanOrEqualTo(String value) {
            addCriterion("senApi >=", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiLessThan(String value) {
            addCriterion("senApi <", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiLessThanOrEqualTo(String value) {
            addCriterion("senApi <=", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiLike(String value) {
            addCriterion("senApi like", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiNotLike(String value) {
            addCriterion("senApi not like", value, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiIn(List<String> values) {
            addCriterion("senApi in", values, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiNotIn(List<String> values) {
            addCriterion("senApi not in", values, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiBetween(String value1, String value2) {
            addCriterion("senApi between", value1, value2, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenapiNotBetween(String value1, String value2) {
            addCriterion("senApi not between", value1, value2, "senapi");
            return (Criteria) this;
        }

        public Criteria andSenpernumIsNull() {
            addCriterion("senPerNum is null");
            return (Criteria) this;
        }

        public Criteria andSenpernumIsNotNull() {
            addCriterion("senPerNum is not null");
            return (Criteria) this;
        }

        public Criteria andSenpernumEqualTo(Integer value) {
            addCriterion("senPerNum =", value, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumNotEqualTo(Integer value) {
            addCriterion("senPerNum <>", value, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumGreaterThan(Integer value) {
            addCriterion("senPerNum >", value, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("senPerNum >=", value, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumLessThan(Integer value) {
            addCriterion("senPerNum <", value, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumLessThanOrEqualTo(Integer value) {
            addCriterion("senPerNum <=", value, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumIn(List<Integer> values) {
            addCriterion("senPerNum in", values, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumNotIn(List<Integer> values) {
            addCriterion("senPerNum not in", values, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumBetween(Integer value1, Integer value2) {
            addCriterion("senPerNum between", value1, value2, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpernumNotBetween(Integer value1, Integer value2) {
            addCriterion("senPerNum not between", value1, value2, "senpernum");
            return (Criteria) this;
        }

        public Criteria andSenpertypeIsNull() {
            addCriterion("senPerType is null");
            return (Criteria) this;
        }

        public Criteria andSenpertypeIsNotNull() {
            addCriterion("senPerType is not null");
            return (Criteria) this;
        }

        public Criteria andSenpertypeEqualTo(Integer value) {
            addCriterion("senPerType =", value, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeNotEqualTo(Integer value) {
            addCriterion("senPerType <>", value, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeGreaterThan(Integer value) {
            addCriterion("senPerType >", value, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("senPerType >=", value, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeLessThan(Integer value) {
            addCriterion("senPerType <", value, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeLessThanOrEqualTo(Integer value) {
            addCriterion("senPerType <=", value, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeIn(List<Integer> values) {
            addCriterion("senPerType in", values, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeNotIn(List<Integer> values) {
            addCriterion("senPerType not in", values, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeBetween(Integer value1, Integer value2) {
            addCriterion("senPerType between", value1, value2, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenpertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("senPerType not between", value1, value2, "senpertype");
            return (Criteria) this;
        }

        public Criteria andSenperIsNull() {
            addCriterion("senPer is null");
            return (Criteria) this;
        }

        public Criteria andSenperIsNotNull() {
            addCriterion("senPer is not null");
            return (Criteria) this;
        }

        public Criteria andSenperEqualTo(String value) {
            addCriterion("senPer =", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperNotEqualTo(String value) {
            addCriterion("senPer <>", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperGreaterThan(String value) {
            addCriterion("senPer >", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperGreaterThanOrEqualTo(String value) {
            addCriterion("senPer >=", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperLessThan(String value) {
            addCriterion("senPer <", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperLessThanOrEqualTo(String value) {
            addCriterion("senPer <=", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperLike(String value) {
            addCriterion("senPer like", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperNotLike(String value) {
            addCriterion("senPer not like", value, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperIn(List<String> values) {
            addCriterion("senPer in", values, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperNotIn(List<String> values) {
            addCriterion("senPer not in", values, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperBetween(String value1, String value2) {
            addCriterion("senPer between", value1, value2, "senper");
            return (Criteria) this;
        }

        public Criteria andSenperNotBetween(String value1, String value2) {
            addCriterion("senPer not between", value1, value2, "senper");
            return (Criteria) this;
        }

        public Criteria andApkIdIsNull() {
            addCriterion("apk_id is null");
            return (Criteria) this;
        }

        public Criteria andApkIdIsNotNull() {
            addCriterion("apk_id is not null");
            return (Criteria) this;
        }

        public Criteria andApkIdEqualTo(Integer value) {
            addCriterion("apk_id =", value, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdNotEqualTo(Integer value) {
            addCriterion("apk_id <>", value, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdGreaterThan(Integer value) {
            addCriterion("apk_id >", value, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("apk_id >=", value, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdLessThan(Integer value) {
            addCriterion("apk_id <", value, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdLessThanOrEqualTo(Integer value) {
            addCriterion("apk_id <=", value, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdIn(List<Integer> values) {
            addCriterion("apk_id in", values, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdNotIn(List<Integer> values) {
            addCriterion("apk_id not in", values, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdBetween(Integer value1, Integer value2) {
            addCriterion("apk_id between", value1, value2, "apkId");
            return (Criteria) this;
        }

        public Criteria andApkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("apk_id not between", value1, value2, "apkId");
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