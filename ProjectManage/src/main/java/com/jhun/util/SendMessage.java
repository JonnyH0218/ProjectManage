package com.jhun.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.dingtalk.openapi.demo.Env;
import com.alibaba.dingtalk.openapi.demo.OApiException;
import com.alibaba.dingtalk.openapi.demo.auth.AuthHelper;
import com.alibaba.dingtalk.openapi.demo.department.DepartmentHelper;
import com.alibaba.dingtalk.openapi.demo.message.LightAppMessageDelivery;
import com.alibaba.dingtalk.openapi.demo.message.MessageHelper;
import com.alibaba.dingtalk.openapi.demo.user.UserHelper;
import com.dingtalk.open.client.api.model.corp.CorpUser;
import com.dingtalk.open.client.api.model.corp.CorpUserList;
import com.dingtalk.open.client.api.model.corp.Department;
import com.dingtalk.open.client.api.model.corp.MessageBody;
import com.dingtalk.open.client.api.model.corp.MessageType;

public class SendMessage {
	static int num=1;;
	static Map<String,String> nameAndId;
	static String agentId = Env.AGENT_ID;

	public static void send(String fromUser, String toUser, String content) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(num==1){
			try {
				initUser();
			} catch (Exception e) {
				e.printStackTrace();
			}
			num++;
		}
		LightAppMessageDelivery lightAppMessageDelivery = new LightAppMessageDelivery(
				nameAndId.get(toUser), null, agentId);
	    MessageBody.LinkBody message = new MessageBody.LinkBody();  
	    message.setMessageUrl(Env.messageUrl);  
	    message.setPicUrl("@lALOACZwe2Rk");  
		message.setTitle("来自" + fromUser + "的新消息通知 " + sdf.format(new Date()));
	    message.setText(content); 
		lightAppMessageDelivery.withMessage(MessageType.LINK, message);  
		try {
			MessageHelper.send(AuthHelper.getAccessToken(), lightAppMessageDelivery);//AuthHelper.getAccessToken() 2
		} catch (OApiException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.exit(0);
		return;
	}
	private static Map<String,String> initUser() throws Exception {
		List<Department> departments = new ArrayList<Department>();
		departments = DepartmentHelper.listDepartments(AuthHelper.getAccessToken(), "");//AuthHelper.getAccessToken() 3
		nameAndId=new HashMap<String,String>();
		for(int i = 0;i<departments.size();i++){
            long offset = 0;
            int size = 5;
            CorpUserList corpUserList = new CorpUserList();	           
            while (true) {
                corpUserList = UserHelper.getDepartmentUser(AuthHelper.getAccessToken(), Long.valueOf(departments.get(i).getId())
                		, offset, size, null);//AuthHelper.getAccessToken() 4
                for (int j = 0; j < corpUserList.getUserlist().size(); j++) {
					CorpUser user = corpUserList.getUserlist().get(j);
					nameAndId.put(user.getName(), user.getUserid());
				}
                if (Boolean.TRUE.equals(corpUserList.isHasMore())) {
                    offset += size;
                } else {
                    break;
                }
            }
//			if(corpUserList.getUserlist().size()==0){
//				continue;
//			}
		}
		return nameAndId;
	}
	
	public static void main(String[] args) throws Exception {
		SendMessage.initUser();
	}
}
