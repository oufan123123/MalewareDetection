package com.firstMaven.pojo;

public class Mapping401 {
    private Integer id;

    private String callerClass;

    private String callerMethod;

    private String callerMethodDesc;

    private String apiContent;

    private String permission;

    private String androidVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCallerClass() {
        return callerClass;
    }

    public void setCallerClass(String callerClass) {
        this.callerClass = callerClass == null ? null : callerClass.trim();
    }

    public String getCallerMethod() {
        return callerMethod;
    }

    public void setCallerMethod(String callerMethod) {
        this.callerMethod = callerMethod == null ? null : callerMethod.trim();
    }

    public String getCallerMethodDesc() {
        return callerMethodDesc;
    }

    public void setCallerMethodDesc(String callerMethodDesc) {
        this.callerMethodDesc = callerMethodDesc == null ? null : callerMethodDesc.trim();
    }

    public String getApiContent() {
        return apiContent;
    }

    public void setApiContent(String apiContent) {
        this.apiContent = apiContent == null ? null : apiContent.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion == null ? null : androidVersion.trim();
    }
}