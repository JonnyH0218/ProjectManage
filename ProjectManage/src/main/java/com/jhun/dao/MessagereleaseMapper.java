package com.jhun.dao;

import com.jhun.entity.Messagerelease;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagereleaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Messagerelease record);

    int insertSelective(Messagerelease record);

    Messagerelease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messagerelease record);

    int updateByPrimaryKey(Messagerelease record);
}