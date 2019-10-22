package com.firstMaven.pojo;

import java.util.ArrayList;
import java.util.List;

public class SenApiTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SenApiTypeExample() {
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

        public Criteria andSenApiIdIsNull() {
            addCriterion("sen_api_id is null");
            return (Criteria) this;
        }

        public Criteria andSenApiIdIsNotNull() {
            addCriterion("sen_api_id is not null");
            return (Criteria) this;
        }

        public Criteria andSenApiIdEqualTo(Integer value) {
            addCriterion("sen_api_id =", value, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdNotEqualTo(Integer value) {
            addCriterion("sen_api_id <>", value, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdGreaterThan(Integer value) {
            addCriterion("sen_api_id >", value, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sen_api_id >=", value, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdLessThan(Integer value) {
            addCriterion("sen_api_id <", value, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdLessThanOrEqualTo(Integer value) {
            addCriterion("sen_api_id <=", value, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdIn(List<Integer> values) {
            addCriterion("sen_api_id in", values, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdNotIn(List<Integer> values) {
            addCriterion("sen_api_id not in", values, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdBetween(Integer value1, Integer value2) {
            addCriterion("sen_api_id between", value1, value2, "senApiId");
            return (Criteria) this;
        }

        public Criteria andSenApiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sen_api_id not between", value1, value2, "senApiId");
            return (Criteria) this;
        }

        public Criteria andAdwareIsNull() {
            addCriterion("Adware is null");
            return (Criteria) this;
        }

        public Criteria andAdwareIsNotNull() {
            addCriterion("Adware is not null");
            return (Criteria) this;
        }

        public Criteria andAdwareEqualTo(Integer value) {
            addCriterion("Adware =", value, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareNotEqualTo(Integer value) {
            addCriterion("Adware <>", value, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareGreaterThan(Integer value) {
            addCriterion("Adware >", value, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareGreaterThanOrEqualTo(Integer value) {
            addCriterion("Adware >=", value, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareLessThan(Integer value) {
            addCriterion("Adware <", value, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareLessThanOrEqualTo(Integer value) {
            addCriterion("Adware <=", value, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareIn(List<Integer> values) {
            addCriterion("Adware in", values, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareNotIn(List<Integer> values) {
            addCriterion("Adware not in", values, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareBetween(Integer value1, Integer value2) {
            addCriterion("Adware between", value1, value2, "adware");
            return (Criteria) this;
        }

        public Criteria andAdwareNotBetween(Integer value1, Integer value2) {
            addCriterion("Adware not between", value1, value2, "adware");
            return (Criteria) this;
        }

        public Criteria andBackdoorIsNull() {
            addCriterion("Backdoor is null");
            return (Criteria) this;
        }

        public Criteria andBackdoorIsNotNull() {
            addCriterion("Backdoor is not null");
            return (Criteria) this;
        }

        public Criteria andBackdoorEqualTo(Integer value) {
            addCriterion("Backdoor =", value, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorNotEqualTo(Integer value) {
            addCriterion("Backdoor <>", value, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorGreaterThan(Integer value) {
            addCriterion("Backdoor >", value, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorGreaterThanOrEqualTo(Integer value) {
            addCriterion("Backdoor >=", value, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorLessThan(Integer value) {
            addCriterion("Backdoor <", value, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorLessThanOrEqualTo(Integer value) {
            addCriterion("Backdoor <=", value, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorIn(List<Integer> values) {
            addCriterion("Backdoor in", values, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorNotIn(List<Integer> values) {
            addCriterion("Backdoor not in", values, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorBetween(Integer value1, Integer value2) {
            addCriterion("Backdoor between", value1, value2, "backdoor");
            return (Criteria) this;
        }

        public Criteria andBackdoorNotBetween(Integer value1, Integer value2) {
            addCriterion("Backdoor not between", value1, value2, "backdoor");
            return (Criteria) this;
        }

        public Criteria andHackertoolIsNull() {
            addCriterion("HackerTool is null");
            return (Criteria) this;
        }

        public Criteria andHackertoolIsNotNull() {
            addCriterion("HackerTool is not null");
            return (Criteria) this;
        }

        public Criteria andHackertoolEqualTo(Integer value) {
            addCriterion("HackerTool =", value, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolNotEqualTo(Integer value) {
            addCriterion("HackerTool <>", value, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolGreaterThan(Integer value) {
            addCriterion("HackerTool >", value, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolGreaterThanOrEqualTo(Integer value) {
            addCriterion("HackerTool >=", value, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolLessThan(Integer value) {
            addCriterion("HackerTool <", value, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolLessThanOrEqualTo(Integer value) {
            addCriterion("HackerTool <=", value, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolIn(List<Integer> values) {
            addCriterion("HackerTool in", values, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolNotIn(List<Integer> values) {
            addCriterion("HackerTool not in", values, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolBetween(Integer value1, Integer value2) {
            addCriterion("HackerTool between", value1, value2, "hackertool");
            return (Criteria) this;
        }

        public Criteria andHackertoolNotBetween(Integer value1, Integer value2) {
            addCriterion("HackerTool not between", value1, value2, "hackertool");
            return (Criteria) this;
        }

        public Criteria andRansomIsNull() {
            addCriterion("Ransom is null");
            return (Criteria) this;
        }

        public Criteria andRansomIsNotNull() {
            addCriterion("Ransom is not null");
            return (Criteria) this;
        }

        public Criteria andRansomEqualTo(Integer value) {
            addCriterion("Ransom =", value, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomNotEqualTo(Integer value) {
            addCriterion("Ransom <>", value, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomGreaterThan(Integer value) {
            addCriterion("Ransom >", value, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomGreaterThanOrEqualTo(Integer value) {
            addCriterion("Ransom >=", value, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomLessThan(Integer value) {
            addCriterion("Ransom <", value, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomLessThanOrEqualTo(Integer value) {
            addCriterion("Ransom <=", value, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomIn(List<Integer> values) {
            addCriterion("Ransom in", values, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomNotIn(List<Integer> values) {
            addCriterion("Ransom not in", values, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomBetween(Integer value1, Integer value2) {
            addCriterion("Ransom between", value1, value2, "ransom");
            return (Criteria) this;
        }

        public Criteria andRansomNotBetween(Integer value1, Integer value2) {
            addCriterion("Ransom not between", value1, value2, "ransom");
            return (Criteria) this;
        }

        public Criteria andTrojanIsNull() {
            addCriterion("Trojan is null");
            return (Criteria) this;
        }

        public Criteria andTrojanIsNotNull() {
            addCriterion("Trojan is not null");
            return (Criteria) this;
        }

        public Criteria andTrojanEqualTo(Integer value) {
            addCriterion("Trojan =", value, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanNotEqualTo(Integer value) {
            addCriterion("Trojan <>", value, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanGreaterThan(Integer value) {
            addCriterion("Trojan >", value, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trojan >=", value, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanLessThan(Integer value) {
            addCriterion("Trojan <", value, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanLessThanOrEqualTo(Integer value) {
            addCriterion("Trojan <=", value, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanIn(List<Integer> values) {
            addCriterion("Trojan in", values, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanNotIn(List<Integer> values) {
            addCriterion("Trojan not in", values, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanBetween(Integer value1, Integer value2) {
            addCriterion("Trojan between", value1, value2, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanNotBetween(Integer value1, Integer value2) {
            addCriterion("Trojan not between", value1, value2, "trojan");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerIsNull() {
            addCriterion("Trojan_Banker is null");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerIsNotNull() {
            addCriterion("Trojan_Banker is not null");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerEqualTo(Integer value) {
            addCriterion("Trojan_Banker =", value, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerNotEqualTo(Integer value) {
            addCriterion("Trojan_Banker <>", value, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerGreaterThan(Integer value) {
            addCriterion("Trojan_Banker >", value, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Banker >=", value, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerLessThan(Integer value) {
            addCriterion("Trojan_Banker <", value, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerLessThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Banker <=", value, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerIn(List<Integer> values) {
            addCriterion("Trojan_Banker in", values, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerNotIn(List<Integer> values) {
            addCriterion("Trojan_Banker not in", values, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Banker between", value1, value2, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanBankerNotBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Banker not between", value1, value2, "trojanBanker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerIsNull() {
            addCriterion("Trojan_Clicker is null");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerIsNotNull() {
            addCriterion("Trojan_Clicker is not null");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerEqualTo(Integer value) {
            addCriterion("Trojan_Clicker =", value, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerNotEqualTo(Integer value) {
            addCriterion("Trojan_Clicker <>", value, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerGreaterThan(Integer value) {
            addCriterion("Trojan_Clicker >", value, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Clicker >=", value, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerLessThan(Integer value) {
            addCriterion("Trojan_Clicker <", value, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerLessThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Clicker <=", value, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerIn(List<Integer> values) {
            addCriterion("Trojan_Clicker in", values, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerNotIn(List<Integer> values) {
            addCriterion("Trojan_Clicker not in", values, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Clicker between", value1, value2, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanClickerNotBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Clicker not between", value1, value2, "trojanClicker");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperIsNull() {
            addCriterion("Trojan_Dropper is null");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperIsNotNull() {
            addCriterion("Trojan_Dropper is not null");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperEqualTo(Integer value) {
            addCriterion("Trojan_Dropper =", value, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperNotEqualTo(Integer value) {
            addCriterion("Trojan_Dropper <>", value, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperGreaterThan(Integer value) {
            addCriterion("Trojan_Dropper >", value, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Dropper >=", value, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperLessThan(Integer value) {
            addCriterion("Trojan_Dropper <", value, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperLessThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Dropper <=", value, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperIn(List<Integer> values) {
            addCriterion("Trojan_Dropper in", values, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperNotIn(List<Integer> values) {
            addCriterion("Trojan_Dropper not in", values, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Dropper between", value1, value2, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanDropperNotBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Dropper not between", value1, value2, "trojanDropper");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsIsNull() {
            addCriterion("Trojan_SMS is null");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsIsNotNull() {
            addCriterion("Trojan_SMS is not null");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsEqualTo(Integer value) {
            addCriterion("Trojan_SMS =", value, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsNotEqualTo(Integer value) {
            addCriterion("Trojan_SMS <>", value, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsGreaterThan(Integer value) {
            addCriterion("Trojan_SMS >", value, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trojan_SMS >=", value, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsLessThan(Integer value) {
            addCriterion("Trojan_SMS <", value, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsLessThanOrEqualTo(Integer value) {
            addCriterion("Trojan_SMS <=", value, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsIn(List<Integer> values) {
            addCriterion("Trojan_SMS in", values, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsNotIn(List<Integer> values) {
            addCriterion("Trojan_SMS not in", values, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_SMS between", value1, value2, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSmsNotBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_SMS not between", value1, value2, "trojanSms");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyIsNull() {
            addCriterion("Trojan_Spy is null");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyIsNotNull() {
            addCriterion("Trojan_Spy is not null");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyEqualTo(Integer value) {
            addCriterion("Trojan_Spy =", value, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyNotEqualTo(Integer value) {
            addCriterion("Trojan_Spy <>", value, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyGreaterThan(Integer value) {
            addCriterion("Trojan_Spy >", value, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyGreaterThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Spy >=", value, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyLessThan(Integer value) {
            addCriterion("Trojan_Spy <", value, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyLessThanOrEqualTo(Integer value) {
            addCriterion("Trojan_Spy <=", value, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyIn(List<Integer> values) {
            addCriterion("Trojan_Spy in", values, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyNotIn(List<Integer> values) {
            addCriterion("Trojan_Spy not in", values, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Spy between", value1, value2, "trojanSpy");
            return (Criteria) this;
        }

        public Criteria andTrojanSpyNotBetween(Integer value1, Integer value2) {
            addCriterion("Trojan_Spy not between", value1, value2, "trojanSpy");
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