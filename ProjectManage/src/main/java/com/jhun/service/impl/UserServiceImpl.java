package com.jhun.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhun.dao.MessageMapper;
import com.jhun.dao.RolesMapper;
import com.jhun.entity.Message;
import com.jhun.entity.Roles;
import com.jhun.service.UserService;
import com.jhun.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private Login login;

    @Override
    public Object selectAllUserBypage(int page ,int rows ,Roles roles) {
        Page<Roles> pagebean = PageHelper.startPage(page,rows);
        List<Roles> allItems = rolesMapper.selectAll(roles);
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }

    @Override
    public Object showAllMessageByUser(int page, int rows) {
        Page<Message> pagebean = PageHelper.startPage(page,rows);
        List<Message> allItems = messageMapper.showAllMessageByUser(login.getUser().getUserName());
        HashMap<String ,Object> map = new HashMap<>();
        map.put("rows" ,allItems);
        map.put("total" ,pagebean.getTotal());
        return map;
    }
}
