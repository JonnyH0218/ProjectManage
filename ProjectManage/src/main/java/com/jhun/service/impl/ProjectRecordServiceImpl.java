package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.MessageMapper;
import com.jhun.dao.ProjectMapper;
import com.jhun.dao.RecordMapper;
import com.jhun.entity.Message;
import com.jhun.entity.Project;
import com.jhun.entity.Record;
import com.jhun.service.ProjectRecordService;
import com.jhun.util.ExportExcel;
import com.jhun.util.Login;
import com.jhun.util.SendMail;
import com.jhun.util.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ProjectRecordServiceImpl implements ProjectRecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private Login login;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private SendMail sendMail;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Object selectRecordByPage(int page, int rows, Record record) {
        Page<Record> pagebean = PageHelper.startPage(page ,rows);
        List<Record> allItems = recordMapper.selectAll(record);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }

    @Override
    public String addRecord(Record record) {
        List<Project> list = projectMapper.selectByProjectName(record.getProjectName());
        record.setFounder(login.getUser().getUserName());
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String currentDate = temp.format(date);
        record.setCreateTime(currentDate);
        record.setProjectCharger(list.get(0).getProjectCharger());
        recordMapper.insertSelective(record);
        String content = login.getUser().getUserName()+"提交项目"+record.getRecordCategory();
        Message message = new Message();
        message.setMessageHandler(record.getProjectCharger());
        message.setFounder(login.getUser().getUserName());
        message.setCreateTime(currentDate);
        message.setContent(content);
        messageMapper.insertSelective(message);
        SendMessage.send(login.getUser().getUserName(),record.getProjectCharger(),content);
        sendMail.sendSimpleMail(record.getProjectCharger(),content);
        return "success";
    }

    @Override
    public String selectRecordById(Integer id) {
        return recordMapper.selectByPrimaryKey(id).getContent();
    }

    @Override
    public String exportExcel(String projectName , HttpServletResponse response) {
        Record record = new Record();
        List<Record> list = recordMapper.selectAll(record);
        if (projectName.equals("") && !login.getUser().getRole().equals("admin")){
            return "您没有权限下载所有项目记录";
        }
        if(!login.getUser().getUserName().equals(list.get(0).getProjectCharger())){
            return "您不是项目主管，无权现在项目记录";
        }
        record.setProjectName(projectName);
        return new ExportExcel().batchExportCount(response,list);
    }
}
