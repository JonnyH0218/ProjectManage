package com.jhun.service;

import com.jhun.entity.Personnel;

public interface ProjectPersonnelService {
    //项目人员分页查询
    public Object selectPersonnelByPage(int page , int rows , Personnel personnel);
    //添加项目人员
    public String addPersonnel(Personnel personnel);
    //删除项目人员
    public String deletePersonnel(Integer id);
}
