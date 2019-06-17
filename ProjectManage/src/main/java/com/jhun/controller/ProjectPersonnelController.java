package com.jhun.controller;

import com.jhun.entity.Personnel;
import com.jhun.service.ProjectPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProjectPersonnelController {
    @Autowired
    private ProjectPersonnelService projectPersonnelService;

    @RequestMapping("/selectPersonnelByPage")
    @ResponseBody
    public Object selectPersonnelByPage(int page , int rows , Personnel personnel){
        return projectPersonnelService.selectPersonnelByPage(page ,rows ,personnel);
    }

    @RequestMapping("/addPersonnel")
    @ResponseBody
    public String addPersonnel(Personnel personnel){
        return projectPersonnelService.addPersonnel(personnel);
    }

    @RequestMapping("/deletePersonnel")
    @ResponseBody
    public String deletePersonnel(Integer id){
        return projectPersonnelService.deletePersonnel(id);
    }
}
