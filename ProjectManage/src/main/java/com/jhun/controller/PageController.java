package com.jhun.controller;

import com.jhun.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {
    @Autowired
    private Login login;

    //手机端登陆首页
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //PC端登陆首页
    @RequestMapping(value = "/indexPC")
    public String indexPC(){
        return "indexPC";
    }

    //项目列表
    @RequestMapping("/projectList")
    public String projectList(){return "projectList";}

    //用户列表
    @RequestMapping("/userList")
    public String userList(){
        return "userList";
    }

    //项目问题
    @RequestMapping("/projectProblem")
    public String projectProblem(){
        return "projectProblem";
    }

    //设备需求
    @RequestMapping("/projectEquipment")
    public String projectEquipment(){
        return "projectEquipment";
    }

    //项目人员
    @RequestMapping("/projectPersonnel")
    public String projectPersonnel(){
        return "projectPersonnel";
    }

    //项目记录
    @RequestMapping("/projectRecord")
    public String projectRecord(){
        return "projectRecord";
    }

    //用户登录
    @RequestMapping("/login")
    public void login(String code, HttpServletRequest request, HttpServletResponse response){
        System.out.println("authCode:" + code);
        login.getUserInfo(code,request,response);
        System.out.println(login.getUser().getUserName());
    }

    //消息列表
    @RequestMapping("/messagelist")
    public String messagelist(){
        return "messagelist";
    }

    //文档下载
    @RequestMapping("/download")
    public String download(){
        return "download";
    }

}
