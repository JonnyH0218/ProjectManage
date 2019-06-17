package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.MessageMapper;
import com.jhun.dao.ProblemMapper;
import com.jhun.dao.ProblemsolutionMapper;
import com.jhun.entity.Message;
import com.jhun.entity.Problem;
import com.jhun.entity.Problemsolution;
import com.jhun.service.ProjectProblemService;
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
public class ProjectProblemServiceImpl implements ProjectProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private ProblemsolutionMapper problemsolutionMapper;
    @Autowired
    private Login login;
    @Autowired
    private SendMail sendMail;
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Object selectAllProblemByPage(int page, int rows, Problem problem) {
        Page<Problem> pagebean  = PageHelper.startPage(page ,rows);
        List<Problem> allItems = problemMapper.selectAllProblemByPage(problem);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }

    @Override
    public String addProblem(Problem problem) {
        problem.setFounder(login.getUser().getUserName());
        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String currentDate = temp.format(date);
        problem.setCreateTime(currentDate);
        problemMapper.insertSelective(problem);
        String content = problem.getFounder()+"发布项目问题:"+problem.getProblemSketch();
        Message message = new Message();
        message.setContent(content);
        message.setCreateTime(currentDate);
        message.setFounder(login.getUser().getUserName());
        message.setMessageHandler(problem.getProblemHandler());
        messageMapper.insertSelective(message);
        SendMessage.send(login.getUser().getUserName(),problem.getProblemHandler(),content);
        sendMail.sendSimpleMail(problem.getProblemHandler(),content);
        return "success";
    }

    @Override
    public String addPrlblemSolution(Problemsolution problemsolution) {
        problemsolution.setFounder(login.getUser().getUserName());
        Problem problem = problemMapper.selectByPrimaryKey(problemsolution.getProblemId());
        if(problem.getProblemHandler().equals(login.getUser().getUserName())){
            problemsolutionMapper.insertSelective(problemsolution);
            problem.setProblemState("已解决");
            Date date=new Date();   //这里的时util包下的
            SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
            String currentDate = temp.format(date);
            problemsolution.setCreateTime(currentDate);
            problemMapper.updateByPrimaryKeySelective(problem);
            String content = problemsolution.getFounder()+"解决了"+problem.getProblemSketch();
            Message message = new Message();
            message.setContent(content);
            message.setCreateTime(currentDate);
            message.setFounder(login.getUser().getUserName());
            message.setMessageHandler(problem.getFounder());
            messageMapper.insertSelective(message);
            SendMessage.send(login.getUser().getUserName(),problem.getFounder(),content);
            sendMail.sendSimpleMail(problem.getFounder(),content);
            return "success";
        }
        return "您不是该问题的处理人，无法提供解决方案";
    }

    @Override
    public String findProblemById(Integer id) {
        Problem problem = problemMapper.selectByPrimaryKey(id);
        Problemsolution problemsolution = problemsolutionMapper.selectByProblemId(id);
        String str = "<h1>问题描述</h1>当前状态："+problem.getProblemState()+
                         "<br/>项目描述："+problem.getProblemDescribe()+
                         "<br/>所属项目："+problem.getProjectName()+
                         "<br/>期待完成时间："+problem.getExpectTime()+
                         "<br/>发布人："+problem.getFounder();

        if(problemsolution != null){
            String content = str+
                    "<h1>问题解决</h1>问题简述："+problemsolution.getProblemSketch()+
                    "<br/>解决方案："+problemsolution.getProblemSolution()+
                    "<br/>创建时间:"+problemsolution.getCreateTime()+
                    "<br/>处理人："+problemsolution.getFounder()
                    ;
            return content;
        }else {
            String content = str+"<br/><a href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" onclick=\"addProblemSolution()\">添加解决方案</a>";
            return content;
        }


    }
}
