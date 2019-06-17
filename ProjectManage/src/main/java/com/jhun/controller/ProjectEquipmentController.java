package com.jhun.controller;

import com.jhun.entity.Equipment;
import com.jhun.entity.Flash;
import com.jhun.service.ProjectEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectEquipmentController {
    @Autowired ProjectEquipmentService projectEquipmentService;

    @RequestMapping("/selectEquipmentRequirementByPage")
    @ResponseBody
    public Object selectEquipmentRequirementByPage(int page ,int rows ,Equipment equipment){
        return projectEquipmentService.selectEquipmentRequirementByPage(page ,rows ,equipment);
    }

    @RequestMapping("/addEquipmentRequirement")
    public String addEquipmentRequirement(Equipment equipment){
        return projectEquipmentService.addEquipmentRequirement(equipment);
    }

    @RequestMapping("/selectFlashByPage")
    @ResponseBody
    public Object selectFlashByPage(int page , int rows , Flash flash){
        return projectEquipmentService.selectFlashByPage(page ,rows ,flash);
    }

    @RequestMapping("/addFlash")
    public String addFlash(Flash flash){
        return projectEquipmentService.addFlash(flash);
    }
}
