package com.jhun.service;


import com.jhun.entity.Equipment;
import com.jhun.entity.Flash;

public interface ProjectEquipmentService {
    //分页查询所有设备需求
    public Object selectEquipmentRequirementByPage(int page , int rows , Equipment equipment);
    //添加设备需求
    public String addEquipmentRequirement(Equipment equipment);
    //分页查询所有穿梭车
    public Object selectFlashByPage(int page , int rows , Flash flash);
    //添加穿梭车
    public String addFlash(Flash flash);
}
