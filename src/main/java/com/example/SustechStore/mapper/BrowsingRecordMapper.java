package com.example.SustechStore.mapper;

import com.example.SustechStore.pojo.BrowsingRecord;
import com.example.SustechStore.pojo.BrowsingRecordExample;
import com.example.SustechStore.pojo.BrowsingRecordKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowsingRecordMapper {
    long countByExample(BrowsingRecordExample example);

    int deleteByExample(BrowsingRecordExample example);

    int deleteByPrimaryKey(BrowsingRecordKey key);

    int insert(BrowsingRecord record);

    int insertSelective(BrowsingRecord record);

    List<BrowsingRecord> selectByExample(BrowsingRecordExample example);

    BrowsingRecord selectByPrimaryKey(BrowsingRecordKey key);

    int updateByExampleSelective(@Param("record") BrowsingRecord record, @Param("example") BrowsingRecordExample example);

    int updateByExample(@Param("record") BrowsingRecord record, @Param("example") BrowsingRecordExample example);

    int updateByPrimaryKeySelective(BrowsingRecord record);

    int updateByPrimaryKey(BrowsingRecord record);
}