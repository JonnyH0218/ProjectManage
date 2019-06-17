package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.MessageMapper;
import com.jhun.dao.ProjectMapper;
import com.jhun.entity.Message;
import com.jhun.entity.PageBean;
import com.jhun.entity.Project;
import com.jhun.service.ProjectListService;
import com.jhun.util.Login;
import com.jhun.util.SendMail;
import com.jhun.util.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectListServiceImpl implements ProjectListService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private Login login;
    @Autowired
    private SendMail sendMail;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Object findProjectByPage(int page, int rows, Project project) {//分页查询项目
        Page<Project> pagebean = PageHelper.startPage(page, rows);
        List<Project> allItems = projectMapper.selectAll(project);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", allItems);
        map.put("total", pagebean.getTotal());
        return map;
    }

    @Override
    public String addProject(Project project) {
        project.setFounder(login.getUser().getUserName());
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String currentDate = temp.format(date);
        project.setCreatTime(currentDate);
        projectMapper.insertSelective(project);
        String content = project.getFounder()+"新建项目："+project.getProjectName();
        Message message = new Message();
        message.setContent(content);
        message.setCreateTime(currentDate);
        message.setFounder(login.getUser().getUserName());
        message.setMessageHandler(project.getProjectCharger());
        messageMapper.insertSelective(message);
        SendMessage.send(login.getUser().getUserName(),project.getProjectCharger(),content);
        sendMail.sendSimpleMail(project.getProjectCharger(),content);
        if (!login.getUser().getUserName().equals(project.getFounder())){
            SendMessage.send(login.getUser().getUserName(),login.getUser().getUserName(),content);
            sendMail.sendSimpleMail(login.getUser().getUserName(),content);
        }
        return "success";
    }

    @Override
    public Project findProjectById(Integer id) {//根据id查看项目
        Project project = projectMapper.selectByPrimaryKey(id);
        return project;
    }

    @Override
    public List<Project> selectAllProject() {
        Project project = new Project();
        return projectMapper.selectAll(project);
    }

}
