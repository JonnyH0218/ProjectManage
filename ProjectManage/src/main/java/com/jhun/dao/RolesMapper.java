package com.jhun.dao;

import com.jhun.entity.Roles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);

    //根据用户名查询
    List<Roles> selectByUserName(String userName);

    //查询所有
    List<Roles> selectAll(Roles roles);
    //查询总数
    Integer countItem(Roles roles);
    //更新最近登陆时间
    int updateByLastTime(Roles roles);
}