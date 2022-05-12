package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.Classification;
import com.example.SustechStore.pojo.ClassificationExample;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationMapper {

    List<Map<String,Object>> findGoodByCat(@Param("cat_id") int cat_id, @Param("t") Timestamp t,@Param("type")int type);
    List<String> findGood_icon(int id);
    long countByExample(ClassificationExample example);

    int deleteByExample(ClassificationExample example);

    int deleteByPrimaryKey(Integer classificationId);

    int insert(Classification record);

    int insertSelective(Classification record);

    List<Classification> selectByExample(ClassificationExample example);

    Classification selectByPrimaryKey(Integer classificationId);

    int updateByExampleSelective(@Param("record") Classification record, @Param("example") ClassificationExample example);

    int updateByExample(@Param("record") Classification record, @Param("example") ClassificationExample example);

    int updateByPrimaryKeySelective(Classification record);

    int updateByPrimaryKey(Classification record);
}