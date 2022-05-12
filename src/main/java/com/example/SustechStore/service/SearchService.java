package com.example.SustechStore.service;

import com.example.SustechStore.pojo.GoodBrief;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface SearchService {
    List<Map<String, Object>> searchGoodsByString(Timestamp timestamp, String s, int pageNum, int pageSize);

    List<Map<String, Object>> searchGoodsByStringAndSort(Timestamp timestamp, String s,
                                                         int pageNum, int pageSize, int sortMethod);

    List<GoodBrief> searchGoods(Timestamp timestamp, String s,
                                int pageNum, int pageSize,
                                int orderNum, int goodState, int type);
}
