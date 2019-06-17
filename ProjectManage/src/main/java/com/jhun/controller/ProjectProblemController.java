package com.jhun.controller;

import com.jhun.entity.Problem;
import com.jhun.entity.Problemsolution;
import com.jhun.service.ProjectProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
public class ProjectProblemController {
    @Autowired
    private ProjectProblemService projectProblemService;

    @RequestMapping("/selectAllProblemByPage")
    @ResponseBody
    public Object selectAllProblemByPage(int page , int rows , Problem problem){
        return projectProblemService.selectAllProblemByPage(page ,rows ,problem);
    }

    @RequestMapping("/addProblem")
    @ResponseBody
    public String addProblem(@Valid Problem problem ,BindingResult BindingResult){
        return projectProblemService.addProblem(problem);
    }

    @RequestMapping("/findProblemById")
    @ResponseBody
    public String findProblemById(Integer id){
        return projectProblemService.findProblemById(id);
    }

    @RequestMapping("/addProblemSolution")
    @ResponseBody
    public String addProblemSolution(Problemsolution problemsolution){
        return projectProblemService.addPrlblemSolution(problemsolution);
    }
}
