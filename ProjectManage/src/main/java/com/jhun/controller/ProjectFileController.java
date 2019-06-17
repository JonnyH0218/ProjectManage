package com.jhun.controller;

import com.jhun.entity.Download;
import com.jhun.service.ProjectFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProjectFileController {

    @Autowired
    private ProjectFileService projectFileService;

    @RequestMapping("/downloadFiles")
    public void down(HttpServletRequest request, HttpServletResponse response, int id){
        projectFileService.down(request,response,id);
    }

    @RequestMapping("/selectFilesByPage")
    @ResponseBody
    public Object selectRecordByPage(int page , int rows , Download download){
        return projectFileService.selectAllByPage(page ,rows ,download);
    }
}
