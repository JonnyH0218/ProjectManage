package com.jhun.entity;

import java.util.Date;

public class Image {
    private Integer id;

    private Integer recordId;

    private Integer problemId;

    private Integer equipmentId;

    private Integer equipmentsolutionId;

    private String imagesurl;

    private String imgsha;

    private String attachmenturl;

    private String attachmentsha;

    private Date createTime;

    private Integer productexceptionId;

    private Integer configsystemId;

    private String documenturl;

    private String documentsha;

    private String baturl;

    private String batsha;

    private String databaseurl;

    private String databasesha;

    private Integer instrumentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getEquipmentsolutionId() {
        return equipmentsolutionId;
    }

    public void setEquipmentsolutionId(Integer equipmentsolutionId) {
        this.equipmentsolutionId = equipmentsolutionId;
    }

    public String getImagesurl() {
        return imagesurl;
    }

    public void setImagesurl(String imagesurl) {
        this.imagesurl = imagesurl == null ? null : imagesurl.trim();
    }

    public String getImgsha() {
        return imgsha;
    }

    public void setImgsha(String imgsha) {
        this.imgsha = imgsha == null ? null : imgsha.trim();
    }

    public String getAttachmenturl() {
        return attachmenturl;
    }

    public void setAttachmenturl(String attachmenturl) {
        this.attachmenturl = attachmenturl == null ? null : attachmenturl.trim();
    }

    public String getAttachmentsha() {
        return attachmentsha;
    }

    public void setAttachmentsha(String attachmentsha) {
        this.attachmentsha = attachmentsha == null ? null : attachmentsha.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProductexceptionId() {
        return productexceptionId;
    }

    public void setProductexceptionId(Integer productexceptionId) {
        this.productexceptionId = productexceptionId;
    }

    public Integer getConfigsystemId() {
        return configsystemId;
    }

    public void setConfigsystemId(Integer configsystemId) {
        this.configsystemId = configsystemId;
    }

    public String getDocumenturl() {
        return documenturl;
    }

    public void setDocumenturl(String documenturl) {
        this.documenturl = documenturl == null ? null : documenturl.trim();
    }

    public String getDocumentsha() {
        return documentsha;
    }

    public void setDocumentsha(String documentsha) {
        this.documentsha = documentsha == null ? null : documentsha.trim();
    }

    public String getBaturl() {
        return baturl;
    }

    public void setBaturl(String baturl) {
        this.baturl = baturl == null ? null : baturl.trim();
    }

    public String getBatsha() {
        return batsha;
    }

    public void setBatsha(String batsha) {
        this.batsha = batsha == null ? null : batsha.trim();
    }

    public String getDatabaseurl() {
        return databaseurl;
    }

    public void setDatabaseurl(String databaseurl) {
        this.databaseurl = databaseurl == null ? null : databaseurl.trim();
    }

    public String getDatabasesha() {
        return databasesha;
    }

    public void setDatabasesha(String databasesha) {
        this.databasesha = databasesha == null ? null : databasesha.trim();
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }
}