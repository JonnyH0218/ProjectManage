package com.jhun.dao;

import com.jhun.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
    //查询所有
    List<Project> selectAll(Project project);
    //查询总数
    Integer countItem(Project project);
    //根据项目名查询
    List<Project> selectByProjectName(String projectName);
}