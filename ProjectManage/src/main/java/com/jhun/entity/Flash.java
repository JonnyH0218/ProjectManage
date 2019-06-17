package com.jhun.entity;

import java.util.Date;

public class Flash {
    private Integer id;

    private String projectName;

    private String flashType;

    private Integer flashSerialnumber;

    private String flashHander;

    private String founder;

    private String detail;

    private String state;

    private String flashHandler;

    private Date createTime;

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

    public String getFlashType() {
        return flashType;
    }

    public void setFlashType(String flashType) {
        this.flashType = flashType == null ? null : flashType.trim();
    }

    public Integer getFlashSerialnumber() {
        return flashSerialnumber;
    }

    public void setFlashSerialnumber(Integer flashSerialnumber) {
        this.flashSerialnumber = flashSerialnumber;
    }

    public String getFlashHander() {
        return flashHander;
    }

    public void setFlashHander(String flashHander) {
        this.flashHander = flashHander == null ? null : flashHander.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getFlashHandler() {
        return flashHandler;
    }

    public void setFlashHandler(String flashHandler) {
        this.flashHandler = flashHandler == null ? null : flashHandler.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}