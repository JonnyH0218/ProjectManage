package com.jhun.dao;

import com.jhun.entity.Download;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DownloadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Download record);

    int insertSelective(Download record);

    Download selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Download record);

    int updateByPrimaryKey(Download record);
    //查询所有
    List<Download> selectAll(Download download);
    //查询总数
    Integer countItem(Download download);
}