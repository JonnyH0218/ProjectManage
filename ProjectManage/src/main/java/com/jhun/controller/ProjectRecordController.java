package com.jhun.controller;

import com.jhun.entity.Project;
import com.jhun.entity.Record;
import com.jhun.service.ProjectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ProjectRecordController {

    @Autowired
    private ProjectRecordService projectRecordService;

    @RequestMapping("/selectRecordByPage")
    @ResponseBody
    public Object selectRecordByPage(int page ,int rows ,Record record){
        return projectRecordService.selectRecordByPage(page ,rows ,record);
    }

    @RequestMapping("/addRecord")
    public String addRecord(Record record){
        return projectRecordService.addRecord(record);
    }

    @RequestMapping("/selectRecordById")
    @ResponseBody
    public String selectRecordById(Integer id){
        return projectRecordService.selectRecordById(id);
    }

    @RequestMapping("/exportExcel")
    @ResponseBody
    public String exportExcel(String projectName, HttpServletResponse response){
        System.out.println(projectName);
        return projectRecordService.exportExcel(projectName,response);
}
}
