package com.jhun.dao;

import com.jhun.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    //查询与用户相关的信息
    List<Message> showAllMessageByUser(String userName);
    //查询总数
    Integer countItem(String userName);
}