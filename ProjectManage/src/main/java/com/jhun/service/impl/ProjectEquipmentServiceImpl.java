package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.EquipmentMapper;
import com.jhun.dao.FlashMapper;
import com.jhun.entity.Equipment;
import com.jhun.entity.Flash;
import com.jhun.service.ProjectEquipmentService;
import com.jhun.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProjectEquipmentServiceImpl implements ProjectEquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private FlashMapper flashMapper;
    @Autowired
    private Login login;

    @Override
    public Object selectEquipmentRequirementByPage(int page, int rows, Equipment equipment) {
        Page<Equipment> pagebean = PageHelper.startPage(page ,rows);
        List<Equipment> allItems = equipmentMapper.selectAll(equipment);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }

    @Override
    public String addEquipmentRequirement(Equipment equipment) {
        equipment.setFounder(login.getUser().getUserName());
        equipmentMapper.insertSelective(equipment);
        return "success";
    }

    @Override
    public Object selectFlashByPage(int page, int rows, Flash flash) {
        Page<Flash> pagebean = PageHelper.startPage(page ,rows);
        List<Flash> allItems = flashMapper.selectAll(flash);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }

    @Override
    public String addFlash(Flash flash) {
        flash.setFounder(login.getUser().getUserName());
        flashMapper.insertSelective(flash);
        return "success";
    }
}
