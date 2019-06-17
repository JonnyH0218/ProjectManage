package com.jhun.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Problem {
    private Integer id;

    private String projectName;

    private String projectAssembly;

    private String problemSketch;

    private String problemDescribe;

    private String problemState;

    private String problemHandlerDepartment;

    private String problemHandler;

    private String problemPriority;

    private String founder;

    private String createTime;

    private String copysender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectTime;

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

    public String getProjectAssembly() {
        return projectAssembly;
    }

    public void setProjectAssembly(String projectAssembly) {
        this.projectAssembly = projectAssembly == null ? null : projectAssembly.trim();
    }

    public String getProblemSketch() {
        return problemSketch;
    }

    public void setProblemSketch(String problemSketch) {
        this.problemSketch = problemSketch == null ? null : problemSketch.trim();
    }

    public String getProblemDescribe() {
        return problemDescribe;
    }

    public void setProblemDescribe(String problemDescribe) {
        this.problemDescribe = problemDescribe == null ? null : problemDescribe.trim();
    }

    public String getProblemState() {
        return problemState;
    }

    public void setProblemState(String problemState) {
        this.problemState = problemState == null ? null : problemState.trim();
    }

    public String getProblemHandlerDepartment() {
        return problemHandlerDepartment;
    }

    public void setProblemHandlerDepartment(String problemHandlerDepartment) {
        this.problemHandlerDepartment = problemHandlerDepartment == null ? null : problemHandlerDepartment.trim();
    }

    public String getProblemHandler() {
        return problemHandler;
    }

    public void setProblemHandler(String problemHandler) {
        this.problemHandler = problemHandler == null ? null : problemHandler.trim();
    }

    public String getProblemPriority() {
        return problemPriority;
    }

    public void setProblemPriority(String problemPriority) {
        this.problemPriority = problemPriority == null ? null : problemPriority.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCopysender() {
        return copysender;
    }

    public void setCopysender(String copysender) {
        this.copysender = copysender == null ? null : copysender.trim();
    }

    public Date getExpectTime() {
        return expectTime;
    }

    public void setExpectTime(Date expectTime) {
        this.expectTime = expectTime;
    }
}