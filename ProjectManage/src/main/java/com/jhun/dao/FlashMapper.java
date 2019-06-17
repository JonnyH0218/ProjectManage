package com.jhun.dao;

import com.jhun.entity.Flash;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlashMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Flash record);

    int insertSelective(Flash record);

    Flash selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Flash record);

    int updateByPrimaryKey(Flash record);
    //查询所有
    List<Flash> selectAll(Flash flash);
    //查询总数
    Integer countItem(Flash flash);
}