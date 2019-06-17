package com.jhun.dao;

import com.jhun.entity.Problem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKey(Problem record);
    //查询所有
    List<Problem> selectAllProblemByPage(Problem problem);
    //查询总数
    int countItem(Problem problem);
}