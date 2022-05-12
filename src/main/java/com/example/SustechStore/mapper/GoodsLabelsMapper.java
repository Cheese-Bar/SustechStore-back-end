package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.GoodsLabelsExample;
import com.example.SustechStore.pojo.GoodsLabelsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsLabelsMapper {
    long countByExample(GoodsLabelsExample example);

    int deleteByExample(GoodsLabelsExample example);

    int deleteByPrimaryKey(GoodsLabelsKey key);

    int insert(GoodsLabelsKey record);

    int insertSelective(GoodsLabelsKey record);

    List<GoodsLabelsKey> selectByExample(GoodsLabelsExample example);

    int updateByExampleSelective(@Param("record") GoodsLabelsKey record, @Param("example") GoodsLabelsExample example);

    int updateByExample(@Param("record") GoodsLabelsKey record, @Param("example") GoodsLabelsExample example);
}