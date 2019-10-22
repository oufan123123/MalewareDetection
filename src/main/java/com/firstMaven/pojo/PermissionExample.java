package com.firstMaven.pojo;

import java.util.ArrayList;
import java.util.List;

public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPmsGroupIsNull() {
            addCriterion("pms_group is null");
            return (Criteria) this;
        }

        public Criteria andPmsGroupIsNotNull() {
            addCriterion("pms_group is not null");
            return (Criteria) this;
        }

        public Criteria andPmsGroupEqualTo(String value) {
            addCriterion("pms_group =", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupNotEqualTo(String value) {
            addCriterion("pms_group <>", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupGreaterThan(String value) {
            addCriterion("pms_group >", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupGreaterThanOrEqualTo(String value) {
            addCriterion("pms_group >=", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupLessThan(String value) {
            addCriterion("pms_group <", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupLessThanOrEqualTo(String value) {
            addCriterion("pms_group <=", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupLike(String value) {
            addCriterion("pms_group like", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupNotLike(String value) {
            addCriterion("pms_group not like", value, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupIn(List<String> values) {
            addCriterion("pms_group in", values, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupNotIn(List<String> values) {
            addCriterion("pms_group not in", values, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupBetween(String value1, String value2) {
            addCriterion("pms_group between", value1, value2, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andPmsGroupNotBetween(String value1, String value2) {
            addCriterion("pms_group not between", value1, value2, "pmsGroup");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("_level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("_level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("_level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("_level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("_level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("_level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("_level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("_level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("_level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("_level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("_level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("_level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("_level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("_level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andConstantValueIsNull() {
            addCriterion("constant_value is null");
            return (Criteria) this;
        }

        public Criteria andConstantValueIsNotNull() {
            addCriterion("constant_value is not null");
            return (Criteria) this;
        }

        public Criteria andConstantValueEqualTo(String value) {
            addCriterion("constant_value =", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueNotEqualTo(String value) {
            addCriterion("constant_value <>", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueGreaterThan(String value) {
            addCriterion("constant_value >", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueGreaterThanOrEqualTo(String value) {
            addCriterion("constant_value >=", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueLessThan(String value) {
            addCriterion("constant_value <", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueLessThanOrEqualTo(String value) {
            addCriterion("constant_value <=", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueLike(String value) {
            addCriterion("constant_value like", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueNotLike(String value) {
            addCriterion("constant_value not like", value, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueIn(List<String> values) {
            addCriterion("constant_value in", values, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueNotIn(List<String> values) {
            addCriterion("constant_value not in", values, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueBetween(String value1, String value2) {
            addCriterion("constant_value between", value1, value2, "constantValue");
            return (Criteria) this;
        }

        public Criteria andConstantValueNotBetween(String value1, String value2) {
            addCriterion("constant_value not between", value1, value2, "constantValue");
            return (Criteria) this;
        }

        public Criteria andBenignCountIsNull() {
            addCriterion("benign_count is null");
            return (Criteria) this;
        }

        public Criteria andBenignCountIsNotNull() {
            addCriterion("benign_count is not null");
            return (Criteria) this;
        }

        public Criteria andBenignCountEqualTo(Integer value) {
            addCriterion("benign_count =", value, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountNotEqualTo(Integer value) {
            addCriterion("benign_count <>", value, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountGreaterThan(Integer value) {
            addCriterion("benign_count >", value, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("benign_count >=", value, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountLessThan(Integer value) {
            addCriterion("benign_count <", value, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountLessThanOrEqualTo(Integer value) {
            addCriterion("benign_count <=", value, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountIn(List<Integer> values) {
            addCriterion("benign_count in", values, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountNotIn(List<Integer> values) {
            addCriterion("benign_count not in", values, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountBetween(Integer value1, Integer value2) {
            addCriterion("benign_count between", value1, value2, "benignCount");
            return (Criteria) this;
        }

        public Criteria andBenignCountNotBetween(Integer value1, Integer value2) {
            addCriterion("benign_count not between", value1, value2, "benignCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountIsNull() {
            addCriterion("malware_count is null");
            return (Criteria) this;
        }

        public Criteria andMalwareCountIsNotNull() {
            addCriterion("malware_count is not null");
            return (Criteria) this;
        }

        public Criteria andMalwareCountEqualTo(Integer value) {
            addCriterion("malware_count =", value, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountNotEqualTo(Integer value) {
            addCriterion("malware_count <>", value, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountGreaterThan(Integer value) {
            addCriterion("malware_count >", value, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("malware_count >=", value, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountLessThan(Integer value) {
            addCriterion("malware_count <", value, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountLessThanOrEqualTo(Integer value) {
            addCriterion("malware_count <=", value, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountIn(List<Integer> values) {
            addCriterion("malware_count in", values, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountNotIn(List<Integer> values) {
            addCriterion("malware_count not in", values, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountBetween(Integer value1, Integer value2) {
            addCriterion("malware_count between", value1, value2, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andMalwareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("malware_count not between", value1, value2, "malwareCount");
            return (Criteria) this;
        }

        public Criteria andRatioIsNull() {
            addCriterion("ratio is null");
            return (Criteria) this;
        }

        public Criteria andRatioIsNotNull() {
            addCriterion("ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRatioEqualTo(Double value) {
            addCriterion("ratio =", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotEqualTo(Double value) {
            addCriterion("ratio <>", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThan(Double value) {
            addCriterion("ratio >", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThanOrEqualTo(Double value) {
            addCriterion("ratio >=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThan(Double value) {
            addCriterion("ratio <", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThanOrEqualTo(Double value) {
            addCriterion("ratio <=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioIn(List<Double> values) {
            addCriterion("ratio in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotIn(List<Double> values) {
            addCriterion("ratio not in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioBetween(Double value1, Double value2) {
            addCriterion("ratio between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotBetween(Double value1, Double value2) {
            addCriterion("ratio not between", value1, value2, "ratio");
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