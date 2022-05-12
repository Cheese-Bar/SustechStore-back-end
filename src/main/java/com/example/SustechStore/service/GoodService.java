package com.example.SustechStore.service;


import com.example.SustechStore.pojo.Goods;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface GoodService {
    List<Map<String,Object>> findMyRelease(int id,int pageNum,int pageSize,Timestamp timestamp,int type,int orderNum, int goodState);
    List<Map<String, Object>> selectGoodByPage(Timestamp timestamp, int pageNum, int pageSize);
    Map<String,Object> findGoodDetail(int user_id,int good_id);
    List<Map<String, Object>> transGoodToBrief(List<Goods> goodsList);
    boolean deleteGood(int goodsId);



}
