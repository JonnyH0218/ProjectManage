package com.jhun.dao;

import com.jhun.entity.Personnel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Personnel record);

    int insertSelective(Personnel record);

    Personnel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Personnel record);

    int updateByPrimaryKey(Personnel record);
    //查询所有
    List<Personnel> selectAll(Personnel personnel);
    //查询总数
    Integer countItem(Personnel personnel);
}