package com.jhun.entity;

import java.util.Date;

public class Equipment {
    private Integer id;

    private String equipmentType;

    private String equipmentName;

    private String projectName;

    private String equipmentSketch;

    private String equipmentDescribe;

    private String equipmentState;

    private String equipmentHandlerDepartment;

    private String equipmentHandler;

    private String founder;

    private Date createTime;

    private String copysender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType == null ? null : equipmentType.trim();
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName == null ? null : equipmentName.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getEquipmentSketch() {
        return equipmentSketch;
    }

    public void setEquipmentSketch(String equipmentSketch) {
        this.equipmentSketch = equipmentSketch == null ? null : equipmentSketch.trim();
    }

    public String getEquipmentDescribe() {
        return equipmentDescribe;
    }

    public void setEquipmentDescribe(String equipmentDescribe) {
        this.equipmentDescribe = equipmentDescribe == null ? null : equipmentDescribe.trim();
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState == null ? null : equipmentState.trim();
    }

    public String getEquipmentHandlerDepartment() {
        return equipmentHandlerDepartment;
    }

    public void setEquipmentHandlerDepartment(String equipmentHandlerDepartment) {
        this.equipmentHandlerDepartment = equipmentHandlerDepartment == null ? null : equipmentHandlerDepartment.trim();
    }

    public String getEquipmentHandler() {
        return equipmentHandler;
    }

    public void setEquipmentHandler(String equipmentHandler) {
        this.equipmentHandler = equipmentHandler == null ? null : equipmentHandler.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCopysender() {
        return copysender;
    }

    public void setCopysender(String copysender) {
        this.copysender = copysender == null ? null : copysender.trim();
    }
}