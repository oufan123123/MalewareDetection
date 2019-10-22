package com.firstMaven.pojo;

public class SensitiveApi {
    private Integer id;

    private String content;

    private String androidVersion;

    private SenApiType senApiType;


    public SenApiType getSenApiType() {
        return senApiType;
    }

    public void setSenApiType(SenApiType senApiType) {
        this.senApiType = senApiType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion == null ? null : androidVersion.trim();
    }
}