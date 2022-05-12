package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.Labels;
import com.example.SustechStore.pojo.LabelsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelsMapper {
    long countByExample(LabelsExample example);

    int deleteByExample(LabelsExample example);

    int deleteByPrimaryKey(Integer labelsId);

    int insert(Labels record);

    int insertSelective(Labels record);

    List<Labels> selectByExample(LabelsExample example);

    Labels selectByPrimaryKey(Integer labelsId);

    int updateByExampleSelective(@Param("record") Labels record, @Param("example") LabelsExample example);

    int updateByExample(@Param("record") Labels record, @Param("example") LabelsExample example);

    int updateByPrimaryKeySelective(Labels record);

    int updateByPrimaryKey(Labels record);

    List<Labels> selectAll();
}