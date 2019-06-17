package com.jhun.entity;

import java.util.Date;

public class Record {
    private Integer id;

    private String projectName;

    private String recordCategory;

    private String projectCharger;

    private String createTime;

    private String founder;

    private String copysender;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getRecordCategory() {
        return recordCategory;
    }

    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory == null ? null : recordCategory.trim();
    }

    public String getProjectCharger() {
        return projectCharger;
    }

    public void setProjectCharger(String projectCharger) {
        this.projectCharger = projectCharger == null ? null : projectCharger.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getCopysender() {
        return copysender;
    }

    public void setCopysender(String copysender) {
        this.copysender = copysender == null ? null : copysender.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}