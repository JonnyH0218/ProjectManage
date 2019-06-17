package com.jhun.dao;

import com.jhun.entity.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
    //查询所有
    List<Equipment> selectAll(Equipment equipment);
    //查询总数
    Integer countItem(Equipment equipment);
}