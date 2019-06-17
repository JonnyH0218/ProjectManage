package com.jhun.util;

import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.dingtalk.openapi.demo.user.User;
import com.alibaba.dingtalk.openapi.demo.user.UserHelper;
import com.alibaba.fastjson.JSON;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.jhun.dao.RolesMapper;
import com.jhun.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Login {

    @Autowired
    private RolesMapper rolesMapper;

    public  Roles roles;
    public  void getUserInfo(String code, HttpServletRequest request, HttpServletResponse response) {
        roles = new Roles();
        // 获取免登授权码
        System.out.println("authCode:" + code);
        List<Roles> list = new ArrayList<Roles>();

        Date date=new Date();   //这里的时util包下的
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //这是24时
        String currentDate = temp.format(date);

        try {
            String accessToken = AuthHelper.getAccessToken();
            System.out.println("access token:" + accessToken);
            CorpUserDetail user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getUserid());
            String userJson = JSON.toJSONString(user);
            System.out.println("userjson:" + userJson);
            String userName = user.getName();
            list = rolesMapper.selectByUserName(userName);
            if(list == null){
                roles.setUserName(user.getName());
                if (user.getIsAdmin()){
                    roles.setRole("admin");
                }else {
                    roles.setRole("personnel");
                }
                roles.setEmail(user.getEmail());
                rolesMapper.insert(roles);
            }else {
                roles = list.get(0);
                roles.setLastTime(currentDate);
            }
            Cookie cookie1 = new Cookie("user", URLEncoder.encode(roles.getUserName(),
                    "UTF-8"));
            Cookie cookie2 = new Cookie("role",URLEncoder.encode(roles.getRole(),
                    "UTF-8"));
            cookie1.setMaxAge(60*60*24);
            cookie2.setMaxAge(60*60*24);
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            rolesMapper.updateByLastTime(roles);
            System.out.println(roles.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Roles getUser(){
        return roles;
    }

}
