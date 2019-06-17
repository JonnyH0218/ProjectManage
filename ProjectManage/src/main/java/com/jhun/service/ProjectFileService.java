package com.jhun.service;

import com.jhun.entity.Download;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ProjectFileService {

    public void down(HttpServletRequest request, HttpServletResponse response, int id);

    //查看所有项目列表
    public Object selectAllByPage(int page , int rows  , Download download);
}
