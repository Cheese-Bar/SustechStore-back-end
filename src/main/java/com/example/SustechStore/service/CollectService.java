package com.example.SustechStore.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface CollectService {
    List<Map<String, Object>> getFavorite(Timestamp timestamp, int userId, int pageNum, int pageSize,
                                          int orderNum, int goodState, int type);
    List<Map<String, Object>> getFootPrint(Timestamp timestamp, int userId, int pageNum, int pageSize,
                                           int orderNum, int goodState, int type);
    boolean updateFavorite(int userId, int goodId);

    boolean deleteGood(int userId,int goodId);

    boolean resubmitGood(int userId, int goodId);

    Map<String, Object> collectInit(Timestamp timestamp, int userId);
}
