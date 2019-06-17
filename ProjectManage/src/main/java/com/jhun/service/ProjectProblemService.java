package com.jhun.service;

import com.jhun.entity.Problem;
import com.jhun.entity.Problemsolution;

public interface ProjectProblemService {
    //分页查询所有项目问题
    public Object selectAllProblemByPage(int page , int rows , Problem problem);
    //添加项目问题
    public String addProblem(Problem problem);
    //查看项目问题
    public String findProblemById(Integer id);
    //添加解决方案
    public String addPrlblemSolution(Problemsolution problemsolution);
}
