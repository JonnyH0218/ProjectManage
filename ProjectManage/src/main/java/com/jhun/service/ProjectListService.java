package com.jhun.service;

import com.github.pagehelper.Page;
import com.jhun.entity.PageBean;
import com.jhun.entity.Project;

import java.util.List;

public interface ProjectListService {
    //查看所有项目列表
    public Object findProjectByPage(int page , int rows  , Project project);
    //根据id查看项目
    public Project findProjectById(Integer id);
    //添加项目
    public String addProject(Project project);
    //查询所有项目
    public List<Project> selectAllProject();

}
