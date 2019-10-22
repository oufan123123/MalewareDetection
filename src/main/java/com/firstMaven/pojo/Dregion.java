package com.firstMaven.pojo;

public class Dregion {
    private Integer id;

    private String crrate;

    private Integer useractionnum;

    private Integer useractiontype;

    private String useraction;

    private Integer senapinum;

    private Integer senapitype;

    private String senapi;

    private Integer senpernum;

    private Integer senpertype;

    private String senper;

    private Integer apkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrrate() {
        return crrate;
    }

    public void setCrrate(String crrate) {
        this.crrate = crrate == null ? null : crrate.trim();
    }

    public Integer getUseractionnum() {
        return useractionnum;
    }

    public void setUseractionnum(Integer useractionnum) {
        this.useractionnum = useractionnum;
    }

    public Integer getUseractiontype() {
        return useractiontype;
    }

    public void setUseractiontype(Integer useractiontype) {
        this.useractiontype = useractiontype;
    }

    public String getUseraction() {
        return useraction;
    }

    public void setUseraction(String useraction) {
        this.useraction = useraction == null ? null : useraction.trim();
    }

    public Integer getSenapinum() {
        return senapinum;
    }

    public void setSenapinum(Integer senapinum) {
        this.senapinum = senapinum;
    }

    public Integer getSenapitype() {
        return senapitype;
    }

    public void setSenapitype(Integer senapitype) {
        this.senapitype = senapitype;
    }

    public String getSenapi() {
        return senapi;
    }

    public void setSenapi(String senapi) {
        this.senapi = senapi == null ? null : senapi.trim();
    }

    public Integer getSenpernum() {
        return senpernum;
    }

    public void setSenpernum(Integer senpernum) {
        this.senpernum = senpernum;
    }

    public Integer getSenpertype() {
        return senpertype;
    }

    public void setSenpertype(Integer senpertype) {
        this.senpertype = senpertype;
    }

    public String getSenper() {
        return senper;
    }

    public void setSenper(String senper) {
        this.senper = senper == null ? null : senper.trim();
    }

    public Integer getApkId() {
        return apkId;
    }

    public void setApkId(Integer apkId) {
        this.apkId = apkId;
    }
}