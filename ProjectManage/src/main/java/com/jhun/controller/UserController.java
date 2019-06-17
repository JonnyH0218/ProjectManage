package com.jhun.controller;

import com.jhun.entity.Roles;
import com.jhun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showAllMessageByUser")
    @ResponseBody
    public Object showAllMessageByUser(int page ,int rows){
        return userService.showAllMessageByUser(page ,rows);
    }

    @RequestMapping("/selectAllUserByPage")
    @ResponseBody
    public Object selectAllUserByPage(int page ,int rows ,Roles roles){
        return userService.selectAllUserBypage(page ,rows ,roles);
    }
}
