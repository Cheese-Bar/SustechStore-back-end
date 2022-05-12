package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.GoodBrief;
import com.example.SustechStore.pojo.Goods;
import com.example.SustechStore.pojo.GoodsExample;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<GoodBrief> selectBriefByOrderNum(
            @Param("orderNum") int orderNum,
            @Param("searchInfo") String searchInfo,
            @Param("state") int state,
            @Param("type") int type,
            @Param("time") Timestamp time);

}