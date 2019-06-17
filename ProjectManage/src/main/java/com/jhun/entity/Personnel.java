package com.jhun.entity;

import java.util.Date;

public class Personnel {
    private Integer id;

    private String projectName;

    private String personnelType;

    private String personnelDuty;

    private String personnelName;

    private String personnelPhone;

    private String personnelEmail;

    private Date demandTime;

    private String founder;

    private String createTime;

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

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType == null ? null : personnelType.trim();
    }

    public String getPersonnelDuty() {
        return personnelDuty;
    }

    public void setPersonnelDuty(String personnelDuty) {
        this.personnelDuty = personnelDuty == null ? null : personnelDuty.trim();
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName == null ? null : personnelName.trim();
    }

    public String getPersonnelPhone() {
        return personnelPhone;
    }

    public void setPersonnelPhone(String personnelPhone) {
        this.personnelPhone = personnelPhone == null ? null : personnelPhone.trim();
    }

    public String getPersonnelEmail() {
        return personnelEmail;
    }

    public void setPersonnelEmail(String personnelEmail) {
        this.personnelEmail = personnelEmail == null ? null : personnelEmail.trim();
    }

    public Date getDemandTime() {
        return demandTime;
    }

    public void setDemandTime(Date demandTime) {
        this.demandTime = demandTime;
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
}