package com.jhun.util;

import com.jhun.dao.RolesMapper;
import com.jhun.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Component
public class SendMail {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private RolesMapper rolesMapper;
    @Value("${spring.mail.username}")
    private String Sender;

    public String sendSimpleMail(String userName ,String content) {
        List<Roles> roles = null;
        roles = rolesMapper.selectByUserName(userName);
        if(roles == null){
            return "邮件发送失败，该用户尚未登陆过项目管理系统";
        }else {
            MimeMessage mm = this.mailSender.createMimeMessage();
            MimeMessageHelper mmh = null;
            SimpleMailMessage smm = new SimpleMailMessage();
            try {
                mmh = new MimeMessageHelper(mm, true, "UTF-8");
                mmh.setFrom(Sender);
                mmh.setSubject("项目管理系统信息通知");
                mmh.setTo(roles.get(0).getEmail());
                mmh.setText("<h1>"+content+"<h1>", true);
                this.mailSender.send(mm);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "success";
        }
    }

}
