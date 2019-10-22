package com.firstMaven.pojo;

import java.util.List;

public class Permission {
    private String name;

    private String pmsGroup;

    private String level;

    private String constantValue;

    private Integer benignCount;

    private Integer malwareCount;

    private Double ratio;

    private List<Mapping401> mapping401List;

    public List<Mapping401> getMapping401List() {
        return mapping401List;
    }

    public void setMapping401List(List<Mapping401> mapping401List) {
        this.mapping401List = mapping401List;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPmsGroup() {
        return pmsGroup;
    }

    public void setPmsGroup(String pmsGroup) {
        this.pmsGroup = pmsGroup == null ? null : pmsGroup.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue == null ? null : constantValue.trim();
    }

    public Integer getBenignCount() {
        return benignCount;
    }

    public void setBenignCount(Integer benignCount) {
        this.benignCount = benignCount;
    }

    public Integer getMalwareCount() {
        return malwareCount;
    }

    public void setMalwareCount(Integer malwareCount) {
        this.malwareCount = malwareCount;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}