package com.jhun.entity;

import java.util.Date;

public class Message {
    private Integer id;

    private String content;

    private String actionurl;

    private String relationid;

    private String entity;

    private String herfajax;

    private Integer messagereleaseId;

    private String messageState;

    private Integer founderCheck;

    private Integer handlerCheck;

    private String refuseReason;

    private String relationfounder;

    private String messageHandler;

    private String founder;

    private String createTime;

    private String copysender;

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

    public String getActionurl() {
        return actionurl;
    }

    public void setActionurl(String actionurl) {
        this.actionurl = actionurl == null ? null : actionurl.trim();
    }

    public String getRelationid() {
        return relationid;
    }

    public void setRelationid(String relationid) {
        this.relationid = relationid == null ? null : relationid.trim();
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity == null ? null : entity.trim();
    }

    public String getHerfajax() {
        return herfajax;
    }

    public void setHerfajax(String herfajax) {
        this.herfajax = herfajax == null ? null : herfajax.trim();
    }

    public Integer getMessagereleaseId() {
        return messagereleaseId;
    }

    public void setMessagereleaseId(Integer messagereleaseId) {
        this.messagereleaseId = messagereleaseId;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState == null ? null : messageState.trim();
    }

    public Integer getFounderCheck() {
        return founderCheck;
    }

    public void setFounderCheck(Integer founderCheck) {
        this.founderCheck = founderCheck;
    }

    public Integer getHandlerCheck() {
        return handlerCheck;
    }

    public void setHandlerCheck(Integer handlerCheck) {
        this.handlerCheck = handlerCheck;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason == null ? null : refuseReason.trim();
    }

    public String getRelationfounder() {
        return relationfounder;
    }

    public void setRelationfounder(String relationfounder) {
        this.relationfounder = relationfounder == null ? null : relationfounder.trim();
    }

    public String getMessageHandler() {
        return messageHandler;
    }

    public void setMessageHandler(String messageHandler) {
        this.messageHandler = messageHandler == null ? null : messageHandler.trim();
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