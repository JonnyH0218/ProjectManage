package com.jhun.service;

import com.jhun.entity.Record;

import javax.servlet.http.HttpServletResponse;

public interface ProjectRecordService {
    //分页查询所有项目记录
    public Object selectRecordByPage(int page , int rows , Record record);
    //添加项目记录
    public String addRecord(Record record);
    //根据id查看项目记录
    public String selectRecordById(Integer id);
    //导出项目记录
    public String exportExcel(String projectName, HttpServletResponse response);
}
