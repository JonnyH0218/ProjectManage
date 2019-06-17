package com.jhun.entity;

import java.util.Date;

public class Problemsolution {
    private Integer id;

    private Integer problemId;

    private String problemSketch;

    private String problemReview;

    private String problemSolution;

    private String problemState;

    private String problemHandlerDepartment;

    private String problemHandler;

    private String founder;

    private String createTime;

    private String copysender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getProblemSketch() {
        return problemSketch;
    }

    public void setProblemSketch(String problemSketch) {
        this.problemSketch = problemSketch == null ? null : problemSketch.trim();
    }

    public String getProblemReview() {
        return problemReview;
    }

    public void setProblemReview(String problemReview) {
        this.problemReview = problemReview == null ? null : problemReview.trim();
    }

    public String getProblemSolution() {
        return problemSolution;
    }

    public void setProblemSolution(String problemSolution) {
        this.problemSolution = problemSolution == null ? null : problemSolution.trim();
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
}