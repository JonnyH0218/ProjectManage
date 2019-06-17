package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.MessageMapper;
import com.jhun.dao.PersonnelMapper;
import com.jhun.dao.ProjectMapper;
import com.jhun.entity.Message;
import com.jhun.entity.Personnel;
import com.jhun.service.ProjectPersonnelService;
import com.jhun.util.Login;
import com.jhun.util.SendMail;
import com.jhun.util.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ProjectPersonnelServiceImpl implements ProjectPersonnelService {
    @Autowired
    private PersonnelMapper personnelMapper;
    @Autowired
    private Login login;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private SendMail sendMail;

    @Override
    public Object selectPersonnelByPage(int page, int rows, Personnel personnel) {
        Page<Personnel> pagebean = PageHelper.startPage(page ,rows);
        List<Personnel> allItems = personnelMapper.selectAll(personnel);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }

    @Override
    public String addPersonnel(Personnel personnel) {
        String name = projectMapper.selectByProjectName(personnel.getProjectName()).get(0).getProjectCharger();
        if (login.getUser().getUserName().equals(name) || login.getUser().getRole().equals("admin")){
            personnel.setFounder(login.getUser().getUserName());
            Date date=new Date();   //这里的时util包下的
            SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
            String currentDate = temp.format(date);
            personnel.setCreateTime(currentDate);
            String content = personnel.getFounder()+"添加了项目人员"+personnel.getPersonnelName();
            Message message = new Message();
            message.setContent(content);
            message.setCreateTime(currentDate);
            message.setFounder(login.getUser().getUserName());
            message.setMessageHandler(personnel.getPersonnelName());
            messageMapper.insertSelective(message);
            SendMessage.send(login.getUser().getUserName(),personnel.getPersonnelName(),content);
            sendMail.sendSimpleMail(personnel.getPersonnelName(),content);
            personnelMapper.insertSelective(personnel);
            return "success";
        }
        return "您无法添加项目人员，因为没有该权限";

    }

    @Override
    public String deletePersonnel(Integer id) {
        Personnel personnel = personnelMapper.selectByPrimaryKey(id);
        String name = projectMapper.selectByProjectName(personnel.getProjectName()).get(0).getProjectCharger();
        if (login.getUser().getUserName().equals(name) || login.getUser().getRole().equals("admin")){
            personnelMapper.deleteByPrimaryKey(id);
            String content = login.getUser().getUserName()+"删除了项目人员"+personnel.getPersonnelName();
            Date date=new Date();   //这里的时util包下的
            SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
            String currentDate = temp.format(date);
            Message message = new Message();
            message.setContent(content);
            message.setCreateTime(currentDate);
            message.setFounder(login.getUser().getUserName());
            message.setMessageHandler(personnel.getPersonnelName());
            messageMapper.insertSelective(message);
            SendMessage.send(login.getUser().getUserName(),personnel.getPersonnelName(),content);
            sendMail.sendSimpleMail(personnel.getPersonnelName(),content);
            return "success";
        }
        return "您没有权限删除该人员";
    }
}
