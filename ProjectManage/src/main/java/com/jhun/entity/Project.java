package com.jhun.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Project {
    private Integer id;

    private String projectName;

    private String signAdress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signTime;

    private Date confirmTime;

    private Date finishTime;

    private Date productionStarttime;

    private Date productionEndtime;

    private Date approachTime;

    private Date installTime;

    private Date alonedebugStarttime;

    private Date alonedebugEndtime;

    private Date onlinedebugStarttime;

    private Date accompanyStarttime;

    private Date accompanyEndtime;

    private Date checkStarttime;

    private Date checkEndtime;

    private String projectState;

    private String projectCharger;

    private String founder;

    private String creatTime;

    private Integer reguireFlashtotal;

    private Integer reguireLifttotal;

    private String projectDescribe;

    private String implementationAddress;

    private String customer;

    private String customerContact;

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

    public String getSignAdress() {
        return signAdress;
    }

    public void setSignAdress(String signAdress) {
        this.signAdress = signAdress == null ? null : signAdress.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getProductionStarttime() {
        return productionStarttime;
    }

    public void setProductionStarttime(Date productionStarttime) {
        this.productionStarttime = productionStarttime;
    }

    public Date getProductionEndtime() {
        return productionEndtime;
    }

    public void setProductionEndtime(Date productionEndtime) {
        this.productionEndtime = productionEndtime;
    }

    public Date getApproachTime() {
        return approachTime;
    }

    public void setApproachTime(Date approachTime) {
        this.approachTime = approachTime;
    }

    public Date getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    public Date getAlonedebugStarttime() {
        return alonedebugStarttime;
    }

    public void setAlonedebugStarttime(Date alonedebugStarttime) {
        this.alonedebugStarttime = alonedebugStarttime;
    }

    public Date getAlonedebugEndtime() {
        return alonedebugEndtime;
    }

    public void setAlonedebugEndtime(Date alonedebugEndtime) {
        this.alonedebugEndtime = alonedebugEndtime;
    }

    public Date getOnlinedebugStarttime() {
        return onlinedebugStarttime;
    }

    public void setOnlinedebugStarttime(Date onlinedebugStarttime) {
        this.onlinedebugStarttime = onlinedebugStarttime;
    }

    public Date getAccompanyStarttime() {
        return accompanyStarttime;
    }

    public void setAccompanyStarttime(Date accompanyStarttime) {
        this.accompanyStarttime = accompanyStarttime;
    }

    public Date getAccompanyEndtime() {
        return accompanyEndtime;
    }

    public void setAccompanyEndtime(Date accompanyEndtime) {
        this.accompanyEndtime = accompanyEndtime;
    }

    public Date getCheckStarttime() {
        return checkStarttime;
    }

    public void setCheckStarttime(Date checkStarttime) {
        this.checkStarttime = checkStarttime;
    }

    public Date getCheckEndtime() {
        return checkEndtime;
    }

    public void setCheckEndtime(Date checkEndtime) {
        this.checkEndtime = checkEndtime;
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState == null ? null : projectState.trim();
    }

    public String getProjectCharger() {
        return projectCharger;
    }

    public void setProjectCharger(String projectCharger) {
        this.projectCharger = projectCharger == null ? null : projectCharger.trim();
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder == null ? null : founder.trim();
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getReguireFlashtotal() {
        return reguireFlashtotal;
    }

    public void setReguireFlashtotal(Integer reguireFlashtotal) {
        this.reguireFlashtotal = reguireFlashtotal;
    }

    public Integer getReguireLifttotal() {
        return reguireLifttotal;
    }

    public void setReguireLifttotal(Integer reguireLifttotal) {
        this.reguireLifttotal = reguireLifttotal;
    }

    public String getProjectDescribe() {
        return projectDescribe;
    }

    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe == null ? null : projectDescribe.trim();
    }

    public String getImplementationAddress() {
        return implementationAddress;
    }

    public void setImplementationAddress(String implementationAddress) {
        this.implementationAddress = implementationAddress == null ? null : implementationAddress.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact == null ? null : customerContact.trim();
    }
}