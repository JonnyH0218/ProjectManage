package com.jhun.entity;

import java.util.Date;

public class Messagerelease {
    private Integer id;

    private String content;

    private String actionurl;

    private String relationid;

    private Integer herfajax;

    private Integer showhide;

    private String founder;

    private Date createTime;

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

    public Integer getHerfajax() {
        return herfajax;
    }

    public void setHerfajax(Integer herfajax) {
        this.herfajax = herfajax;
    }

    public Integer getShowhide() {
        return showhide;
    }

    public void setShowhide(Integer showhide) {
        this.showhide = showhide;
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
}