package com.jhun.dao;

import com.jhun.entity.Equipmentsolution;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentsolutionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipmentsolution record);

    int insertSelective(Equipmentsolution record);

    Equipmentsolution selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipmentsolution record);

    int updateByPrimaryKey(Equipmentsolution record);
}