package com.jhun.controller;

import com.jhun.entity.Project;
import com.jhun.service.ProjectListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectListController {
    @Autowired
    private ProjectListService projectListService;

    @RequestMapping("/findProjectById")
    @ResponseBody
    public Project findProjectById(Integer id){
        return projectListService.findProjectById(id);
    }

    @RequestMapping("/findProjectByPage")
    @ResponseBody
    public Object findProjectByPage(int page , int rows , Project project){
        return projectListService.findProjectByPage(page ,rows ,project);
    }

    @RequestMapping("/addProject")
    @ResponseBody
    public String addProject(@Valid Project project, BindingResult BindingResult){
        return projectListService.addProject(project);
    }

    @RequestMapping("/selectAllProject")
    @ResponseBody
    public List<Project> selectAllProject(){
        return projectListService.selectAllProject();
    }
}
