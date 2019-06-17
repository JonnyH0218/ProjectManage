package com.jhun.dao;

import com.jhun.entity.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKeyWithBLOBs(Record record);

    int updateByPrimaryKey(Record record);

    //查询所有
    List<Record> selectAll(Record record);
    //查询总数
    Integer countItem(Record record);
}