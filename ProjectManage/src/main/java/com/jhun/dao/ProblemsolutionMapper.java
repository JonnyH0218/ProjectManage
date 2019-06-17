package com.jhun.dao;

import com.jhun.entity.Problemsolution;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemsolutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problemsolution record);

    int insertSelective(Problemsolution record);

    Problemsolution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problemsolution record);

    int updateByPrimaryKey(Problemsolution record);

    //根据问题id查询解决方案
    Problemsolution selectByProblemId(Integer problemId);
}